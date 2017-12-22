package testNGUnitTests;

import java.io.File;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashSet;
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

	@Test
	public void userInsertTest() {

		User user = new User("John", null, "Doe", session.load(UserStatus.class, Constants.STATUS_PENDING),
				session.load(UserRole.class, Constants.ROLE_BASIC), "mail@email.com", "aUsername", "password",
				"this is a salt, a really bad salt, but a salt none the less");
		session.beginTransaction();
		userId = (Long) userService.create(user, session);
		session.getTransaction().commit();
	}

	@Test
	public void insertReceiverTest() {

		User user = new User("Jane", null, "Bobbert", session.load(UserStatus.class, Constants.STATUS_PENDING),
				session.load(UserRole.class, Constants.ROLE_BASIC), "mail@email.com", "aUsername", "password",
				"this is a salt, a really bad salt, but a salt none the less");
		session.beginTransaction();
		receiverId = (Long) userService.create(user, session);
		session.getTransaction().commit();
	}

	@Test
	public void questionInsertTest() {
		session.beginTransaction();
		Question quest = new Question(session.load(Topic.class, Constants.TOPIC_CORE_JAVA),
				session.load(QuestionType.class, Constants.QUESTION_TRUE_FALSE),
				session.load(QuestionDifficulty.class, Constants.DIFFICULTY_EASY), "Is the answer to life 42?");

		Set<QuestionOption> opts = new HashSet<QuestionOption>();
		opts.add(new QuestionOption("True", true));
		opts.add(new QuestionOption("False", false));
		quest.addOptions(opts);
		questionService.create(quest, session);
		session.getTransaction().commit();
	}

	@Test(dependsOnMethods = "userInsertTest")
	public void certificationUploadTest() {
		session.beginTransaction();

		// Create certification associated to user
		Certification cert = session.load(Certification.class, Constants.ORACLE_CERTIFIED_ASSOCIATE);
		User user = session.load(User.class, userId);
		UserCertification uc = new UserCertification(user, cert);

		// Save the certification to the user
		user.getCertifications().add(uc);
		session.save(user);

		// blobId = (Long) session.save(blobs);
		session.getTransaction().commit();
	}

	@Test(dependsOnMethods = { "userInsertTest", "insertReceiverTest" })
	public void insertMessageWithAttachmentsTest() {
		String filePath = Constants.PROJECT_DIR + "/testFiles/";
		Set<FileBlob> blobs = new HashSet<FileBlob>();
		byte[] bytes = null;
		Message msg;
		MessageStatus stat;
		User sender, receiver;

		// get users
		Long senderId = userId;
		Long receiverId = this.receiverId;

		File file = new File(filePath);
		String fileName = file.getName();

		try {
			// write files to blobs
			for (String s : file.list()) {
				bytes = BlobWriter.writeToBlob(session, filePath + "/" + s);
				blobs.add(new FileBlob(fileName, file.length(), bytes,
						new MimeType(Constants.MIME_JPG, Constants.MIME_JPG_STR)));
			}

			session.beginTransaction();

			// load sender and receiver users
			sender = session.load(User.class, senderId);
			receiver = session.load(User.class, receiverId);
			stat = session.load(MessageStatus.class, Constants.MESSAGE_STATUS_UNREAD);

			// generate message
			msg = new Message(sender, receiver, "This is the title", "This is the message", blobs, LocalDateTime.now(),
					stat);

			// save message
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
		msg = session.load(Message.class, msgId);
		try {
			for (FileBlob fb : msg.getBlobs())
				BlobWriter.writeToFile(fb.getName(), fb.getSize(), fb.getContents());
		} catch (IOException | SQLException e) {
			System.err.println(e);

			e.printStackTrace();
			Assert.fail();
		}
	}
}
