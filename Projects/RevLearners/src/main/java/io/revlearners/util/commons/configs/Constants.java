package io.revlearners.util.commons.configs;

import io.revlearners.model.bean.*;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This holds all the constants through the app, the most important being the
 * database constant records. These include the values of report types, question
 * difficulties, etc; each table has a dedicated dictionary that maps where the
 * keys are the record ids and the value is the associated string (usually
 * name), or bean if the object is more than just a string and an id
 */
public final class Constants {
	public static final String FROM = " from ";

	// These should match both the @Qualifier strings and the PersistenceConfig
	// method names
	public static final String QUALIFY_USER_DAO = "userHibernateDao";
	public static final String QUALIFY_RANK_DAO = "rankHibernateDao";
	public static final String QUALIFY_MESSAGE_DAO = "messageHibernateDao";
	public static final String QUALIFY_QUESTION_DAO = "questionHibernateDao";
	public static final String QUALIFY_HIBERNATE_BEAN_DAO = "hibernateBeanDao";

	public static final String QUALIFY_BEAN_DAO_INJECTOR = "hibernateBeanService";
	public static final String QUALIFY_MESSAGE_DAO_INJECTOR = "messageHibernateService";
	public static final String QUALIFY_NOTIFICATION_DAO = "notificationHibernateService";
	public static final String QUALIFY_QUESTION_DAO_INJECTOR = "questionHibernateService";
	public static final String QUALIFY_RANK_DAO_INJECTOR = "rankHibernateService";
	public static final String QUALIFY_USER_DAO_INJECTOR = "userHibernateService";

	public static final String TRANSACTION_HIBERNATE_MANAGER = "hibernateTransactionManager";

	// map constants
	private static final Map<Long, QuestionType> questionTypes = new LinkedHashMap<>();
	private static final Map<Long, QuestionDifficulty> questionDifficulties = new LinkedHashMap<>();
	private static final Map<Long, String> userRoles = new LinkedHashMap<>();
	private static final Map<Long, String> userStatuses = new LinkedHashMap<>();
	private static final Map<Long, String> reasonTypes = new LinkedHashMap<>();
	private static final Map<Long, Topic> topics = new LinkedHashMap<>();
	private static final Map<Long, Certification> certifications = new LinkedHashMap<>();
	private static final Map<Long, Rank> javaRanks = new LinkedHashMap<>();
	private static final Map<Long, Rank> j2eeRanks = new LinkedHashMap<>();
	private static final Map<Long, Rank> jtaRanks = new LinkedHashMap<>();
	private static final Map<Long, Rank> jpaRanks = new LinkedHashMap<>();
	private static final Map<Long, Rank> springRanks = new LinkedHashMap<>();
	private static final Map<Long, Rank> plSQLRanks = new LinkedHashMap<>();
	private static final Map<Long, Rank> tSQLRanks = new LinkedHashMap<>();
	private static final Map<Long, Rank> mySQLRanks = new LinkedHashMap<>();
	private static final Map<Long, Rank> postGreSQLRanks = new LinkedHashMap<>();
	private static final Map<Long, Rank> webRanks = new LinkedHashMap<>();
	private static final Map<Long, Rank> jQueryRanks = new LinkedHashMap<>();
	private static final Map<Long, Rank> angularJSRanks = new LinkedHashMap<>();
	private static final Map<Long, Rank> angular4Ranks = new LinkedHashMap<>();
	private static final Map<Long, Rank> hibernateRanks = new LinkedHashMap<>();
	private static final Map<Long, Rank> devOpsRanks = new LinkedHashMap<>();
	private static final Map<Long, Rank> microsRanks = new LinkedHashMap<>();
	private static final Map<Long, Rank> designPatternRanks = new LinkedHashMap<>();
	private static final Map<Long, Reason> questionReasons = new LinkedHashMap<>();
	private static final Map<Long, Reason> userReasons = new LinkedHashMap<>();
	private static final Map<Long, String> mimeTypes = new LinkedHashMap<>();
	private static final Map<Long, String> messageStatuses = new LinkedHashMap<>();
	private static final Map<Long, String> requestStatuses = new LinkedHashMap<>();

	// map key/values
	public static final Long QUESTION_TRUE_FALSE = 1L;
	public static final String QUESTION_TRUE_FALSE_STR = "True or False";
	public static final Long QUESTION_MULTI_CHOICE = 2L;
	public static final String QUESTION_MULTI_CHOICE_STR = "Multiple Choice";
	public static final Long QUESTION_CODE = 3L;
	public static final String QUESTION_CODE_STR = "Coding Challenge";

	public static final Long DIFFICULTY_EASY = 1L;
	public static final String DIFFICULTY_EASY_STR = "Easy";
	public static final Float DIFFICULTY_EASY_MULTIPLIER = 1.f;
	public static final Long DIFFICULTY_MEDIUM = 2L;
	public static final String DIFFICULTY_MEDIUM_STR = "Medium";
	public static final Float DIFFICULTY_MEDIUM_MULTIPLIER = 2.f;
	public static final Long DIFFICULTY_HARD = 3L;
	public static final String DIFFICULTY_HARD_STR = "Hard";
	public static final Float DIFFICULTY_HARD_MULTIPLIER = 4.f;
	public static final Long DIFFICULTY_VERY_HARD = 4L;
	public static final String DIFFICULTY_VERY_HARD_STR = "Very Hard";
	public static final Float DIFFICULTY_VERY_HARD_MULTIPLIER = 8.f;

	public static final Long ROLE_BASIC = 1L;
	public static final String ROLE_BASIC_STR = "Basic Account";
	public static final Long ROLE_ADVANCED = 2L;
	public static final String ROLE_ADVANCED_STR = "Advanced Account";
	public static final Long ROLE_CERTIFIED = 3L;
	public static final String ROLE_CERTIFIED_STR = "Advanced Account(Certified)";
	public static final Long ROLE_ADMIN = 4L;
	public static final String ROLE_ADMIN_STR = "Administrator Account";

	public static final Long STATUS_OK = 1L;
	public static final String STATUS_OK_STR = "Ok";
	public static final Long STATUS_LOCKED = 2L;
	public static final String STATUS_LOCKED_STR = "Locked";
	public static final Long STATUS_PENDING = 3L;
	public static final String STATUS_PENDING_STR = "Pending";
	public static final Long STATUS_BANNED = 4L;
	public static final String STATUS_BANNED_STR = "Banned";

	public static final Long REASON_TYPE_QUESTION = 1L;
	public static final String REASON_TYPE_QUESTION_STR = "Question";
	public static final Long REASON_TYPE_USER = 2L;
	public static final String REASON_TYPE_USER_STR = "User";

	public static final Long TOPIC_CORE_JAVA = 1L;
	public static final String TOPIC_CORE_JAVA_STR = "Core Java";
	public static final Long TOPIC_J2EE = 2L;
	public static final String TOPIC_J2EE_STR = "Java Enterprise Edition(J2EE)";
	public static final Long TOPIC_JTA = 3L;
	public static final String TOPIC_JTA_STR = "Java Test Automation(including Selenium, testNG, Cucumber)";
	public static final Long TOPIC_HIBERNATE = 4L;
	public static final String TOPIC_HIBERNATE_STR = "Hibernate Framework for Java";
	public static final Long TOPIC_JPA = 5L;
	public static final String TOPIC_JPA_STR = "Java Persistence API(JPA)";
	public static final Long TOPIC_SPRING = 6L;
	public static final String TOPIC_SPRING_STR = "Spring Framework for Java";
	public static final Long TOPIC_PLSQL = 7L;
	public static final String TOPIC_PLSQL_STR = "PLSQL";
	public static final Long TOPIC_TSQL = 8L;
	public static final String TOPIC_TSQL_STR = "Transact SQL";
	public static final Long TOPIC_MYSQL = 9L;
	public static final String TOPIC_MYSQL_STR = "mySQL";
	public static final Long TOPIC_POSTGRESQL = 10L;
	public static final String TOPIC_POSTGRESQL_STR = "PostgreSQL";
	public static final Long TOPIC_WEB_DEV = 11L;
	public static final String TOPIC_WEB_DEV_STR = "Basic Web Development(HTML/CSS/JS/PHP)";
	public static final Long TOPIC_JQUERY = 12L;
	public static final String TOPIC_JQUERY_STR = "jQuery";
	public static final Long TOPIC_ANGULARJS = 13L;
	public static final String TOPIC_ANGULARJS_STR = "AngularJS";
	public static final Long TOPIC_ANGULAR4 = 14L;
	public static final String TOPIC_ANGULAR4_STR = "Angular4";
	public static final Long TOPIC_DEVOPS = 15L;
	public static final String TOPIC_DEVOPS_STR = "DevOps (includes Jenkins and AWS)";
	public static final Long TOPIC_MICROSERVICES = 16L;
	public static final String TOPIC_MICROSERVICES_STR = "Microservices";
	public static final Long TOPIC_DESIGN_PATTERNS = 17L;
	public static final String TOPIC_DESIGN_PATTERNS_STR = "Design Patterns";

	// java certifications
	public static final Long ORACLE_CERTIFIED_ASSOCIATE = 1L;
	public static final String ORACLE_CERTIFIED_ASSOCIATE_STR = "Oracle Certified Associate (OCA)";
	public static final Long ORACLE_CERTIFIED_PROFESSIONAL = 2L;
	public static final String ORACLE_CERTIFIED_PROFESSIONAL_STR = "Oracle Certified Professional (OCP)";
	public static final Long ORACLE_CERTIFIED_MASTER = 3L;
	public static final String ORACLE_CERTIFIED_MASTER_STR = "Oracle Certified Master (OCM)";

	public static final Long JRANKS_BEGINNER = 1L;
	public static final String JRANKS_BEGINNER_STR = "Beginner";
	public static final Long JRANKS_BEGINNER_RANK = 1L;
	public static final Long JRANKS_BEGINNER_THRESHOLD = 0L;
	public static final Long JRANKS_INTERMEDIATE = 2L;
	public static final String JRANKS_INTERMEDIATE_STR = "Intermediate";
	public static final Long JRANKS_INTERMEDIATE_RANK = 2L;
	public static final Long JRANKS_INTERMEDIATE_THRESHOLD = 100L;
	public static final Long JRANKS_EXPERT = 3L;
	public static final String JRANKS_EXPERT_STR = "Expert";
	public static final Long JRANKS_EXPERT_RANK = 3L;
	public static final Long JRANKS_EXPERT_THRESHOLD = 1000L;
	public static final Long JRANKS_JGURU = 4L;
	public static final String JRANKS_JGURU_STR = "JGuru";
	public static final Long JRANKS_JGURU_RANK = 4L;
	public static final Long JRANKS_JGURU_THRESHOLD = 10000L;
	public static final Long ANG4RANKS_BEGINNER = 5L;
	public static final String ANG4RANKS_BEGINNER_STR = "Beginner";
	public static final Long ANG4RANKS_BEGINNER_RANK = 1L;
	public static final Long ANG4RANKS_BEGINNER_THRESHOLD = 0L;
	public static final Long ANG4RANKS_INTERMEDIATE = 6L;
	public static final String ANG4RANKS_INTERMEDIATE_STR = "Intermediate";
	public static final Long ANG4RANKS_INTERMEDIATE_RANK = 2L;
	public static final Long ANG4RANKS_INTERMEDIATE_THRESHOLD = 100L;
	public static final Long ANG4RANKS_EXPERT = 7L;
	public static final String ANG4RANKS_EXPERT_STR = "Expert";
	public static final Long ANG4RANKS_EXPERT_RANK = 3L;
	public static final Long ANG4RANKS_EXPERT_THRESHOLD = 1000L;
	public static final Long ANG4RANKS_NGACE = 8L;
	public static final String ANG4RANKS_NGACE_STR = "NgAce";
	public static final Long ANG4RANKS_NGACE_RANK = 4L;
	public static final Long ANG4RANKS_NGACE_THRESHOLD = 10000L;
	public static final Long DVOPSRANKS_BEGINNER = 9L;
	public static final String DVOPSRANKS_BEGINNER_STR = "Beginner";
	public static final Long DVOPSRANKS_BEGINNER_RANK = 1L;
	public static final Long DVOPSRANKS_BEGINNER_THRESHOLD = 0L;
	public static final Long DVOPSRANKS_INTERMEDIATE = 10L;
	public static final String DVOPSRANKS_INTERMEDIATE_STR = "Intermediate";
	public static final Long DVOPSRANKS_INTERMEDIATE_RANK = 2L;
	public static final Long DVOPSRANKS_INTERMEDIATE_THRESHOLD = 100L;
	public static final Long DVOPSRANKS_EXPERT = 11L;
	public static final String DVOPSRANKS_EXPERT_STR = "Expert";
	public static final Long DVOPSRANKS_EXPERT_RANK = 3L;
	public static final Long DVOPSRANKS_EXPERT_THRESHOLD = 1000L;
	public static final Long DVOPSRANKS_SCRUM_LORD = 12L;
	public static final String DVOPSRANKS_SCRUM_LORD_STR = "Scrum Lord";
	public static final Long DVOPSRANKS_SCRUM_LORD_RANK = 4L;
	public static final Long DVOPSRANKS_SCRUM_LORD_THRESHOLD = 10000L;
	public static final Long HBMRANKS_BEGINNER = 13L;
	public static final String HBMRANKS_BEGINNER_STR = "Beginner";
	public static final Long HBMRANKS_BEGINNER_RANK = 1L;
	public static final Long HBMRANKS_BEGINNER_THRESHOLD = 0L;
	public static final Long HBMRANKS_INTERMEDIATE = 14L;
	public static final String HBMRANKS_INTERMEDIATE_STR = "Intermediate";
	public static final Long HBMRANKS_INTERMEDIATE_RANK = 2L;
	public static final Long HBMRANKS_INTERMEDIATE_THRESHOLD = 100L;
	public static final Long HBMRANKS_EXPERT = 15L;
	public static final String HBMRANKS_EXPERT_STR = "Expert";
	public static final Long HBMRANKS_EXPERT_RANK = 3L;
	public static final Long HBMRANKS_EXPERT_THRESHOLD = 1000L;
	public static final Long HBMRANKS_HBMASTER = 16L;
	public static final String HBMRANKS_HBMASTER_STR = "HBMaster";
	public static final Long HBMRANKS_HBMASTER_RANK = 4L;
	public static final Long HBMRANKS_HBMASTER_THRESHOLD = 10000L;
	public static final Long DPRANKS_BEGINNER = 17L;
	public static final String DPRANKS_BEGINNER_STR = "Beginner";
	public static final Long DPRANKS_BEGINNER_RANK = 1L;
	public static final Long DPRANKS_BEGINNER_THRESHOLD = 0L;
	public static final Long DPRANKS_INTERMEDIATE = 18L;
	public static final String DPRANKS_INTERMEDIATE_STR = "Intermediate";
	public static final Long DPRANKS_INTERMEDIATE_THRESHOLD = 100L;
	public static final Long DPRANKS_INTERMEDIATE_RANK = 2L;
	public static final Long DPRANKS_EXPERT = 19L;
	public static final String DPRANKS_EXPERT_STR = "Expert";
	public static final Long DPRANKS_EXPERT_RANK = 3L;
	public static final Long DPRANKS_EXPERT_THRESHOLD = 1000L;
	public static final Long DPRANKS_MASTER = 20L;
	public static final String DPRANKS_MASTER_STR = "GoF King";
	public static final Long DPRANKS_MASTER_RANK = 4L;
	public static final Long DPRANKS_MASTER_THRESHOLD = 10000L;

	public static final Long QREASON_WRONG = 1L;
	public static final String QREASON_WRONG_STR = "The question is wrong";
	public static final Long QREASON_OFF_TOPIC = 2L;
	public static final String QREASON_OFF_TOPIC_STR = "The question is off-topic";
	public static final Long QREASON_NOT_A_QUESTION = 3L;
	public static final String QREASON_NOT_A_QUESTION_STR = "The question is not really a question";
	public static final Long QREASON_TOO_VAGUE = 4L;
	public static final String QREASON_TOO_VAGUE_STR = "The question is too vague";
	public static final Long QREASON_CONFUSING = 5L;
	public static final String QREASON_CONFUSING_STR = "The question is too confusing";
	public static final Long QREASON_WRONG_DIFFICULTY = 6L;
	public static final String QREASON_WRONG_DIFFICULTY_STR = "The question should be a different difficulty";
	public static final Long QREASON_OTHER = 7L;
	public static final String QREASON_OTHER_STR = "Please specify:";

	public static final Long USER_REASON_ABUSIVE = 8L;
	public static final String USER_REASON_ABUSIVE_STR = "The user exercised abusive behavior";
	public static final Long USER_REASON_FAKE_ACCOUNT = 9L;
	public static final String USER_REASON_FAKE_ACCOUNT_STR = "I suspect this user is a fake account";
	public static final Long USER_REASON_STOLEN_INTELLECTUAL_PROPERTY = 10L;
	public static final String USER_REASON_STOLEN_INTELLECTUAL_PROPERTY_STR = "This account is using my intellectual property or identity";
	public static final Long USER_REASON_SPAMMER = 11L;
	public static final String USER_REASON_SPAMMER_STR = "This user is spamming";
	public static final Long USER_REASON_OTHER = 12L;
	public static final String USER_REASON_OTHER_STR = "Please specify:";

	public static final Long MIME_PDF = 1L;
	public static final String MIME_PDF_STR = "application/pdf";
	public static final Long MIME_JPG = 2L;
	public static final String MIME_JPG_STR = "image/jpeg";
	public static final Long MIME_PNG = 3L;
	public static final String MIME_PNG_STR = "image/png";

	// Message statuses

	// Email and SMS have different functions. Below is a layout for how
	// SMS differs from Email programatically (Email is the in-app inbox)

	// SMS will show read to sender and nothing to receiver,
	// Email will show read to receiver and received to sender
	public static final Long MESSAGE_STATUS_READ = 1L;
	public static final String MESSAGE_STATUS_READ_STR = "Read";

	// Email will show unread to receiver and received to sender
	// SMS will say unread (have some styling for unread) for receiver and
	// sender will say delivered.
	public static final Long MESSAGE_STATUS_UNREAD = 2L;
	public static final String MESSAGE_STATUS_UNREAD_STR = "Unread";

	// SMS will show read to sender and message will disappear from receiver view,
	// Email will disappear from receiver's view and will show received to user
	public static final Long MESSAGE_STATUS_DELETED = 3L;
	public static final String MESSAGE_STATUS_DELETED_STR = "Deleted";

	// For both SMS and Email this status is shown if the message is sent
	// to a mail server but not delivered to the receiver
	public static final Long MESSAGE_STATUS_SENT = 4L;
	public static final String MESSAGE_STATUS_SENT_STR = "Sent";

	// SMS will show this when the message delivers to the receiver
	public static final Long MESSAGE_STATUS_DELIVERED = 5L;
	public static final String MESSAGE_STATUS_DELIVERED_STR = "Delivered";

	// Email will show this when the message delivers to the receiver
	public static final Long MESSAGE_STATUS_RECEIVED = 6L;
	public static final String MESSAGE_STATUS_RECEIVED_STR = "Received";

	public static final Long REQUEST_STATUS_PENDING = 1L;
	public static final String REQUEST_STATUS_PENDING_STR = "Pending";

	public static final Long REQUEST_STATUS_APPROVED = 2L;
	public static final String REQUEST_STATUS_APPROVED_STR = "Approved";

	public static final Long REQUEST_STATUS_DENIED = 3L;
	public static final String REQUEST_STATUS_DENIED_STR = "Denied";

	public static final Float BASE_TF = 10.f;
	public static final Float BASE_MULT = 15.f;
	public static final Float BASE_CODE = 100.f;

	public static final long ADV_USER_PTS = 1000L;

    public static Map<Long, Rank> getAngular4Ranks() {
		return new LinkedHashMap<>(angular4Ranks);
	}

	public static Map<Long, QuestionType> getQuestionTypes() {
		return new LinkedHashMap<>(questionTypes);
	}

	public static Map<Long, String> getUserRoles() {
		return new LinkedHashMap<>(userRoles);
	}

	public static Map<Long, String> getUserStatuses() {
		return new LinkedHashMap<>(userStatuses);
	}

	public static Map<Long, String> getReasonTypes() {
		return new LinkedHashMap<>(reasonTypes);
	}

	public static Map<Long, Certification> getCertifications() {
		return new LinkedHashMap<>(certifications);
	}

	public static Map<Long, Rank> getJRanks() {
		return new LinkedHashMap<>(javaRanks);
	}

	public static Map<Long, Rank> getDevOpsRanks() {
		return new LinkedHashMap<>(devOpsRanks);
	}

	public static Map<Long, Rank> getHibernateRanks() {
		return new LinkedHashMap<>(hibernateRanks);
	}

	public static Map<Long, Reason> getQuestionReasons() {
		return new LinkedHashMap<>(questionReasons);
	}

	public static Map<Long, Rank> getDesignPatternRanks() {
		return new LinkedHashMap<>(designPatternRanks);
	}

	public static Map<Long, Reason> getUserReasons() {
		return new LinkedHashMap<>(userReasons);
	}

	public static Map<Long, QuestionDifficulty> getQuestionDifficulties() {
		return new LinkedHashMap<>(questionDifficulties);
	}

	public static Map<Long, String> getMimeTypes() {
		return new LinkedHashMap<>(mimeTypes);
	}

	public static Map<Long, String> getMessageStatuses() {
		return new LinkedHashMap<>(messageStatuses);
	}

	public static Map<Long, String> getRequestStatuses() {
		return new LinkedHashMap<>(requestStatuses);
	}

	static {

		// implemented for demo
		javaRanks.put(JRANKS_BEGINNER,
				new Rank(JRANKS_BEGINNER, JRANKS_BEGINNER_STR, JRANKS_BEGINNER_RANK, JRANKS_BEGINNER_THRESHOLD));
		javaRanks.put(JRANKS_INTERMEDIATE, new Rank(JRANKS_INTERMEDIATE, JRANKS_INTERMEDIATE_STR,
				JRANKS_INTERMEDIATE_RANK, JRANKS_INTERMEDIATE_THRESHOLD));
		javaRanks.put(JRANKS_EXPERT,
				new Rank(JRANKS_EXPERT, JRANKS_EXPERT_STR, JRANKS_EXPERT_RANK, JRANKS_EXPERT_THRESHOLD));
		javaRanks.put(JRANKS_JGURU,
				new Rank(JRANKS_JGURU, JRANKS_JGURU_STR, JRANKS_JGURU_RANK, JRANKS_JGURU_THRESHOLD));
		
		angular4Ranks.put(ANG4RANKS_BEGINNER, new Rank(ANG4RANKS_BEGINNER, ANG4RANKS_BEGINNER_STR,
				ANG4RANKS_BEGINNER_RANK, ANG4RANKS_BEGINNER_THRESHOLD));
		angular4Ranks.put(ANG4RANKS_INTERMEDIATE, new Rank(ANG4RANKS_INTERMEDIATE, ANG4RANKS_INTERMEDIATE_STR,
				ANG4RANKS_INTERMEDIATE_RANK, ANG4RANKS_INTERMEDIATE_THRESHOLD));
		angular4Ranks.put(ANG4RANKS_EXPERT,
				new Rank(ANG4RANKS_EXPERT, ANG4RANKS_EXPERT_STR, ANG4RANKS_EXPERT_RANK, ANG4RANKS_EXPERT_THRESHOLD));
		angular4Ranks.put(ANG4RANKS_NGACE,
				new Rank(ANG4RANKS_NGACE, ANG4RANKS_NGACE_STR, ANG4RANKS_NGACE_RANK, ANG4RANKS_NGACE_THRESHOLD));

		devOpsRanks.put(DVOPSRANKS_BEGINNER, new Rank(DVOPSRANKS_BEGINNER, DVOPSRANKS_BEGINNER_STR,
				DVOPSRANKS_BEGINNER_RANK, DVOPSRANKS_BEGINNER_THRESHOLD));
		devOpsRanks.put(DVOPSRANKS_INTERMEDIATE, new Rank(DVOPSRANKS_INTERMEDIATE, DVOPSRANKS_INTERMEDIATE_STR,
				DVOPSRANKS_INTERMEDIATE_RANK, DVOPSRANKS_INTERMEDIATE_THRESHOLD));
		devOpsRanks.put(DVOPSRANKS_EXPERT, new Rank(DVOPSRANKS_EXPERT, DVOPSRANKS_EXPERT_STR, DVOPSRANKS_EXPERT_RANK,
				DVOPSRANKS_EXPERT_THRESHOLD));
		devOpsRanks.put(DVOPSRANKS_SCRUM_LORD, new Rank(DVOPSRANKS_SCRUM_LORD, DVOPSRANKS_SCRUM_LORD_STR,
				DVOPSRANKS_SCRUM_LORD_RANK, DVOPSRANKS_SCRUM_LORD_THRESHOLD));

		hibernateRanks.put(HBMRANKS_BEGINNER, new Rank(HBMRANKS_BEGINNER, HBMRANKS_BEGINNER_STR, HBMRANKS_BEGINNER_RANK,
				HBMRANKS_BEGINNER_THRESHOLD));
		hibernateRanks.put(HBMRANKS_INTERMEDIATE, new Rank(HBMRANKS_INTERMEDIATE, HBMRANKS_INTERMEDIATE_STR,
				HBMRANKS_INTERMEDIATE_RANK, HBMRANKS_INTERMEDIATE_THRESHOLD));
		hibernateRanks.put(HBMRANKS_EXPERT,
				new Rank(HBMRANKS_EXPERT, HBMRANKS_EXPERT_STR, HBMRANKS_EXPERT_RANK, HBMRANKS_EXPERT_THRESHOLD));
		hibernateRanks.put(HBMRANKS_HBMASTER, new Rank(HBMRANKS_HBMASTER, HBMRANKS_HBMASTER_STR, HBMRANKS_HBMASTER_RANK,
				HBMRANKS_HBMASTER_THRESHOLD));

		designPatternRanks.put(DPRANKS_BEGINNER,
				new Rank(DPRANKS_BEGINNER, DPRANKS_BEGINNER_STR, DPRANKS_BEGINNER_RANK, DPRANKS_BEGINNER_THRESHOLD));
		designPatternRanks.put(DPRANKS_INTERMEDIATE, new Rank(DPRANKS_INTERMEDIATE, DPRANKS_INTERMEDIATE_STR,
				DPRANKS_INTERMEDIATE_RANK, DPRANKS_INTERMEDIATE_THRESHOLD));
		designPatternRanks.put(DPRANKS_EXPERT,
				new Rank(DPRANKS_EXPERT, DPRANKS_EXPERT_STR, DPRANKS_EXPERT_RANK, DPRANKS_EXPERT_THRESHOLD));
		designPatternRanks.put(DPRANKS_MASTER,
				new Rank(DPRANKS_MASTER, DPRANKS_MASTER_STR, DPRANKS_MASTER_RANK, DPRANKS_MASTER_THRESHOLD));

		// not yet implemented
		j2eeRanks.put(JRANKS_BEGINNER,
				new Rank(JRANKS_BEGINNER, JRANKS_BEGINNER_STR, JRANKS_BEGINNER_RANK, JRANKS_BEGINNER_THRESHOLD));
		j2eeRanks.put(JRANKS_INTERMEDIATE, new Rank(JRANKS_INTERMEDIATE, JRANKS_INTERMEDIATE_STR,
				JRANKS_INTERMEDIATE_RANK, JRANKS_INTERMEDIATE_THRESHOLD));
		j2eeRanks.put(JRANKS_EXPERT,
				new Rank(JRANKS_EXPERT, JRANKS_EXPERT_STR, JRANKS_EXPERT_RANK, JRANKS_EXPERT_THRESHOLD));
		j2eeRanks.put(JRANKS_JGURU,
				new Rank(JRANKS_JGURU, JRANKS_JGURU_STR, JRANKS_JGURU_RANK, JRANKS_JGURU_THRESHOLD));

		jpaRanks.put(JRANKS_BEGINNER,
				new Rank(JRANKS_BEGINNER, JRANKS_BEGINNER_STR, JRANKS_BEGINNER_RANK, JRANKS_BEGINNER_THRESHOLD));
		jpaRanks.put(JRANKS_INTERMEDIATE, new Rank(JRANKS_INTERMEDIATE, JRANKS_INTERMEDIATE_STR,
				JRANKS_INTERMEDIATE_RANK, JRANKS_INTERMEDIATE_THRESHOLD));
		jpaRanks.put(JRANKS_EXPERT,
				new Rank(JRANKS_EXPERT, JRANKS_EXPERT_STR, JRANKS_EXPERT_RANK, JRANKS_EXPERT_THRESHOLD));
		jpaRanks.put(JRANKS_JGURU, new Rank(JRANKS_JGURU, JRANKS_JGURU_STR, JRANKS_JGURU_RANK, JRANKS_JGURU_THRESHOLD));

		jtaRanks.put(JRANKS_BEGINNER,
				new Rank(JRANKS_BEGINNER, JRANKS_BEGINNER_STR, JRANKS_BEGINNER_RANK, JRANKS_BEGINNER_THRESHOLD));
		jtaRanks.put(JRANKS_INTERMEDIATE, new Rank(JRANKS_INTERMEDIATE, JRANKS_INTERMEDIATE_STR,
				JRANKS_INTERMEDIATE_RANK, JRANKS_INTERMEDIATE_THRESHOLD));
		jtaRanks.put(JRANKS_EXPERT,
				new Rank(JRANKS_EXPERT, JRANKS_EXPERT_STR, JRANKS_EXPERT_RANK, JRANKS_EXPERT_THRESHOLD));
		jtaRanks.put(JRANKS_JGURU, new Rank(JRANKS_JGURU, JRANKS_JGURU_STR, JRANKS_JGURU_RANK, JRANKS_JGURU_THRESHOLD));

		springRanks.put(JRANKS_BEGINNER,
				new Rank(JRANKS_BEGINNER, JRANKS_BEGINNER_STR, JRANKS_BEGINNER_RANK, JRANKS_BEGINNER_THRESHOLD));
		springRanks.put(JRANKS_INTERMEDIATE, new Rank(JRANKS_INTERMEDIATE, JRANKS_INTERMEDIATE_STR,
				JRANKS_INTERMEDIATE_RANK, JRANKS_INTERMEDIATE_THRESHOLD));
		springRanks.put(JRANKS_EXPERT,
				new Rank(JRANKS_EXPERT, JRANKS_EXPERT_STR, JRANKS_EXPERT_RANK, JRANKS_EXPERT_THRESHOLD));
		springRanks.put(JRANKS_JGURU,
				new Rank(JRANKS_JGURU, JRANKS_JGURU_STR, JRANKS_JGURU_RANK, JRANKS_JGURU_THRESHOLD));

		plSQLRanks.put(JRANKS_BEGINNER,
				new Rank(JRANKS_BEGINNER, JRANKS_BEGINNER_STR, JRANKS_BEGINNER_RANK, JRANKS_BEGINNER_THRESHOLD));
		plSQLRanks.put(JRANKS_INTERMEDIATE, new Rank(JRANKS_INTERMEDIATE, JRANKS_INTERMEDIATE_STR,
				JRANKS_INTERMEDIATE_RANK, JRANKS_INTERMEDIATE_THRESHOLD));
		plSQLRanks.put(JRANKS_EXPERT,
				new Rank(JRANKS_EXPERT, JRANKS_EXPERT_STR, JRANKS_EXPERT_RANK, JRANKS_EXPERT_THRESHOLD));
		plSQLRanks.put(JRANKS_JGURU,
				new Rank(JRANKS_JGURU, JRANKS_JGURU_STR, JRANKS_JGURU_RANK, JRANKS_JGURU_THRESHOLD));

		tSQLRanks.put(JRANKS_BEGINNER,
				new Rank(JRANKS_BEGINNER, JRANKS_BEGINNER_STR, JRANKS_BEGINNER_RANK, JRANKS_BEGINNER_THRESHOLD));
		tSQLRanks.put(JRANKS_INTERMEDIATE, new Rank(JRANKS_INTERMEDIATE, JRANKS_INTERMEDIATE_STR,
				JRANKS_INTERMEDIATE_RANK, JRANKS_INTERMEDIATE_THRESHOLD));
		tSQLRanks.put(JRANKS_EXPERT,
				new Rank(JRANKS_EXPERT, JRANKS_EXPERT_STR, JRANKS_EXPERT_RANK, JRANKS_EXPERT_THRESHOLD));
		tSQLRanks.put(JRANKS_JGURU,
				new Rank(JRANKS_JGURU, JRANKS_JGURU_STR, JRANKS_JGURU_RANK, JRANKS_JGURU_THRESHOLD));

		mySQLRanks.put(JRANKS_BEGINNER,
				new Rank(JRANKS_BEGINNER, JRANKS_BEGINNER_STR, JRANKS_BEGINNER_RANK, JRANKS_BEGINNER_THRESHOLD));
		mySQLRanks.put(JRANKS_INTERMEDIATE, new Rank(JRANKS_INTERMEDIATE, JRANKS_INTERMEDIATE_STR,
				JRANKS_INTERMEDIATE_RANK, JRANKS_INTERMEDIATE_THRESHOLD));
		mySQLRanks.put(JRANKS_EXPERT,
				new Rank(JRANKS_EXPERT, JRANKS_EXPERT_STR, JRANKS_EXPERT_RANK, JRANKS_EXPERT_THRESHOLD));
		mySQLRanks.put(JRANKS_JGURU,
				new Rank(JRANKS_JGURU, JRANKS_JGURU_STR, JRANKS_JGURU_RANK, JRANKS_JGURU_THRESHOLD));

		postGreSQLRanks.put(JRANKS_BEGINNER,
				new Rank(JRANKS_BEGINNER, JRANKS_BEGINNER_STR, JRANKS_BEGINNER_RANK, JRANKS_BEGINNER_THRESHOLD));
		postGreSQLRanks.put(JRANKS_INTERMEDIATE, new Rank(JRANKS_INTERMEDIATE, JRANKS_INTERMEDIATE_STR,
				JRANKS_INTERMEDIATE_RANK, JRANKS_INTERMEDIATE_THRESHOLD));
		postGreSQLRanks.put(JRANKS_EXPERT,
				new Rank(JRANKS_EXPERT, JRANKS_EXPERT_STR, JRANKS_EXPERT_RANK, JRANKS_EXPERT_THRESHOLD));
		postGreSQLRanks.put(JRANKS_JGURU,
				new Rank(JRANKS_JGURU, JRANKS_JGURU_STR, JRANKS_JGURU_RANK, JRANKS_JGURU_THRESHOLD));

		webRanks.put(JRANKS_BEGINNER,
				new Rank(JRANKS_BEGINNER, JRANKS_BEGINNER_STR, JRANKS_BEGINNER_RANK, JRANKS_BEGINNER_THRESHOLD));
		webRanks.put(JRANKS_INTERMEDIATE, new Rank(JRANKS_INTERMEDIATE, JRANKS_INTERMEDIATE_STR,
				JRANKS_INTERMEDIATE_RANK, JRANKS_INTERMEDIATE_THRESHOLD));
		webRanks.put(JRANKS_EXPERT,
				new Rank(JRANKS_EXPERT, JRANKS_EXPERT_STR, JRANKS_EXPERT_RANK, JRANKS_EXPERT_THRESHOLD));
		webRanks.put(JRANKS_JGURU, new Rank(JRANKS_JGURU, JRANKS_JGURU_STR, JRANKS_JGURU_RANK, JRANKS_JGURU_THRESHOLD));

		jQueryRanks.put(JRANKS_BEGINNER,
				new Rank(JRANKS_BEGINNER, JRANKS_BEGINNER_STR, JRANKS_BEGINNER_RANK, JRANKS_BEGINNER_THRESHOLD));
		jQueryRanks.put(JRANKS_INTERMEDIATE, new Rank(JRANKS_INTERMEDIATE, JRANKS_INTERMEDIATE_STR,
				JRANKS_INTERMEDIATE_RANK, JRANKS_INTERMEDIATE_THRESHOLD));
		jQueryRanks.put(JRANKS_EXPERT,
				new Rank(JRANKS_EXPERT, JRANKS_EXPERT_STR, JRANKS_EXPERT_RANK, JRANKS_EXPERT_THRESHOLD));
		jQueryRanks.put(JRANKS_JGURU,
				new Rank(JRANKS_JGURU, JRANKS_JGURU_STR, JRANKS_JGURU_RANK, JRANKS_JGURU_THRESHOLD));

		angularJSRanks.put(JRANKS_BEGINNER,
				new Rank(JRANKS_BEGINNER, JRANKS_BEGINNER_STR, JRANKS_BEGINNER_RANK, JRANKS_BEGINNER_THRESHOLD));
		angularJSRanks.put(JRANKS_INTERMEDIATE, new Rank(JRANKS_INTERMEDIATE, JRANKS_INTERMEDIATE_STR,
				JRANKS_INTERMEDIATE_RANK, JRANKS_INTERMEDIATE_THRESHOLD));
		angularJSRanks.put(JRANKS_EXPERT,
				new Rank(JRANKS_EXPERT, JRANKS_EXPERT_STR, JRANKS_EXPERT_RANK, JRANKS_EXPERT_THRESHOLD));
		angularJSRanks.put(JRANKS_JGURU,
				new Rank(JRANKS_JGURU, JRANKS_JGURU_STR, JRANKS_JGURU_RANK, JRANKS_JGURU_THRESHOLD));

		microsRanks.put(JRANKS_BEGINNER,
				new Rank(JRANKS_BEGINNER, JRANKS_BEGINNER_STR, JRANKS_BEGINNER_RANK, JRANKS_BEGINNER_THRESHOLD));
		microsRanks.put(JRANKS_INTERMEDIATE, new Rank(JRANKS_INTERMEDIATE, JRANKS_INTERMEDIATE_STR,
				JRANKS_INTERMEDIATE_RANK, JRANKS_INTERMEDIATE_THRESHOLD));
		microsRanks.put(JRANKS_EXPERT,
				new Rank(JRANKS_EXPERT, JRANKS_EXPERT_STR, JRANKS_EXPERT_RANK, JRANKS_EXPERT_THRESHOLD));
		microsRanks.put(JRANKS_JGURU,
				new Rank(JRANKS_JGURU, JRANKS_JGURU_STR, JRANKS_JGURU_RANK, JRANKS_JGURU_THRESHOLD));

		certifications.put(ORACLE_CERTIFIED_ASSOCIATE, new Certification(ORACLE_CERTIFIED_ASSOCIATE,
				ORACLE_CERTIFIED_ASSOCIATE_STR, new Topic(TOPIC_CORE_JAVA)));
		certifications.put(ORACLE_CERTIFIED_PROFESSIONAL, new Certification(ORACLE_CERTIFIED_PROFESSIONAL,
				ORACLE_CERTIFIED_PROFESSIONAL_STR, new Topic(TOPIC_CORE_JAVA)));
		certifications.put(ORACLE_CERTIFIED_MASTER,
				new Certification(ORACLE_CERTIFIED_MASTER, ORACLE_CERTIFIED_MASTER_STR, new Topic(TOPIC_CORE_JAVA)));

		questionTypes.put(QUESTION_TRUE_FALSE, new QuestionType(QUESTION_TRUE_FALSE, QUESTION_TRUE_FALSE_STR, BASE_TF));
		questionTypes.put(QUESTION_MULTI_CHOICE,
				new QuestionType(QUESTION_MULTI_CHOICE, QUESTION_MULTI_CHOICE_STR, BASE_MULT));
		questionTypes.put(QUESTION_CODE, new QuestionType(QUESTION_CODE, QUESTION_CODE_STR, BASE_CODE));

		questionDifficulties.put(DIFFICULTY_EASY,
				new QuestionDifficulty(DIFFICULTY_EASY, DIFFICULTY_EASY_STR, DIFFICULTY_EASY_MULTIPLIER));
		questionDifficulties.put(DIFFICULTY_MEDIUM,
				new QuestionDifficulty(DIFFICULTY_MEDIUM, DIFFICULTY_MEDIUM_STR, DIFFICULTY_MEDIUM_MULTIPLIER));
		questionDifficulties.put(DIFFICULTY_HARD,
				new QuestionDifficulty(DIFFICULTY_HARD, DIFFICULTY_HARD_STR, DIFFICULTY_HARD_MULTIPLIER));
		questionDifficulties.put(DIFFICULTY_VERY_HARD, new QuestionDifficulty(DIFFICULTY_VERY_HARD,
				DIFFICULTY_VERY_HARD_STR, DIFFICULTY_VERY_HARD_MULTIPLIER));

		userRoles.put(ROLE_BASIC, ROLE_BASIC_STR);
		userRoles.put(ROLE_ADVANCED, ROLE_ADVANCED_STR);
		userRoles.put(ROLE_CERTIFIED, ROLE_CERTIFIED_STR);
		userRoles.put(ROLE_ADMIN, ROLE_ADMIN_STR);

		userStatuses.put(STATUS_OK, STATUS_OK_STR);
		userStatuses.put(STATUS_LOCKED, STATUS_LOCKED_STR);
		userStatuses.put(STATUS_PENDING, STATUS_PENDING_STR);
		userStatuses.put(STATUS_BANNED, STATUS_BANNED_STR);

		reasonTypes.put(REASON_TYPE_QUESTION, REASON_TYPE_QUESTION_STR);
		reasonTypes.put(REASON_TYPE_USER, REASON_TYPE_USER_STR);

		topics.put(TOPIC_CORE_JAVA,
				new Topic(TOPIC_CORE_JAVA, TOPIC_CORE_JAVA_STR, new HashSet<Rank>(javaRanks.values())));
		for(Rank r : javaRanks.values()) {
			r.setTopic(topics.get(TOPIC_CORE_JAVA));
		}
		
		topics.put(TOPIC_J2EE, new Topic(TOPIC_J2EE, TOPIC_J2EE_STR, new HashSet<Rank>(j2eeRanks.values())));
		for(Rank r : j2eeRanks.values()) {
			r.setTopic(topics.get(TOPIC_J2EE));
		}
		
		topics.put(TOPIC_JTA, new Topic(TOPIC_JTA, TOPIC_JTA_STR, new HashSet<Rank>(jtaRanks.values())));
		for(Rank r : jtaRanks.values()) {
			r.setTopic(topics.get(TOPIC_JTA));
		}
		
		topics.put(TOPIC_HIBERNATE,
				new Topic(TOPIC_HIBERNATE, TOPIC_HIBERNATE_STR, new HashSet<Rank>(hibernateRanks.values())));
		for(Rank r : hibernateRanks.values()) {
			r.setTopic(topics.get(TOPIC_HIBERNATE));
		}
		
		topics.put(TOPIC_JPA, new Topic(TOPIC_JPA, TOPIC_JPA_STR, new HashSet<Rank>(jpaRanks.values())));
		for(Rank r : jpaRanks.values()) {
			r.setTopic(topics.get(TOPIC_JPA));
		}
		
		topics.put(TOPIC_SPRING,
				new Topic(TOPIC_SPRING, TOPIC_SPRING_STR, new HashSet<Rank>(springRanks.values())));
		for(Rank r : springRanks.values()) {
			r.setTopic(topics.get(TOPIC_SPRING));
		}
		
		topics.put(TOPIC_PLSQL, new Topic(TOPIC_PLSQL, TOPIC_PLSQL_STR, new HashSet<Rank>(plSQLRanks.values())));
		for(Rank r : plSQLRanks.values()) {
			r.setTopic(topics.get(TOPIC_PLSQL));
		}
		
		topics.put(TOPIC_TSQL, new Topic(TOPIC_TSQL, TOPIC_TSQL_STR, new HashSet<Rank>(tSQLRanks.values())));
		for(Rank r : tSQLRanks.values()) {
			r.setTopic(topics.get(TOPIC_TSQL));
		}
		
		topics.put(TOPIC_MYSQL, new Topic(TOPIC_MYSQL, TOPIC_MYSQL_STR, new HashSet<Rank>(mySQLRanks.values())));
		for(Rank r : mySQLRanks.values()) {
			r.setTopic(topics.get(TOPIC_MYSQL));
		}
		
		topics.put(TOPIC_POSTGRESQL,
				new Topic(TOPIC_POSTGRESQL, TOPIC_POSTGRESQL_STR, new HashSet<Rank>(postGreSQLRanks.values())));
		for(Rank r : postGreSQLRanks.values()) {
			r.setTopic(topics.get(TOPIC_POSTGRESQL));
		}

		topics.put(TOPIC_WEB_DEV,
				new Topic(TOPIC_WEB_DEV, TOPIC_WEB_DEV_STR, new HashSet<Rank>(webRanks.values())));
		for(Rank r : webRanks.values()) {
			r.setTopic(topics.get(TOPIC_WEB_DEV));
		}
		
		topics.put(TOPIC_JQUERY,
				new Topic(TOPIC_JQUERY, TOPIC_JQUERY_STR, new HashSet<Rank>(jQueryRanks.values())));
		for(Rank r : jQueryRanks.values()) {
			r.setTopic(topics.get(TOPIC_JQUERY));
		}
		
		topics.put(TOPIC_ANGULARJS,
				new Topic(TOPIC_ANGULARJS, TOPIC_ANGULARJS_STR, new HashSet<Rank>(angularJSRanks.values())));
		for(Rank r : angularJSRanks.values()) {
			r.setTopic(topics.get(TOPIC_ANGULARJS));
		}
		
		topics.put(TOPIC_ANGULAR4,
				new Topic(TOPIC_ANGULAR4, TOPIC_ANGULAR4_STR, new HashSet<Rank>(angular4Ranks.values())));
		for(Rank r : angular4Ranks.values()) {
			r.setTopic(topics.get(TOPIC_ANGULAR4));
		}
		
		topics.put(TOPIC_DEVOPS,
				new Topic(TOPIC_DEVOPS, TOPIC_DEVOPS_STR, new HashSet<Rank>(devOpsRanks.values())));
		for(Rank r : devOpsRanks.values()) {
			r.setTopic(topics.get(TOPIC_DEVOPS));
		}
		
		topics.put(TOPIC_MICROSERVICES,
				new Topic(TOPIC_MICROSERVICES, TOPIC_MICROSERVICES_STR, new HashSet<Rank>(microsRanks.values())));
		for(Rank r : microsRanks.values()) {
			r.setTopic(topics.get(TOPIC_MICROSERVICES));
		}
		
		topics.put(TOPIC_DESIGN_PATTERNS, new Topic(TOPIC_DESIGN_PATTERNS, TOPIC_DESIGN_PATTERNS_STR,
				new HashSet<Rank>(designPatternRanks.values())));
		for(Rank r : designPatternRanks.values()) {
			r.setTopic(topics.get(TOPIC_DESIGN_PATTERNS));
		}		

		questionReasons.put(QREASON_WRONG, new Reason(QREASON_WRONG, QREASON_WRONG_STR, "Todo: insert description",
				new ReasonType(REASON_TYPE_QUESTION)));
		questionReasons.put(QREASON_OFF_TOPIC, new Reason(QREASON_OFF_TOPIC, QREASON_OFF_TOPIC_STR,
				"Todo: insert description", new ReasonType(REASON_TYPE_QUESTION)));
		questionReasons.put(QREASON_NOT_A_QUESTION, new Reason(QREASON_NOT_A_QUESTION, QREASON_NOT_A_QUESTION_STR,
				"Todo: insert description", new ReasonType(REASON_TYPE_QUESTION)));
		questionReasons.put(QREASON_TOO_VAGUE, new Reason(QREASON_TOO_VAGUE, QREASON_TOO_VAGUE_STR,
				"Todo: insert description", new ReasonType(REASON_TYPE_QUESTION)));
		questionReasons.put(QREASON_CONFUSING, new Reason(QREASON_CONFUSING, QREASON_CONFUSING_STR,
				"Todo: insert description", new ReasonType(REASON_TYPE_QUESTION)));
		questionReasons.put(QREASON_WRONG_DIFFICULTY, new Reason(QREASON_WRONG_DIFFICULTY, QREASON_WRONG_DIFFICULTY_STR,
				"Todo: insert description", new ReasonType(REASON_TYPE_QUESTION)));
		questionReasons.put(QREASON_OTHER, new Reason(QREASON_OTHER, QREASON_OTHER_STR, "Todo: insert description",
				new ReasonType(REASON_TYPE_QUESTION)));

		userReasons.put(USER_REASON_ABUSIVE, new Reason(USER_REASON_ABUSIVE, USER_REASON_ABUSIVE_STR,
				"Todo: insert description", new ReasonType(REASON_TYPE_USER)));
		userReasons.put(USER_REASON_FAKE_ACCOUNT, new Reason(USER_REASON_FAKE_ACCOUNT, USER_REASON_FAKE_ACCOUNT_STR,
				"Todo: insert description", new ReasonType(REASON_TYPE_USER)));
		userReasons.put(USER_REASON_STOLEN_INTELLECTUAL_PROPERTY,
				new Reason(USER_REASON_STOLEN_INTELLECTUAL_PROPERTY, USER_REASON_STOLEN_INTELLECTUAL_PROPERTY_STR,
						"Todo: insert description", new ReasonType(REASON_TYPE_USER)));
		userReasons.put(USER_REASON_SPAMMER, new Reason(USER_REASON_SPAMMER, USER_REASON_SPAMMER_STR,
				"Todo: insert description", new ReasonType(REASON_TYPE_USER)));
		userReasons.put(USER_REASON_OTHER, new Reason(USER_REASON_OTHER, USER_REASON_OTHER_STR,
				"Todo: insert description", new ReasonType(REASON_TYPE_USER)));

		mimeTypes.put(MIME_PDF, MIME_PDF_STR);
		mimeTypes.put(MIME_JPG, MIME_JPG_STR);
		mimeTypes.put(MIME_PNG, MIME_PNG_STR);

		messageStatuses.put(MESSAGE_STATUS_READ, MESSAGE_STATUS_READ_STR);
		messageStatuses.put(MESSAGE_STATUS_UNREAD, MESSAGE_STATUS_UNREAD_STR);
		messageStatuses.put(MESSAGE_STATUS_DELETED, MESSAGE_STATUS_DELETED_STR);
		messageStatuses.put(MESSAGE_STATUS_SENT, MESSAGE_STATUS_SENT_STR);
		messageStatuses.put(MESSAGE_STATUS_DELIVERED, MESSAGE_STATUS_DELIVERED_STR);
		messageStatuses.put(MESSAGE_STATUS_RECEIVED, MESSAGE_STATUS_RECEIVED_STR);

		requestStatuses.put(REQUEST_STATUS_PENDING, REQUEST_STATUS_PENDING_STR);
		requestStatuses.put(REQUEST_STATUS_APPROVED, REQUEST_STATUS_APPROVED_STR);
		requestStatuses.put(REQUEST_STATUS_DENIED, REQUEST_STATUS_DENIED_STR);

	}

	public static Map<Long, QuestionType> getQuestiontypes() {
		return questionTypes;
	}

	public static Map<Long, QuestionDifficulty> getQuestiondifficulties() {
		return questionDifficulties;
	}

	public static Map<Long, String> getUserroles() {
		return userRoles;
	}

	public static Map<Long, String> getUserstatuses() {
		return userStatuses;
	}

	public static Map<Long, String> getReasontypes() {
		return reasonTypes;
	}

	public static Map<Long, Rank> getJavaranks() {
		return javaRanks;
	}

	public static Map<Long, Rank> getJ2eeranks() {
		return j2eeRanks;
	}

	public static Map<Long, Rank> getJtaranks() {
		return jtaRanks;
	}

	public static Map<Long, Rank> getJparanks() {
		return jpaRanks;
	}

	public static Map<Long, Rank> getSpringranks() {
		return springRanks;
	}

	public static Map<Long, Rank> getPlsqlranks() {
		return plSQLRanks;
	}

	public static Map<Long, Rank> getTsqlranks() {
		return tSQLRanks;
	}

	public static Map<Long, Rank> getMysqlranks() {
		return mySQLRanks;
	}

	public static Map<Long, Rank> getPostgresqlranks() {
		return postGreSQLRanks;
	}

	public static Map<Long, Rank> getWebranks() {
		return webRanks;
	}

	public static Map<Long, Rank> getJqueryranks() {
		return jQueryRanks;
	}

	public static Map<Long, Rank> getAngularjsranks() {
		return angularJSRanks;
	}

	public static Map<Long, Rank> getAngular4ranks() {
		return angular4Ranks;
	}

	public static Map<Long, Rank> getHibernateranks() {
		return hibernateRanks;
	}

	public static Map<Long, Rank> getDevopsranks() {
		return devOpsRanks;
	}

	public static Map<Long, Rank> getMicrosranks() {
		return microsRanks;
	}

	public static Map<Long, Rank> getDesignpatternranks() {
		return designPatternRanks;
	}

	public static Map<Long, Reason> getQuestionreasons() {
		return questionReasons;
	}

	public static Map<Long, Reason> getUserreasons() {
		return userReasons;
	}

	public static Map<Long, String> getMimetypes() {
		return mimeTypes;
	}

	public static Map<Long, String> getMessagestatuses() {
		return messageStatuses;
	}

	public static Map<Long, String> getRequeststatuses() {
		return requestStatuses;
	}

	public static Map<Long, Topic> getTopics() {
		return topics;
	}

	// Tables
	public static final String TABLE_USER_ROLE = "USER_ROLE";
	public static final String TABLE_USER_STATUS = "USER_STATUS";
	public static final String TABLE_USER_CERTIFICATION = "USER_CERTIFICATION";
	public static final String TABLE_APP_USER = "APP_USER";
	public static final String TABLE_FRIEND = "FRIEND";
	public static final String TABLE_TOPIC = "TOPIC";
	public static final String TABLE_REPORT_QUESTION = "REPORT_QUESTION";
	public static final String TABLE_REPORT_USER = "REPORT_USER";
	public static final String TABLE_REASON_TYPE = "REASON_TYPE";
	public static final String TABLE_REASON = "REASON";
	public static final String TABLE_QUIZ = "QUIZ";
	public static final String TABLE_RANK = "RANK";
	public static final String TABLE_QUESTION_TYPE = "QUESTION_TYPE";
	public static final String TABLE_QUESTION_OPTIONS = "QUESTION_OPTION";
	public static final String TABLE_QUESTION_DIFFICULTY = "QUESTION_DIFFICULTY";
	public static final String TABLE_QUESTION = "QUESTION";
	public static final String TABLE_NOTIFICATION = "NOTIFICATION";
	public static final String TABLE_MIME_TYPE = "MIME_TYPE";
	public static final String TABLE_MESSAGE_STATUS = "MESSAGE_STATUS";
	public static final String TABLE_MESSAGE = "MESSAGE";
	public static final String TABLE_FILE_BLOB = "FILE_BLOB";
	public static final String TABLE_USER_CREDENTIALS = "USER_CREDENTIALS";
	public static final String TABLE_CERTIFICATION = "CERTIFICATION";
	public static final String TABLE_REQUEST_STATUS = "REQUEST_STATUS";
	public static final String TABLE_USER_RANK = "USER_RANK";
	public static final String TABLE_QUIZ_QUESTION = "QUIZ_QUESTION";
	public static final String TABLE_MESSAGE_ATTACHMENT = "MESSAGE_ATTACHMENT";
	public static final String TABLE_CHALLENGE_ATTEMPT = "CHALLENGE_ATTEMPT";
	public static final String TABLE_QUIZ_ATTEMPT = "QUIZ_ATTEMPT";
	public static final String TABLE_CHALLENGE = "CHALLENGE";
	public static final String TABLE_RESULTS = "RESULTS";
	public static final String TABLE_USER_RESULTS = "USER_RESULT";
	public static final String TABLE_USER_CHALLENGE_ATTEMPT = "USER_CHALLENGE_ATTEMPT";
	public static final String TABLE_CHALLENGE_QUIZ = "CHALLENGE_QUIZ";
	public static final String TABLE_QUIZ_ATTEMPT_ANSWERS = "QUIZ_ATTEMPT_ANSWERS";
	public static final String TABLE_CHALLENGE_ATTEMPT_ANSWERS = "CHALLENGE_ATTEMPT_ANSWERS";

	// Columns
	public static final String COLUMN_RANK_ID = "RANK_ID";
	public static final String COLUMN_OPTION_ID = "OPTION_ID";
	public static final String COLUMN_MERIT = "MERIT";
	public static final String COLUMN_ROLE_ID = "ROLE_ID";
	public static final String COLUMN_ROLE_NAME = "ROLE_NAME";
	public static final String COLUMN_STATUS_ID = "STATUS_ID";
	public static final String COLUMN_STATUS_NAME = "STATUS_NAME";
	public static final String COLUMN_BLOB_ID = "BLOB_ID";
	public static final String COLUMN_USER_ID = "USER_ID";
	public static final String COLUMN_CERTIFICATION_ID = "CERTIFICATOIN_ID";
	public static final String COlUMN_FNAME = "FNAME";
	public static final String COLUMN_MNAME = "MNAME";
	public static final String COLUMN_LNAME = "LNAME";
	public static final String COLUMN_USER1_ID = "USER1_ID";
	public static final String COLUMN_FRIEND_ID = "FRIEND_ID";
	public static final String COLUMN_TOPIC_ID = "TOPIC_ID";
	public static final String COLUMN_TOPIC_NAME = "TOPIC_NAME";
	public static final String COLUMN_TYPE_ID = "TYPE_ID";
	public static final String COLUMN_REASON_TYPE = "REASON_TYPE";
	public static final String COLUMN_REASON_ID = "REASON_ID";
	public static final String COLUMN_REASON = "REASON";
	public static final String COLUMN_RANK_NAME = "RANK_NAME";
	public static final String COLUMN_RANK_IN_HEIRARCHY = "RANK_IN_HEIRARCHY";
	public static final String COLUMN_MERIT_THRESHOLD = "MERIT_THRESHOLD";
	public static final String COLUMN_QUIZ_ID = "QUIZ_ID";
	public static final String COLUMN_USER_SENDER = "USER_SENDER";
	public static final String COLUMN_USER_RECEIVER = "USER_RECEIVER";
	public static final String COLUMN_QUIZ_TIME = "QUIZ_TIME";
	public static final String COLUMN_QUESTION_ID = "QUESTION_ID";
	public static final String COLUMN_QUESTION_TYPE_ID = "QUESTION_TYPE_ID";
	public static final String COLUMN_QUESTION_TYPE_NAME = "QUESTION_TYPE_NAME";
    public static final String COLUMN_QUESTION_EXPLANATION = "QUESTION_EXPLANATION";
	public static final String COLUMN_DIFFICULTY_ID = "DIFFICULTY_ID";
	public static final String COLUMN_OPTION_TEXT = "OPTION_TEXT";
	public static final String COLUMN_IS_CORRECT = "IS_CORRECT";
	public static final String COLUMN_DIFFICULTY_NAME = "DIFFICULTY_NAME";
	public static final String COLUMN_QTEXT = "QTEXT";
	public static final String COLUMN_NOTIFICATION_ID = "NOTIFICATION_ID";
	public static final String COLUMN_SENDER_ID = "SENDER_ID";
	public static final String COLUMN_RECEIVER_ID = "RECEIVER_ID";
	public static final String COLUMN_NOTIFICATION_TITLE = "NOTIFICATION_TITLE";
	public static final String COLUMN_NOTIFICATION_CONTENTS = "NOTIFICATION_CONTENTS";
	public static final String COLUMN_NOTIFICATION_TIME = "NOTIFICATION_TIME";
	public static final String COLUMN_MIME_ID = "MIME_ID";
	public static final String COLUMN_MIME_NAME = "MIME_NAME";
	public static final String COLUMN_MESSAGE_STATUS_NAME = "MESSAGE_STATUS_NAME";
	public static final String COLUMN_MESSAGE_ID = "MESSAGE_ID";
	public static final String COLUMN_MESSAGE_TITLE = "MESSAGE_TITLE";
	public static final String COLUMN_MESSAGE_CONTENTS = "MESSAGE_CONTENTS";
	public static final String COLUMN_MESSAGE_TIME = "MESSAGE_TIME";
	public static final String COLUMN_FILE_NAME = "FILE_NAME";
	public static final String COLUMN_FILESIZE = "FILESIZE";
	public static final String COLUMN_BLOB_CONTENTS = "BLOB_CONTENTS";
	public static final String COLUMN_EMAIL = "EMAIL";
	public static final String COLUMN_USERNAME = "USERNAME";
	public static final String COLUMN_PASSWORD_HASH = "PASSWORD_HASH";
	public static final String COLUMN_SALT = "SALT";
	public static final String COLUMN_CERTIFICATION_NAME = "CERTIFICATION_NAME";
	public static final String COLUMN_REPORT_ID = "REPORT_ID";
	public static final String COLUMN_REPORTED_ID = "REPORTED_ID";
	public static final String COLUMN_REPORTER_ID = "REPORTER_ID";
	public static final String COLUMN_MULTIPLIER = "MULTIPLIER";
	public static final String COLUMN_BASE_VALUE = "BASE_VALUE";
	public static final String COLUMN_DESCRIPTION = "DESCRIPTION";
	public static final String COLUMN_ATTEMPT_ID = "ATTEMPT_ID";
    public static final String COLUMN_ATTEMPT_SCORE = "ATTEMPT_SCORE";
	public static final String COLUMN_CHALLENGE_ID = "CHALLENGE_ID";
    public static final String COLUMN_CHALLENGE_USERS = "CHALLENGE_USERS";
	public static final String COLUMN_RESULT_ID = "RESULT_ID";
	public static final String TABLE_NOTIFICATION_RECEIVER = "NOTIFICATION_RECEIVER";
	public static final String TABLE_MESSAGE_RECEIVER = "MESSAGE_RECEIVER";
	public static final String TABLE_CERTIFICATION_BLOB = "CERTIFICATION_BLOB";

	// Overridden Primary keys (for join tables using @mappedBy)

	public static final String PK_USER = "pk.user";
	public static final String PK_CERTIFICATION = "pk.certification";
	public static final String PK_QUESTION = "pk.question";
	public static final String PK_QUIZ = "pk.quiz";
	public static final String PK_MESSAGE = "pk.message";
	public static final String PK_BLOB = "pk.blob";
	public static final String PK_TOPIC = "pk.topic";
	public static final String PK_RANK = "pk.rank";
	
	public static final String FK_TOPIC = "topic";

	// get current working directory
	public static final String PROJECT_DIR = System.getProperty("user.dir");

	public static final String FK_QUIZ = "quiz";
	public static final String USER = "user";
}
