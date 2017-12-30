package io.revlearners.model.services;

import com.fasterxml.jackson.annotation.JsonView;
import io.revlearners.model.bean.*;
import io.revlearners.model.dao.interfaces.IAttemptRepository;
import io.revlearners.model.dao.interfaces.IChallengeRepository;
import io.revlearners.model.dao.interfaces.IQuestionRepository;
import io.revlearners.model.jsonview.Views;
import io.revlearners.model.services.interfaces.IChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ChallengeService extends CrudService<Question> implements IChallengeService {

    @Autowired
    IChallengeRepository challengeRepo;

    @Autowired
    IAttemptRepository attemptRepo;

    @Autowired
    IQuestionRepository questionRepo;


    /**
     * save a given question
     *
     * @param question
     * @return
     */
    @Override
    public Question saveQuestion(Question question) {
        return questionRepo.save(question);
    }

    /**
     * answers map maps question id to the list of selected answers for said id
     * the received attempt is nothing but a shell; have to fetch questions from db
     * to get access to correct options, difficulty, etc
     * <p>
     * for now only one answer can be selected for a question
     *
     * @param attempt
     * @return
     */
    @Override
    public float submitChallengeAttempt(ChallengeAttempt attempt) {
        Set<Question> questions = attempt.getChallenge().getQuiz().getQuestions();
        Set<QuestionOption> options = attempt.getAnswers();
        float score = scoreAll(questions, distillOptions(options));
        attempt.setScore(score);
        attemptRepo.save(attempt);
        return score;
    }

    /**
     * separates list of questions into a map of question to selected answers list
     * @param flattened
     * @return
     */
    private Map<Long, List<QuestionOption>> distillOptions(Set<QuestionOption> flattened) {

        Map<Long, List<QuestionOption>> questionAnswersMap = new HashMap<>();
        for (QuestionOption option : flattened) {
            Long qId = option.getQuestion().getId();
            if (!questionAnswersMap.containsKey(qId))
                questionAnswersMap.put(qId, new ArrayList<>());
            questionAnswersMap.get(qId).add(option);
        }
        return questionAnswersMap;
    }


    /**
     * calculates the score given a set answered questions
     * assumes only one question is correct per question
     *
     * @param quizQuestions
     * @return
     */
    private float scoreAll(Set<Question> quizQuestions, Map<Long, List<QuestionOption>> selected) {
        float score = 0;
        for (Question q : quizQuestions) {
            List<QuestionOption> selectedForQ = selected.get(q.getId());
            if (selectedForQ != null) {     // unanswered questions are skipped
                score += scoreOne(q, selectedForQ);
            }
        }
        return score;
    }

    /**
     * assumes each question only has one correct option; can be easily extended later
     *
     * @param question
     * @param selectedOptions
     * @return
     */
    private float scoreOne(Question question, List<QuestionOption> selectedOptions) {
        QuestionOption selected = selectedOptions.get(0);   // todo: only one answer selected for now
        boolean answeredCorrectly = question .getOptions().stream()
                .anyMatch(option -> option.isCorrect() && option.getId().equals(selected.getId()));

        if (answeredCorrectly)
            return question.getDifficulty().getMultiplier() * question.getType().getBaseVal();

        return 0;
    }

    private float calculateMaxScore(Set<Question> questions) {
        float score = 0;
        for (Question q: questions)
            score += q.getDifficulty().getMultiplier() * q.getType().getBaseVal();
        return score;
    }

    /**
     * generates a random list of questions in the specified topic;
     * <d>options are shuffled for each question</d> can't shuffle sets
     * <p>
     * todo: why does the return challenge return user with all nulls
     * except for the id, instead of reloading the members for the saved
     * attempt(including the users)
     *
     * @param info
     * @return
     */
    @Override
    public Challenge generateChallenge(ChallengeInfo info) {
        Set<Question> questions = questionRepo.generateQuestions(info.topicId, info.numQuestions);
        Quiz quiz = new Quiz(questions, LocalDateTime.now());
        quiz.setMaxScore(calculateMaxScore(questions));

        Set<User> users = info.getReceiverIds().stream()
                .map(id -> {
                    User u = new User();
                    u.setId(id);
                    return u;
                }).collect(Collectors.toSet());

        Challenge challenge = new Challenge(quiz, users);
        return challengeRepo.saveAndFlush(challenge);
    }

    @Override
    public List<Challenge> getChallengesByUser(long userId) {
        User user = new User();
        user.setId(userId);
        return new ArrayList<>(challengeRepo.getByUsersContains(user));
    }


    @Override
    public Challenge getChallengeById(long id) {
        Challenge res = challengeRepo.findOne(id);
        return res;
    }

    @Override
    public List<ChallengeAttempt> getChallengeAttemptsByUser(long challengeId, long userId) {
        User user = new User();
        user.setId(challengeId);
        Challenge challenge = new Challenge();
        challenge.setId(userId);
        return new ArrayList<>(attemptRepo.getByUserAndChallenge(user, challenge));
    }


    public static class ChallengeInfo {
        @JsonView({Views.ToBackEnd.class})
        private int topicId;

        @JsonView({Views.ToBackEnd.class})
        private long senderId;

        @JsonView({Views.ToBackEnd.class})
        private List<Long> receiverIds;

        @JsonView({Views.ToBackEnd.class})
        private int numQuestions;

        public int getTopicId() {
            return topicId;
        }

        public void setTopicId(int topicId) {
            this.topicId = topicId;
        }

        public long getSenderId() {
            return senderId;
        }

        public void setSenderId(long senderId) {
            this.senderId = senderId;
        }

        public List<Long> getReceiverIds() {
            return receiverIds;
        }

        public void setReceiverIds(List<Long> receiverIds) {
            this.receiverIds = receiverIds;
        }

        public int getNumQuestions() {
            return numQuestions;
        }

        public void setNumQuestions(int numQuestions) {
            this.numQuestions = numQuestions;
        }
    }
}
