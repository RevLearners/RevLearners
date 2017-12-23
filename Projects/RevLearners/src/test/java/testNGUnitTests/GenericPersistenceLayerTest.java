
package testNGUnitTests;

import java.io.File;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.junit.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.revlearners.model.bean.*;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.persistence.BlobWriter;
import preTestScripts.DBInit;

public class GenericPersistenceLayerTest extends PersistenceLayerTest {

	private Session session;

	private Long msgId;
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
	public void readTopicTest() {
		Topic topic = service.fetchSubTypeById(Topic.class, Constants.TOPIC_CORE_JAVA, session);
		System.out.println(topic);
	}

	@Test(priority = 1)
	public void userInsertTest() {
		Set<Topic> topics;
		Rank rank;
		UserRank utr;

		topics = new HashSet<Topic>(service.fetchAllSubTypes(Topic.class, session));
		UserStatus us = service.fetchSubTypeById(UserStatus.class, Constants.STATUS_PENDING, session);
		UserRole ur = service.fetchSubTypeById(UserRole.class, Constants.ROLE_BASIC, session);
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
		userId = (Long) service.create(user, session);
		session.getTransaction().commit();
	}

	@Test(priority = 1)
	public void insertReceiverTest() {
		Set<Topic> topics;
		Rank rank;
		UserRank utr;

		topics = new HashSet<Topic>(service.fetchAllSubTypes(Topic.class, session));
		UserStatus us = service.fetchSubTypeById(UserStatus.class, Constants.STATUS_PENDING, session);
		UserRole ur = service.fetchSubTypeById(UserRole.class, Constants.ROLE_BASIC, session);
		User user = new User("Jane", null, "Bobbert", us, ur, "mail2@email2.com", "aU2se2rname", "password2",
				"salt2");
				
		for (Topic t : topics) {
			rank = t.getRankByWeight(1L);
			
			// Not all the topics have been implemented yet
			if (rank != null) {
				utr = new UserRank(user, rank, rank.getMeritThreshold());
				user.getRanks().add(utr);
			}
		}

		session.beginTransaction();
		receiverId = (Long) service.create(user, session);
		session.getTransaction().commit();
	}

	@Test
	public void questionInsertTest() {
		session.beginTransaction();

		Topic topic = service.fetchSubTypeById(Topic.class, Constants.TOPIC_CORE_JAVA, session);
		QuestionType type = service.fetchSubTypeById(QuestionType.class, Constants.QUESTION_TRUE_FALSE, session);
		QuestionDifficulty diff = service.fetchSubTypeById(QuestionDifficulty.class, Constants.DIFFICULTY_EASY,
				session);
		Question quest = new Question(topic, type, diff, "Is the answer to life 42?");

		Set<QuestionOption> opts = new HashSet<QuestionOption>();
		opts.add(new QuestionOption(quest, "True", true));
		opts.add(new QuestionOption(quest, "False", false));
		quest.addOptions(opts);
		questId = (Long) service.create(quest, session);
		session.getTransaction().commit();
	}

	@Test(dependsOnMethods = "questionInsertTest")
	public void quizInsertTest() {
		Set<Question> quests;
		Quiz quiz, quiz2;

		questionInsertTest();
		
		quests = new HashSet<Question>(service.fetchAllSubTypes(Question.class, session));
		quiz = new Quiz(quests, LocalDateTime.now());
		
		quests = new HashSet<Question>(service.fetchAllSubTypes(Question.class, session));
		quiz2 = new Quiz(quests, LocalDateTime.now());

		session.beginTransaction();
		service.create(quiz, session);
		
		service.create(quiz2, session);

		session.getTransaction().commit();
	}

	@Test(dependsOnMethods = "userInsertTest")
	public void certificationUploadTest() {
		session.beginTransaction();

		// Create certification associated to user
		Certification cert = service.fetchSubTypeById(Certification.class, Constants.ORACLE_CERTIFIED_ASSOCIATE,
				session);
		User user = service.fetchSubTypeById(User.class, userId, session);
		UserCertification uc = new UserCertification(user, cert);

		// Save the certification to the user
		user.getCertifications().add(uc);
		service.create(user, session);

		// blobId = (Long) session.save(blobs);
		session.getTransaction().commit();
	}

	@Test(priority = 2, dependsOnMethods = { "userInsertTest", "insertReceiverTest" })
	public void insertMessageWithAttachmentsTest() {
		String filePath = Constants.PROJECT_DIR + "/testFiles/";
		Set<FileBlob> blobs = new HashSet<FileBlob>();
		byte[] bytes = null;
		Message msg;
		MessageStatus stat;
		User sender, receiver;

		File file = new File(filePath);
		String fileName = file.getName();

		try {
			// write files to blobs
			for (String s : file.list()) {
				bytes = BlobWriter.writeToBlob(session, filePath + "/" + s);
				blobs.add(new FileBlob(fileName, file.length(), bytes,
						new MimeType(Constants.MIME_JPG, Constants.MIME_JPG_STR)));
			}

			// load sender and receiver users
			sender = service.fetchSubTypeById(User.class, userId, session);
			receiver = service.fetchSubTypeById(User.class, receiverId, session);
			stat = service.fetchSubTypeById(MessageStatus.class, Constants.MESSAGE_STATUS_UNREAD, session);

			// generate message
			msg = new Message(sender, receiver, "This is the title", "This is the message", blobs, LocalDateTime.now(),
					stat);

			// save message
			session.beginTransaction();
			msgId = (Long) session.save(msg);

			session.getTransaction().commit();

		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(dependsOnMethods = "insertMessageWithAttachmentsTest")
	public void certificationViewTest() {
		Message msg;
		msg = service.fetchSubTypeById(Message.class, msgId, session);
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
	public void insertNotificationTest() {
		User sender, receiver;
		MessageStatus ms;
		Notification notif;
		sender = service.fetchSubTypeById(User.class, userId, session);
		receiver = service.fetchSubTypeById(User.class, receiverId, session);
		ms = service.fetchSubTypeById(MessageStatus.class, Constants.MESSAGE_STATUS_UNREAD, session);
		notif = new Notification(sender, receiver, "This is a title", "This is the notification", LocalDateTime.now(),
				ms);

		session.beginTransaction();
		service.create(notif, session);
		session.getTransaction().commit();
	}
}
