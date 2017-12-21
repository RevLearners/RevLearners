import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.commons.io.FileUtils;

import io.revlearners.model.bean.*;
import io.revlearners.model.services.dao.interfaces.contracts.*;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.commons.configs.PersistenceConfig;
import io.revlearners.util.persistence.BlobWriter;

@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class PersistenceLayerTest extends AbstractTestNGSpringContextTests {
	
	@Autowired
	private SessionFactory sf;

	private Session session;
	
	private Long blobId;

	@BeforeClass
	public final void before() {
		DBInit.create(sf);
		session = sf.openSession();
	}

	@AfterClass
	public final void after() {
		session.close();
	}

	@Test()
	public void userInsertTest() {

		
		
		User user = new User("John", null, "Doe", session.load(UserStatus.class, Constants.STATUS_PENDING),
				session.load(UserRole.class, Constants.ROLE_BASIC));
		Credentials credentials = new Credentials(user, "mail@email.com", "aUsername", "password",
				"this is a salt, a really bad salt, but a salt none the less");
		session.beginTransaction();
		session.save(credentials);
		session.getTransaction().commit();
	}

	@Test()
	public void questionInsertTest() {
		session.beginTransaction();
		Question quest = new Question(session.load(Topic.class, Constants.TOPIC_CORE_JAVA),
				session.load(QuestionType.class, Constants.QUESTION_TRUE_FALSE),
				session.load(QuestionDifficulty.class, Constants.DIFFICULTY_EASY), "Is the answer to life 42?");
		session.save(quest);
		session.save(new QuestionOption(quest, "True", true));
		session.save(new QuestionOption(quest, "False", false));
		session.getTransaction().commit();
	}

	@Test
	public void certificationUploadTest() {
		session.beginTransaction();
		String filePath =  Constants.PROJECT_DIR + "/img/imgUpload.jpg";
		byte[] bytes;

		File file = new File(filePath);
		String fileName = file.getName();
		try {
			bytes = BlobWriter.writeToBlob(session, filePath);
			FileBlob fb = new FileBlob(fileName, file.length(), bytes, new MimeType(Constants.MIME_JPG, Constants.MIME_JPG_STR));
			blobId = (Long) session.save(fb);
			session.getTransaction().commit();
		
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods="certificationUploadTest")
	public void certificationViewTest() {
		FileBlob fb;
		fb = session.load(FileBlob.class, blobId);
		try {
			BlobWriter.writeToFile(fb.getName(), fb.getSize(), fb.getContents());
		} catch (IOException | SQLException e) {
			System.err.println(e);

			e.printStackTrace();
			Assert.fail();
		}
	}
}
