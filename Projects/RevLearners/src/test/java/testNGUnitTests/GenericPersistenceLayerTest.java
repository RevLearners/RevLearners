
package testNGUnitTests;

import java.time.LocalDateTime;
import java.util.*;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.revlearners.model.bean.*;
import io.revlearners.util.commons.configs.Constants;
import preTestScripts.DBInit;

// Tests are enabled and disabled as needed to improve performance 
public class GenericPersistenceLayerTest extends PersistenceLayerTest {

    private Session session = null;

    private Long quizId;
    private Long questId;
    private Long userId;
    private Long receiverId;

    @BeforeClass
    public final void before() {
        DBInit.create(sf);
        session = sf.openSession();
    }

    @AfterClass
    public final void after() {
        session.close();
    }

    @Test(priority = 1)
    @Transactional
    public void readTopicTest() {
        Topic topic = service.fetchSubTypeById(Topic.class, Constants.TOPIC_CORE_JAVA);
        System.out.println(topic);
    }

    @Test(priority = 1)
    @Transactional
    public void userInsertTest() {
        session.beginTransaction();
        UserStatus us = service.fetchSubTypeById(UserStatus.class, Constants.STATUS_PENDING);
        UserRole ur = service.fetchSubTypeById(UserRole.class, Constants.ROLE_BASIC);
        User user = new User("John", null, "Doe", us, ur, "mail@email.com", "aUsername", "password",
                "this is a salt, a really bad salt, but a salt none the less");
        initUserRanks(user);
        userId = (Long) service.create(user);
        session.getTransaction().commit();

    }

    @Test(priority = 1)
    @Transactional
    public void insertReceiverTest() {
        session.beginTransaction();
        UserStatus us = service.fetchSubTypeById(UserStatus.class, Constants.STATUS_PENDING);
        UserRole ur = service.fetchSubTypeById(UserRole.class, Constants.ROLE_BASIC);
        User user = new User("Jane", null, "Bobbert", us, ur, "mail2@email2.com", "aU2se2rname", "password2", "salt2");
        initUserRanks(user);
        receiverId = (Long) service.create(user);
        session.getTransaction().commit();
    }

    public void initUserRanks(User user) {  // todo: add to user service
        Set<Topic> topics = new HashSet<>(service.fetchAllSubTypes(Topic.class));
        for (Topic t : topics) {
            Rank rank = t.getRankByWeight(1L);

            // Not all the topics have been implemented yet
            Set<UserRank> userRanks = new HashSet<>();
            if (rank != null) {
                UserRank utr = new UserRank(user, rank, rank.getMeritThreshold());
                userRanks.add(utr);
            }
            user.setRanks(userRanks);
        }
    }

    @Test()
    @Transactional
    public void questionInsertTest() {
        session.beginTransaction();
        Topic topic = service.fetchSubTypeById(Topic.class, Constants.TOPIC_CORE_JAVA);
        QuestionType type = service.fetchSubTypeById(QuestionType.class, Constants.QUESTION_TRUE_FALSE);
        QuestionDifficulty diff = service.fetchSubTypeById(QuestionDifficulty.class, Constants.DIFFICULTY_EASY);
        Question quest = new Question(topic, type, diff, "Is the answer to life 42?", null);

        Set<QuestionOption> opts = new HashSet<>();
        opts.add(new QuestionOption(quest, "True", true));
        opts.add(new QuestionOption(quest, "False", false));
        quest.setOptions(opts);

        questId = (Long) service.create(quest);
        session.getTransaction().commit();
    }

    @Test(dependsOnMethods = "questionInsertTest")
    @Transactional
    public void quizInsertTest() {
        Set<Question> quests;
        Quiz quiz, quiz2;

        session.beginTransaction();
        quests = new HashSet<>(service.fetchAllSubTypes(Question.class));
        quiz = new Quiz(quests, LocalDateTime.now());

        quests = new HashSet<>(service.fetchAllSubTypes(Question.class));
        quiz2 = new Quiz(quests, LocalDateTime.now());

        quizId = (Long) service.create(quiz);
        service.create(quiz2);
        session.getTransaction().commit();
    }


    @Test(dependsOnMethods = {"quizInsertTest", "userInsertTest"})
    @Transactional
    public void challengeAttemptTest() {
        session.beginTransaction();
        Random rand = new Random();
        Challenge challenge;

        // Get quiz
        Quiz quiz = service.fetchSubTypeById(Quiz.class, quizId);
        Set<QuestionOption> answers = new HashSet<>();

        // Add user answers
        for (Question q : quiz.getQuestions()) {
            List<QuestionOption> options = new ArrayList<>(q.getOptions());
            long randId = options.get(rand.nextInt(options.size() - 1)).getId();
            answers.add(service.fetchSubTypeById(QuestionOption.class, randId));
        }

        // Get Users
        Set<User> users = new HashSet<>(service.fetchAllSubTypes(User.class));
        challenge = new Challenge(quiz, users);
        service.create(challenge);

        // create attempt
        User user = new ArrayList<>(users).get(0);
        ChallengeAttempt attempt = new ChallengeAttempt(challenge, user, answers, null);
        service.create(attempt);
        session.getTransaction().commit();
    }

}
