
package testNGUnitTests;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
		Set<Topic> topics;
		Rank rank;
		UserRank utr;

		topics = new HashSet<Topic>(service.fetchAllSubTypes(Topic.class));
		UserStatus us = service.fetchSubTypeById(UserStatus.class, Constants.STATUS_PENDING);
		UserRole ur = service.fetchSubTypeById(UserRole.class, Constants.ROLE_BASIC);
		User user = new User("John", null, "Doe", us, ur, "mail@email.com", "aUsername", "password",
				"this is a salt, a really bad salt, but a salt none the less");

		for (Topic t : topics) {
			rank = t.getRankByWeight(1L);

			// Not all the topics have been implemented yet
			if (rank != null) {
				utr = new UserRank(user, rank, rank.getMeritThreshold());
				user.getRanks().add(utr);
			}
		}
		
		session.beginTransaction();
		userId = (Long) service.create(user);
		session.getTransaction().commit();

	}

	@Test(priority = 1)
	@Transactional
	public void insertReceiverTest() {
		Set<Topic> topics;
		Rank rank;
		UserRank utr;

		session.beginTransaction();
		topics = new HashSet<Topic>(service.fetchAllSubTypes(Topic.class));
		UserStatus us = service.fetchSubTypeById(UserStatus.class, Constants.STATUS_PENDING);
		UserRole ur = service.fetchSubTypeById(UserRole.class, Constants.ROLE_BASIC);
		User user = new User("Jane", null, "Bobbert", us, ur, "mail2@email2.com", "aU2se2rname", "password2", "salt2");

		for (Topic t : topics) {
			rank = t.getRankByWeight(1L);
			
			// Not all the topics have been implemented yet
			if (rank != null) {
				utr = new UserRank(user, rank, rank.getMeritThreshold());
				user.getRanks().add(utr);
			}
		}

		receiverId = (Long) service.create(user);
		session.getTransaction().commit();
	}

	@Test()
	@Transactional
	public void questionInsertTest() {

		Topic topic = service.fetchSubTypeById(Topic.class, Constants.TOPIC_CORE_JAVA);
		QuestionType type = service.fetchSubTypeById(QuestionType.class, Constants.QUESTION_TRUE_FALSE);
		QuestionDifficulty diff = service.fetchSubTypeById(QuestionDifficulty.class, Constants.DIFFICULTY_EASY);
		Question quest = new Question(topic, type, diff, "Is the answer to life 42?", null);

		List<QuestionOption> opts = new ArrayList<>();
		opts.add(new QuestionOption(quest, "True", true));
		opts.add(new QuestionOption(quest, "False", false));
		quest.addOptions(opts);

		questId = (Long) service.create(quest);
		session.getTransaction().commit();
	}

	@Test(dependsOnMethods = "questionInsertTest")
	@Transactional
	public void quizInsertTest() {
		Set<Question> quests;
		Quiz quiz, quiz2;

		session.beginTransaction();
		quests = new HashSet<Question>(service.fetchAllSubTypes(Question.class));
		quiz = new Quiz(quests, LocalDateTime.now());

		quests = new HashSet<Question>(service.fetchAllSubTypes(Question.class));
		quiz2 = new Quiz(quests, LocalDateTime.now());

		quizId = (Long) service.create(quiz);
		service.create(quiz2);
		session.getTransaction().commit();
	}

	@Test(dependsOnMethods = { "quizInsertTest", "userInsertTest" })
	@Transactional
	public void quizAttemptTest() {
		Random rand = new Random();
		QuizAttempt attempt;
		List<QuestionOption> options;
		Set<QuestionOption> answers = new HashSet<QuestionOption>();
		User user;
		Long randId;
		Quiz quiz;

		session.beginTransaction();
		
		// Get quiz
		quiz = service.fetchSubTypeById(Quiz.class, quizId);

		// Add user answers
		for (Question q : quiz.getQuestions()) {
			options = new ArrayList<QuestionOption>(q.getOptions());
			randId = options.get(rand.nextInt(options.size() - 1)).getId();
			answers.add(service.fetchSubTypeById(QuestionOption.class, randId));
		}

		// Get User
		user = service.fetchSubTypeById(User.class, userId);

		// create attempt
		// attempt = new QuizAttempt(quiz, user, answers);

		// quiz.getAttempts().add(attempt);

		// persist attempt
		service.create(quiz);
		session.getTransaction().commit();

	}

	@Test(dependsOnMethods = { "quizInsertTest", "userInsertTest" })
	@Transactional
	public void challengeAttemptTest() {
		Random rand = new Random();
		ChallengeAttempt attempt;
		Challenge chal;
		List<QuestionOption> options;
		Set<QuestionOption> answers = new HashSet<QuestionOption>();
		Set<User> users;
		Long randId;
		Quiz quiz;

		// persist attempt
		session.beginTransaction();
		
		// Get quiz
		quiz = service.fetchSubTypeById(Quiz.class, quizId);

		// Add user answers
		for (Question q : quiz.getQuestions()) {
			options = new ArrayList<>(q.getOptions());
			randId = options.get(rand.nextInt(options.size() - 1)).getId();
			answers.add(service.fetchSubTypeById(QuestionOption.class, randId));
		}

		// Get Users
		users = new HashSet<>(service.fetchAllSubTypes(User.class));

		// create attempt
		// attempt = new ChallengeAttempt(null, users, answers, null);

		chal = new Challenge(quiz);
		// chal.getAttempts().add(attempt);

		service.create(chal);
		session.getTransaction().commit();
	}

}
