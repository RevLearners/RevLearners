
package testNGUnitTests;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.hibernate.Session;
import org.junit.*;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.revlearners.model.bean.*;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.persistence.BlobWriter;
import preTestScripts.DBInit;

// Tests are enabled and disabled as needed to improve performance 
public class GenericPersistenceLayerTest extends PersistenceLayerTest {

	private Session session = null;

	private Long msgId;
	private Long quizId;
	private Long questId;
	private Long userId;
	private Long receiverId;

	@BeforeClass
	public final void before() {
		session = sf.openSession();
		DBInit.create(session);
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

		session.beginTransaction();
		Topic topic = service.fetchSubTypeById(Topic.class, Constants.TOPIC_CORE_JAVA);
		QuestionType type = service.fetchSubTypeById(QuestionType.class, Constants.QUESTION_TRUE_FALSE);
		QuestionDifficulty diff = service.fetchSubTypeById(QuestionDifficulty.class, Constants.DIFFICULTY_EASY);
		Question quest = new Question(topic, type, diff, "Is the answer to life 42?");

		Set<QuestionOption> opts = new HashSet<QuestionOption>();
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
		attempt = new QuizAttempt(user, answers);

		quiz.getAttempts().add(attempt);

		// persist attempt
		service.create(attempt);
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
			options = new ArrayList<QuestionOption>(q.getOptions());
			randId = options.get(rand.nextInt(options.size() - 1)).getId();
			answers.add(service.fetchSubTypeById(QuestionOption.class, randId));
		}

		// Get Users
		users = new HashSet<User>(service.fetchAllSubTypes(User.class));

		// create attempt
		attempt = new ChallengeAttempt(users, answers);

		chal = new Challenge(quiz);
		chal.getAttempts().add(attempt);

		service.create(chal);
		session.getTransaction().commit();
	}

	@Test(dependsOnMethods = "userInsertTest")
	@Transactional
	public void certificationUploadTest() {
		session.beginTransaction();
		RequestStatus reqStat;
		FileBlob fb;
		String filePath = Constants.PROJECT_DIR + "/testFiles/imgUpload.jpg";
		byte[] bytes;

		try {
			bytes = BlobWriter.writeToBlob(session, filePath);
			File file = new File(filePath);
			fb = new FileBlob(file.getName(), file.length(), bytes, new MimeType(Constants.MIME_JPG, Constants.MIME_JPG_STR));
			
			// Create certification associated to user
			Certification cert = service.fetchSubTypeById(Certification.class, Constants.ORACLE_CERTIFIED_ASSOCIATE);
			User user = service.fetchSubTypeById(User.class, userId);
			reqStat = service.fetchSubTypeById(RequestStatus.class, Constants.REQUEST_STATUS_PENDING);
			
			UserCertification uc = new UserCertification(user, cert, fb, reqStat);

			// Save the certification to the user
			user.getCertifications().add(uc);
			service.create(user);

			session.getTransaction().commit();

		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(priority = 2, dependsOnMethods = { "userInsertTest", "insertReceiverTest" })
	@Transactional
	public void insertMessageWithAttachmentsTest() {
		String filePath = Constants.PROJECT_DIR + "/testFiles/";
		Set<FileBlob> blobs = new HashSet<FileBlob>();
		Set<User> receivers = new HashSet<User>();
		byte[] bytes = null;
		Message msg;
		MessageStatus stat;
		User sender, receiver;
		Long mime = null;
		String mimeStr = null;

		File file = new File(filePath);
		String fileName = file.getName();

		try {
			// write files to blobs
			for (String s : file.list()) {
				switch (FilenameUtils.getExtension(s)) {
				case ("pdf"):
				case (".pdf"):
					mime = Constants.MIME_PDF;
					mimeStr = Constants.MIME_PDF_STR;
					break;
				case ("jpg"):
				case (".jpg"):
					mime = Constants.MIME_JPG;
					mimeStr = Constants.MIME_JPG_STR;
					break;
				case ("png"):
				case (".png"):
					mime = Constants.MIME_PNG;
					mimeStr = Constants.MIME_PNG_STR;
					break;
				}
				bytes = BlobWriter.writeToBlob(session, filePath + "/" + s);
				blobs.add(new FileBlob(fileName, file.length(), bytes, new MimeType(mime, mimeStr)));
			}

			session.beginTransaction();
			
			// load sender and receiver users
			sender = service.fetchSubTypeById(User.class, userId);
			receiver = service.fetchSubTypeById(User.class, receiverId);
			stat = service.fetchSubTypeById(MessageStatus.class, Constants.MESSAGE_STATUS_UNREAD);

			// generate message
			receivers.add(receiver);
			msg = new Message(sender, receivers, "This is the title", "This is the message", blobs, LocalDateTime.now(),
					stat);

			// save message
			msgId = (Long) session.save(msg);

			session.getTransaction().commit();

		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	// tested and working
	@Test(dependsOnMethods = "insertMessageWithAttachmentsTest")
	@Transactional
	public void certificationViewTest() {
		Message msg;
		msg = service.fetchSubTypeById(Message.class, msgId);
		try {
			for (FileBlob fb : msg.getBlobs())
				BlobWriter.writeToFile(fb.getName(), fb.getSize(), fb.getContents());
		} catch (IOException | SQLException e) {
			System.err.println(e);

			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(priority = 2, dependsOnMethods = { "userInsertTest", "insertReceiverTest" })
	@Transactional
	public void insertNotificationTest() {
		User sender, receiver;
		Set<User> receivers = new HashSet<User>();
		MessageStatus ms;
		Notification notif;
		session.beginTransaction();
		sender = service.fetchSubTypeById(User.class, userId);
		receiver = service.fetchSubTypeById(User.class, receiverId);
		receivers.add(receiver);
		ms = service.fetchSubTypeById(MessageStatus.class, Constants.MESSAGE_STATUS_UNREAD);
		notif = new Notification(sender, receivers, "This is a title", "This is the notification", LocalDateTime.now(),
				ms);

		service.create(notif);
		session.getTransaction().commit();
	}
	
	@Test(dependsOnMethods = {"userInsertTest", "insertReceiverTest"})
	@Transactional
	public void friendTest() {
		User user, friend;
		session.beginTransaction();
		user = service.fetchSubTypeById(User.class, userId);
		friend = service.fetchSubTypeById(User.class, receiverId);
		
		//Friend is bidirectional
		user.getFriends().add(friend);
		friend.getFriends().add(user);
		
		service.update(User.class, user);
		service.update(User.class, friend);
		session.getTransaction().commit();
	}
	
	
	@Test(dependsOnMethods = {"userInsertTest", "insertReceiverTest"})
	@Transactional
	public void reportUserTest() {
		ReportUser report;
		Reason reason;
		User reporter, reported;

		session.beginTransaction();
		reporter = service.fetchSubTypeById(User.class, userId);
		reported = service.fetchSubTypeById(User.class, receiverId);
		reason = service.fetchSubTypeById(Reason.class, Constants.USER_REASON_STOLEN_INTELLECTUAL_PROPERTY);
		report = new ReportUser(reported, reason, reporter);
		
		service.create(report);
		session.getTransaction().commit();
		
	}
	
	@Test(dependsOnMethods = {"userInsertTest", "questionInsertTest"})
	@Transactional
	public void reportQuestionTest() {
		ReportQuestion report;
		Reason reason;
		User reporter;
		Question reported;
		
		session.beginTransaction();
		reporter = service.fetchSubTypeById(User.class, userId);
		reported = service.fetchSubTypeById(Question.class, questId);
		reason = service.fetchSubTypeById(Reason.class, Constants.QREASON_WRONG);
		report = new ReportQuestion(reported, reason, reporter);
		
		service.create(report);
		session.getTransaction().commit();
		
		
	}
}
