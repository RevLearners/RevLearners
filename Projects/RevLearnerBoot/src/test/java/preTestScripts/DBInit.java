package preTestScripts;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import config.MockPersistenceConfig;
import io.revlearners.model.bean.FileBlob;
import io.revlearners.model.bean.Message;
import io.revlearners.model.bean.MessageStatus;
import io.revlearners.model.bean.MimeType;
import io.revlearners.model.bean.Notification;
import io.revlearners.model.bean.Question;
import io.revlearners.model.bean.QuestionDifficulty;
import io.revlearners.model.bean.QuestionOption;
import io.revlearners.model.bean.QuestionType;
import io.revlearners.model.bean.Rank;
import io.revlearners.model.bean.ReasonType;
import io.revlearners.model.bean.RequestStatus;
import io.revlearners.model.bean.Topic;
import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserRank;
import io.revlearners.model.bean.UserRole;
import io.revlearners.model.bean.UserStatus;
import io.revlearners.util.commons.configs.Constants;

@Transactional(value = Constants.TRANSACTION_HIBERNATE_MANAGER)
public class DBInit {
	private static ApplicationContext springContext;
	private static SessionFactory sf;
	private static Set<UserRank> ranks = new HashSet<UserRank>();
	private static Set<UserRank> ranks2 = new HashSet<UserRank>();
	private static User botbert = new User("Root", null, "Admin", new UserStatus(Constants.STATUS_OK), new UserRole(Constants.ROLE_ADMIN),
			"botbert@email.com", "Botbert", "$2a$10$trilJ1OUwLZqA9PjJYD9Bu1zpKq8jYKG3Dxsigxf1R4XLPBTH1LOW", Constants.START_DATE);

	private static User user1 = new User("User1", null, "User1", new UserStatus(Constants.STATUS_OK), new UserRole(Constants.ROLE_ADMIN),
			"botbert@email.com", "User1", "$2a$10$trilJ1OUwLZqA9PjJYD9Bu1zpKq8jYKG3Dxsigxf1R4XLPBTH1LOW", Constants.START_DATE);
	
	public static void main(String[] args) {
		springContext = new AnnotationConfigApplicationContext(MockPersistenceConfig.class);
		sf = springContext.getBean(SessionFactory.class);
		try {
			create();
		} finally {
			((AnnotationConfigApplicationContext) springContext).close();
		}
	}

	/**
	 * create test data Question creation template is below <@code> persistQuestion(
	 * " ", Constants.TOPIC_CORE_JAVA, Constants.QUESTION_MULTI_CHOICE,
	 * Constants.DIFFICULTY_EASY, new String[]{ " ", " ", " ", " " }, -1, " ",
	 * session ); </@code>
	 */
	public static void create() {

		try (Session session = sf.openSession()) {
			session.beginTransaction();

			Map<Long, String> map = Constants.getUserRoles();
			for (Long id : map.keySet()) {
				session.save(new UserRole(id, map.get(id)));
			}

			map = Constants.getUserStatuses();
			for (Long id : map.keySet()) {
				session.save(new UserStatus(id, map.get(id)));
			}

			map = Constants.getMessageStatuses();
			for (Long id : map.keySet()) {
				session.save(new MessageStatus(id, map.get(id)));
			}

			map = Constants.getRequestStatuses();
			for (Long id : map.keySet()) {
				session.save(new RequestStatus(id, map.get(id)));
			}

			map = Constants.getMimeTypes();
			for (Long id : map.keySet()) {
				session.save(new MimeType(id, map.get(id)));
			}

			map = Constants.getReasonTypes();

			for (Long id : map.keySet())
				session.save(new ReasonType(id, map.get(id)));

			saveEntities(Constants.getTopics(), session);
			saveEntities(Constants.getQuestionReasons(), session);
			saveEntities(Constants.getUserReasons(), session);

			saveEntities(Constants.getQuestionTypes(), session);

			saveEntities(Constants.getJavaranks(), session);
			saveEntities(Constants.getAngular4ranks(), session);
			saveEntities(Constants.getDevopsranks(), session);
			saveEntities(Constants.getHibernateRanks(), session);
			saveEntities(Constants.getDesignPatternRanks(), session);

			saveEntities(Constants.getCertifications(), session);
			saveEntities(Constants.getQuestionDifficulties(), session);

			addQuestions(session);
			/*****************************************************************/
			
			botbert.setRanks(ranks);
			user1.setRanks(ranks2);
			session.save(botbert);
			session.save(user1);
			for(UserRank ur : ranks)
			session.save(ur);
			
			Set<User> friends1 = new HashSet<User>();
			Set<User> friends2 = new HashSet<User>();
			friends1.add(botbert);
			friends2.add(user1);
			
			botbert.setFriends(friends2);
			user1.setFriends(friends1);
			session.save(user1);
			session.save(botbert);
			
			addNotifications(session);
			addMessages(session);

			session.getTransaction().commit();
		}
	}

	public static void saveEntities(Map<Long, ? extends Serializable> ranks, Session session) {
		for (Long id : ranks.keySet()) {
			if(ranks.get(id) instanceof Rank) {
				if(((Rank)ranks.get(id)).getRelativeWeight() == 1) {
					DBInit.ranks.add(new UserRank(botbert, (Rank) ranks.get(id), 0f));
					DBInit.ranks2.add(new UserRank(user1, (Rank) ranks.get(id), 0f));
				}
			}
				
			session.save(ranks.get(id));
		}
	}

	/**
	 * for quick adding of questions; does not do much validation
	 *
	 * @param questionText
	 * @param typeId
	 * @param topicId
	 * @param difficultyId
	 * @param optionTexts
	 * @param correctIdx
	 */
	public static void persistQuestion(String questionText, long topicId, long typeId, long difficultyId,
		String[] optionTexts, int correctIdx, String explanation, Session session) {

		Question question = new Question();
		question.setText(questionText);
		question.setDifficulty(session.load(QuestionDifficulty.class, difficultyId));
		question.setType(session.load(QuestionType.class, typeId));
		question.setTopic(session.load(Topic.class, topicId));
		question.setExplanation(explanation);
		session.persist(question);

		for (int i = 0; i < optionTexts.length; ++i) {
			QuestionOption opt = new QuestionOption();
			opt.setText(optionTexts[i]);
			opt.setCorrect(i == correctIdx);
			opt.setQuestion(question);
			session.persist(opt);
		}
	}

	private static void addQuestions(Session session) {
		persistQuestion("Arrays in Java are inherit from:", Constants.TOPIC_CORE_JAVA, Constants.QUESTION_MULTI_CHOICE,
				Constants.DIFFICULTY_EASY, new String[] { "class", "object", "variable", "none of the mentioned" }, 1,
				null, session);
		persistQuestion("Which of these keywords is used to prevent content of a variable from being modified?",
				Constants.TOPIC_CORE_JAVA, Constants.QUESTION_MULTI_CHOICE, Constants.DIFFICULTY_EASY,
				new String[] { "final", "last", "constant", "static" }, 0,
				"A variable can be declared final, doing so prevents its content from being modified. Final variables must be initialized when it is declared.",
				session);
		persistQuestion("Which of these cannot be declared static?", Constants.TOPIC_CORE_JAVA,
				Constants.QUESTION_MULTI_CHOICE, Constants.DIFFICULTY_EASY,
				new String[] { "class", "object", "variable", "method" }, 1,
				"static statements are run as soon as class containing then is loaded, prior to any object declaration.",
				session);
		persistQuestion("Which of the following statements are incorrect?", Constants.TOPIC_CORE_JAVA,
				Constants.QUESTION_MULTI_CHOICE, Constants.DIFFICULTY_EASY,
				new String[] { "static methods can call other static methods only",
						"static methods must only access static data",
						"static methods can not refer to this or super in any way",
						"when object of class is declared, each object contains its own copy of static variables" },
				3,
				"All objects of class share same static variable, when object of a class are declared, all the objects share same copy of static members, no copy of static variables are made.",
				session);
		persistQuestion("Which of the following statements are incorrect?", Constants.TOPIC_CORE_JAVA,
				Constants.QUESTION_MULTI_CHOICE, Constants.DIFFICULTY_EASY,
				new String[] { "Variables declared as final occupy memory",
						"final variable must be initialized at the time of declaration",
						"Arrays in java are implemented as an object",
						"All arrays contain an attribute-length which contains the number of elements stored in the array" },
				0, null, session);
		persistQuestion("Which of these methods must be made static?", Constants.TOPIC_CORE_JAVA,
				Constants.QUESTION_MULTI_CHOICE, Constants.DIFFICULTY_EASY,
				new String[] { "main()", "delete()", "run()", "finalize()" }, 0,
				"main() method must be declared static, main() method is called by Java’s run time system before any object of any class exists.",
				session);
		persistQuestion(
				"How many copies of static and class variables are created when 10 objects are created of a class?",
				Constants.TOPIC_CORE_JAVA, Constants.QUESTION_MULTI_CHOICE, Constants.DIFFICULTY_EASY,
				new String[] { "1, 10", "10, 10", "10, 1", "1, 1" }, 0,
				"Only one copy of static variables is created when a class is loaded. Each object instantiated has its own copy of instance variables.",
				session);
	}
	
	
	public static void persistNotification(String notificationContent, Set<User> receivers, User sender, 
			MessageStatus status, LocalDateTime time, String title, Session session) {
		
			Notification notification = new Notification();
			notification.setContents(notificationContent);
			notification.setReceivers(receivers);
			notification.setSender(sender);
			notification.setStatus(status);
			notification.setTime(time);
			notification.setTitle(title);
			session.persist(notification);
		}
	
	
	private static void addNotifications(Session session) {
		Set<User> receivers = new HashSet<User>();
		receivers.add(botbert);
		MessageStatus ms = new MessageStatus();
		ms.setId(Constants.MESSAGE_STATUS_RECEIVED);
		persistNotification("0Hello World!", receivers, botbert, ms, LocalDateTime.now(), "0Hello World!", session);
//		persistNotification("1Hello World!", receivers, botbert, ms, LocalDateTime.now(), "1Hello World!", session);
//		persistNotification("2Hello World!", receivers, botbert, ms, LocalDateTime.now(), "2Hello World!", session);
//		persistNotification("3Hello World!", receivers, botbert, ms, LocalDateTime.now(), "3Hello World!", session);
//		persistNotification("4Hello World!", receivers, botbert, ms, LocalDateTime.now(), "4Hello World!", session);
//		persistNotification("5Hello World!", receivers, botbert, ms, LocalDateTime.now(), "5Hello World!", session);
	}

	
	public static void persistMessage(String contents, LocalDateTime time, String title, User sender,
			Set<User> receivers, MessageStatus status, Set<FileBlob> blobs, Session session) {
			Message message = new Message();
			message.setContents(contents);
			message.setTime(time);
			message.setTitle(title);
			message.setSender(sender);
			message.setReceivers(receivers);
			message.setStatus(status);
			message.setBlobs(blobs);
			session.persist(message);
		}
	
	
	private static void addMessages(Session session) {
		Set<User> receivers = new HashSet<User>();
		receivers.add(user1);
		MessageStatus ms = new MessageStatus();
		ms.setId(Constants.MESSAGE_STATUS_RECEIVED);
		Set<FileBlob> files = new HashSet<FileBlob>();
		persistMessage("0Hello World!", LocalDateTime.now(), "0Hello World!", botbert, receivers, ms, files, session);
//		persistMessage("1Hello World!", LocalDateTime.now(), "1Hello World!", botbert, receivers, ms, files, session);
//		persistMessage("2Hello World!", LocalDateTime.now(), "2Hello World!", botbert, receivers, ms, files, session);
//		persistMessage("3Hello World!", LocalDateTime.now(), "3Hello World!", botbert, receivers, ms, files, session);
//		persistMessage("4Hello World!", LocalDateTime.now(), "4Hello World!", botbert, receivers, ms, files, session);
//		persistMessage("5Hello World!", LocalDateTime.now(), "5Hello World!", botbert, receivers, ms, files, session);
	}

}
