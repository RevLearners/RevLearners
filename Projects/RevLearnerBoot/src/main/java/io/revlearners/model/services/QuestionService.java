package io.revlearners.model.services;

import com.fasterxml.jackson.annotation.JsonView;
import io.revlearners.model.bean.*;
import io.revlearners.model.dao.interfaces.IAttemptRepository;
import io.revlearners.model.dao.interfaces.IChallengeRepository;
import io.revlearners.model.dao.interfaces.IQuestionRepository;
import io.revlearners.model.jsonview.Views;
import io.revlearners.model.services.interfaces.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuestionService extends CrudService<Question> implements IQuestionService {

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
     *
     * @param attempt
     * @return
     */
    @Override
    public float scoreChallenge(ChallengeAttempt attempt) {
        // fetch from db to get questions
        Challenge challenge = challengeRepo.findOne(attempt.getChallenge().getId());

        Set<Question> questions = challenge.getQuiz().getQuestions();
        Set<QuestionOption> options = attempt.getAnswers();
        float score = scoreAll(questions, distillOptions(options));
        attempt.setScore(score);
        attemptRepo.save(attempt);
        return score;
    }

    private Map<Long, Set<QuestionOption>> distillOptions(Set<QuestionOption> flattened) {
        Map<Long, Set<QuestionOption>> distilled = new HashMap<>();
        for (QuestionOption option : flattened) {
            if (!distilled.containsKey(option.getId()))
                distilled.put(option.getId(), new HashSet<>());
            distilled.get(option.getId()).add(option);
        }
        return distilled;
    }

    /**
     * calculates the score given a set answered questions
     * assumes only one question is correct per question
     *
     * @param questions
     * @return
     */
    private float scoreAll(Set<Question> questions, Map<Long, Set<QuestionOption>> selected) {
        float score = 0;
        for (Question q : questions) {
            Set<QuestionOption> selectedForQ = selected.get(q.getId());
            Question referenceQ = questionRepo.findOne(q.getId());
            score += scoreOne(q, selectedForQ, referenceQ);
        }
        return score;
    }

    /**
     * assumes each question only has one correct option; can be easily extended later
     *
     * @param question
     * @param selectedOptions
     * @param reference
     * @return
     */
    private float scoreOne(Question question, Set<QuestionOption> selectedOptions, Question reference) {
        QuestionOption selected = new ArrayList<>(selectedOptions).get(0);
        boolean answeredCorrectly = reference.getOptions().stream()
                .anyMatch(option -> option.isCorrect() && option.getId().equals(selected.getId()));

        if (answeredCorrectly)
            return question.getDifficulty().getMultiplier() * question.getType().getBaseVal();

        return 0;
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
        return new ArrayList<>(challengeRepo.getByUsersContaining(user));
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
