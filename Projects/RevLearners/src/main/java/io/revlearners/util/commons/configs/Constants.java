package io.revlearners.util.commons.configs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Constants {
	public static final String FROM = " from ";

	// These should match both the @Qualifier strings and the PersistenceConfig
	// method names
	public static final String QUALIFY_USER_DAO = "userHibernateDao";
	public static final String QUALIFY_RANK_DAO = "rankHibernateDao";
	public static final String QUALIFY_MESSAGE_DAO = "messageHibernateDao";
	public static final String QUALIFY_QUESTION_DAO = "questionHibernateDao";
	public static final String QUALIFY_TOPIC_DAO = "topicHibernateDao";

	public static final String QUALIFY_TOPIC_DAO_INJECTOR = "topicHibernateService";
	public static final String QUALIFY_MESSAGE_DAO_INJECTOR = "messageHibernateService";
	public static final String QUALIFY_QUESTION_DAO_INJECTOR = "questionHibernateService";
	public static final String QUALIFY_RANK_DAO_INJECTOR = "rankHibernateService";
	public static final String QUALIFY_USER_DAO_INJECTOR = "userHibernateService";

	// map constants
	private static final Map<Integer, String> questionTypes = new LinkedHashMap<Integer, String>();
	private static final Map<Integer, String> questionDifficulties = new LinkedHashMap<Integer, String>();
	private static final Map<Integer, String> userRoles = new LinkedHashMap<Integer, String>();
	private static final Map<Integer, String> userStatuses = new LinkedHashMap<Integer, String>();
	private static final Map<Integer, String> reasonTypes = new LinkedHashMap<Integer, String>();
	private static final Map<Integer, String> topics = new LinkedHashMap<Integer, String>();
	private static final Map<Integer, String> certifications = new LinkedHashMap<Integer, String>();
	private static final Map<Integer, String> javaRanks = new LinkedHashMap<Integer, String>();
	private static final Map<Integer, String> angular4Ranks = new LinkedHashMap<Integer, String>();
	private static final Map<Integer, String> hibernateRanks = new LinkedHashMap<Integer, String>();
	private static final Map<Integer, String> devOpsRanks = new LinkedHashMap<Integer, String>();
	private static final Map<Integer, String> questionReasons = new LinkedHashMap<Integer, String>();
	private static final Map<Integer, String> userReasons = new LinkedHashMap<Integer, String>();
	private static final Map<Integer, String> designPatterns = new LinkedHashMap<Integer, String>();
	private static final Map<Integer, String> mimeTypes = new LinkedHashMap<Integer, String>();
	private static final Map<Integer, String> messageStatuses = new LinkedHashMap<Integer, String>();

	// map key/values
	public static final Integer QUESTION_TRUE_FALSE = 1;
	public static final String QUESTION_TRUE_FALSE_STR = "True of False";
	public static final Integer QUESTION_MULTI_CHOICE = 2;
	public static final String QUESTION_MULTI_CHOICE_STR = "Multiple Choice";
	public static final Integer QUESTION_CODE = 3;
	public static final String QUESTION_CODE_STR = "Coding Challenge";

	public static final Integer DIFFICULTY_EASY = 1;
	public static final String DIFFICULTY_EASY_STR = "Easy";
	public static final Integer DIFFICULTY_MEDIUM = 2;
	public static final String DIFFICULTY_MEDIUM_STR = "Medium";
	public static final Integer DIFFICULTY_HARD = 3;
	public static final String DIFFICULTY_HARD_STR = "Hard";
	public static final Integer DIFFICULTY_VERY_HARD = 4;
	public static final String DIFFICULTY_VERY_HARD_STR = "Very Hard";

	public static final Integer ROLE_BASIC = 1;
	public static final String ROLE_BASIC_STR = "Basic Account";
	public static final Integer ROLE_ADVANCED = 2;
	public static final String ROLE_ADVANCED_STR = "Advanced Account";
	public static final Integer ROLE_CERTIFIED = 3;
	public static final String ROLE_CERTIFIED_STR = "Advanced Account(Certified)";
	public static final Integer ROLE_ADMIN = 4;
	public static final String ROLE_ADMIN_STR = "Administrator Account";

	public static final Integer STATUS_OK = 1;
	public static final String STATUS_OK_STR = "Ok";
	public static final Integer STATUS_LOCKED = 2;
	public static final String STATUS_LOCKED_STR = "Locked";
	public static final Integer STATUS_PENDING = 3;
	public static final String STATUS_PENDING_STR = "Pending";
	public static final Integer STATUS_BANNED = 4;
	public static final String STATUS_BANNED_STR = "Banned";

	public static final Integer REASON_TYPE_QUESTION = 1;
	public static final String REASON_TYPE_QUESTION_STR = "Question";
	public static final Integer REASON_TYPE_USER = 2;
	public static final String REASON_TYPE_USER_STR = "User";

	public static final Integer TOPIC_CORE_JAVA = 1;
	public static final String TOPIC_CORE_JAVA_STR = "Core Java";
	public static final Integer TOPIC_J2EE = 2;
	public static final String TOPIC_J2EE_STR = "Java Enterprise Edition(J2EE)";
	public static final Integer TOPIC_SELENIUM = 3;
	public static final String TOPIC_SELENIUM_STR = "Selenium for Java";
	public static final Integer TOPIC_CUCUMBER = 4;
	public static final String TOPIC_CUCUMBER_STR = "Cucumber for Java";
	public static final Integer TOPIC_HIBERNATE = 5;
	public static final String TOPIC_HIBERNATE_STR = "Hibernate Framework for Java";
	public static final Integer TOPIC_JPA = 6;
	public static final String TOPIC_JPA_STR = "Java Persistence API(JPA)";
	public static final Integer TOPIC_SPRING = 7;
	public static final String TOPIC_SPRING_STR = "Spring Framework for Java";
	public static final Integer TOPIC_PLSQL = 8;
	public static final String TOPIC_PLSQL_STR = "PLSQL";
	public static final Integer TOPIC_TSQL = 9;
	public static final String TOPIC_TSQL_STR = "Transact SQL";
	public static final Integer TOPIC_MYSQL = 10;
	public static final String TOPIC_MYSQL_STR = "mySQL";
	public static final Integer TOPIC_POSTGRESQL = 11;
	public static final String TOPIC_POSTGRESQL_STR = "PostgreSQL";
	public static final Integer TOPIC_WEB_DEV = 12;
	public static final String TOPIC_WEB_DEV_STR = "Basic Web Development(HTML/CSS/JS/PHP)";
	public static final Integer TOPIC_JQUERY = 13;
	public static final String TOPIC_JQUERY_STR = "JQUERY";
	public static final Integer TOPIC_ANGULARJS = 14;
	public static final String TOPIC_ANGULARJS_STR = "AngularJS";
	public static final Integer TOPIC_ANGULAR4 = 13;
	public static final String TOPIC_ANGULAR4_STR = "Angular4";
	public static final Integer TOPIC_DEVOPS = 14;
	public static final String TOPIC_DEVOPS_STR = "DevOps (includes Jenkins and AWS)";
	public static final Integer TOPIC_MICROSERVICES = 15;
	public static final String TOPIC_MICROSERVICES_STR = "Microservices";
	public static final Integer TOPIC_DESIGN_PATTERNS = 16;
	public static final String TOPIC_DESIGN_PATTERNS_STR = "Design Patterns";

	public static final Integer ORACLE_CERTIFIED_ASSOCIATE = 1;
	public static final String ORACLE_CERTIFIED_ASSOCIATE_STR = "Oracle Certified Associate (OCA)";
	public static final Integer ORACLE_CERTIFIED_PROFESSIONAL = 2;
	public static final String ORACLE_CERTIFIED_PROFESSIONAL_STR = "Oracle Certified Professional (OCA)";
	public static final Integer ORACLE_CERTIFIED_MASTER = 3;
	public static final String ORACLE_CERTIFIED_MASTER_STR = "Oracle Certified Master (OCM)";

	public static final Integer JRANKS_BEGINNER = 1;
	public static final String JRANKS_BEGINNER_STR = "Beginner";
	public static final Integer JRANKS_BEGINNER_QTY = 1;
	public static final Integer JRANKS_INTERMEDIATE = 2;
	public static final String JRANKS_INTERMEDIATE_STR = "Intermediate";
	public static final Integer JRANKS_INTERMEDIATE_QTY = 2;
	public static final Integer JRANKS_EXPERT = 3;
	public static final String JRANKS_EXPERT_STR = "Expert";
	public static final Integer JRANKS_EXPERT_QTY = 3;
	public static final Integer JRANKS_JGURU = 4;
	public static final String JRANKS_JGURU_STR = "JGuru";
	public static final Integer JRANKS_JGURU_QTY = 4;

	public static final Integer ANG4RANKS_BEGINNER = 5;
	public static final String ANG4RANKS_BEGINNER_STR = "Beginner";
	public static final Integer ANG4RANKS_BEGINNER_QTY = 1;
	public static final Integer ANG4RANKS_INTERMEDIATE = 6;
	public static final String ANG4RANKS_INTERMEDIATE_STR = "Intermediate";
	public static final Integer ANG4RANKS_INTERMEDIATE_QTY = 2;
	public static final Integer ANG4RANKS_EXPERT = 7;
	public static final String ANG4RANKS_EXPERT_STR = "Expert";
	public static final Integer ANG4RANKS_EXPER_QTY = 3;
	public static final Integer ANG4RANKS_NGACE = 8;
	public static final String ANG4RANKS_NGACE_STR = "NgAce";
	public static final Integer ANG4RANKS_NGACE_QTY = 4;

	public static final Integer DVOPSRANKS_BEGINNER = 9;
	public static final String DVOPSRANKS_BEGINNER_STR = "Beginner";
	public static final Integer DVOPSRANKS_BEGINNER_QTY = 1;
	public static final Integer DVOPSRANKS_INTERMEDIATE = 10;
	public static final String DVOPSRANKS_INTERMEDIATE_STR = "Intermediate";
	public static final Integer DVOPSRANKS_INTERMEDIATE_QTY = 2;
	public static final Integer DVOPSRANKS_EXPERT = 11;
	public static final String DVOPSRANKS_EXPERT_STR = "Expert";
	public static final Integer DVOPSRANKS_EXPERT_QTY = 3;
	public static final Integer DVOPSRANKS_SCRUM_LORD = 12;
	public static final String DVOPSRANKS_SCRUM_LORD_STR = "Scrum Lord";
	public static final Integer DVOPSRANKS_SCRUM_LORD_QTY = 4;

	public static final Integer HBMRANKS_BEGINNER = 13;
	public static final String HBMRANKS_BEGINNER_STR = "Beginner";
	public static final Integer HBMRANKS_BEGINNER_QTY = 1;
	public static final Integer HBMRANKS_INTERMEDIATE = 14;
	public static final String HBMRANKS_INTERMEDIATE_STR = "Intermediate";
	public static final Integer HBMRANKS_INTERMEDIATE_QTY = 2;
	public static final Integer HBMRANKS_EXPERT = 15;
	public static final String HBMRANKS_EXPERT_STR = "Expert";
	public static final Integer HBMRANKS_EXPERT_QTY = 3;
	public static final Integer HBMRANKS_HBMASTER = 16;
	public static final String HBMRANKS_HBMASTER_STR = "HBMaster";
	public static final Integer HBMRANKS_HBMASTER_QTY = 4;

	public static final Integer DPRANKS_BEGINNER = 17;
	public static final String DPRANKS_BEGINNER_STR = "Beginner";
	public static final Integer DPRANKS_BEGINNER_QTY = 1;
	public static final Integer DPRANKS_INTERMEDIATE = 18;
	public static final String DPRANKS_INTERMEDIATE_STR = "Intermediate";
	public static final Integer DPRANKS_INTERMEDIATE_QTY = 2;
	public static final Integer DPRANKS_EXPERT = 19;
	public static final String DPRANKS_EXPERT_STR = "Expert";
	public static final Integer DPRANKS_EXPERT_QTY = 3;
	public static final Integer DPRANKS_HBMASTER = 20;
	public static final String DPRANKS_GOF_KING_STR = "GoF King";
	public static final Integer DPRANKS_HBMASTER_QTY = 4;

	public static final Integer QREASON_WRONG = 1;
	public static final String QREASON_WRONG_STR = "The question is wrong";
	public static final Integer QREASON_OFF_TOPIC = 2;
	public static final String QREASON_OFF_TOPIC_STR = "The question is off-topic";
	public static final Integer QREASON_NOT_A_QUESTION = 3;
	public static final String QREASON_NOT_A_QUESTION_STR = "The question is not really a question";
	public static final Integer QREASON_TOO_VAGUE = 4;
	public static final String QREASON_TOO_VAGUE_STR = "The question is too vague";
	public static final Integer QREASON_CONFUSING = 5;
	public static final String QREASON_CONFUSING_STR = "The question is too confusing";
	public static final Integer QREASON_WRONG_DIFFICULTY = 6;
	public static final String QREASON_WRONG_DIFFICULTY_STR = "The question should be a different difficulty";
	public static final Integer QREASON_OTHER = 7;
	public static final String QREASON_OTHER_STR = "Please specify:";

	public static final Integer USER_REASON_ABUSIVE = 1;
	public static final String USER_REASON_ABUSIVE_STR = "The user exercised abusive behavior";
	public static final Integer USER_REASON_FAKE_ACCOUNT = 2;
	public static final String USER_REASON_FAKE_ACCOUNT_STR = "I suspect this user is a fake account";
	public static final Integer USER_REASON_STOLEN_INTELLECTUAL_PROPERTY = 3;
	public static final String USER_REASON_STOLEN_INTELLECTUAL_PROPERTY_STR = "This account is using my intellectual property or identity";
	public static final Integer USER_REASON_SPAMMER = 4;
	public static final String USER_REASON_SPAMMER_STR = "This user is spamming";
	public static final Integer USER_REASON_OTHER = 5;
	public static final String USER_REASON_OTHER_STR = "Please specify:";

	public static final Integer MIME_PDF = 1;
	public static final String MIME_PDF_STR = "application/pdf";
	public static final Integer MIME_JPG = 2;
	public static final String MIME_JPG_STR = "image/jpeg";
	public static final Integer MIME_PNG = 3;
	public static final String MIME_PNG_STR = "image/png";
	
	//Message statuses
	
//	Email and SMS have different functions. Below is a layout for how 
//	SMS differs from Email programatically (Email is the in-app inbox)
	
//	SMS will show read to sender and nothing to receiver, 
//	Email will show read to receiver and received to sender
	public static final Integer MESSAGE_STATUS_READ = 1;
	public static final String MESSAGE_STATUS_READ_STR = "Read";

//	Email will show unread to receiver and received to sender
//	SMS will say unread (have some styling for unread) for receiver and
//	sender will say delivered.
	public static final Integer MESSAGE_STATUS_UNREAD = 2;
	public static final String MESSAGE_STATUS_UNREAD_STR = "Unread";
	
//	SMS will show read to sender and message will disappear from receiver view, 
//	Email will disappear from receiver's view and will show received to user
	public static final Integer MESSAGE_STATUS_DELETED = 3;
	public static final String MESSAGE_STATUS_DELETED_STR = "Deleted";
	
//  For both SMS and Email this status is shown if the message is sent
//	to a mail server but not delivered to the receiver
	public static final Integer MESSAGE_STATUS_SENT = 4;
	public static final String MESSAGE_STATUS_SENT_STR = "Sent";
	
//	SMS will show this when the message delivers to the receiver
	public static final Integer MESSAGE_STATUS_DELIVERED = 5;
	public static final String MESSAGE_STATUS_DELIVERED_STR = "Delivered";
	
//	Email will show this when the message delivers to the receiver
	public static final Integer MESSAGE_STATUS_RECEIVED = 6;
	public static final String MESSAGE_STATUS_RECEIVED_STR = "Received";

	// point values
	public static final double EASY_MULT = 1;
	public static final double MEDIUM_MULT = 4;
	public static final double HARD_MULT = 10;
	public static final double VERY_HARD_MULT = 40;

	public static final int BASE_TF = 10;
	public static final int BASE_MULT = 15;
	public static final int BASE_CODE = 100;

	public static final int ADV_USER_PTS = 1000;

	public static Map<Integer, String> getJRanks() {
		return new HashMap<>(javaRanks);
	}

	public static Map<Integer, String> getAngular4Ranks() {
		return new HashMap<>(angular4Ranks);
	}

	public static Map<Integer, String> getQuestiontypes() {
		return new HashMap<>(questionTypes);
	}

	public static Map<Integer, String> getUserRoles() {
		return new HashMap<>(userRoles);
	}

	public static Map<Integer, String> getUserStatuses() {
		return new HashMap<>(userStatuses);
	}

	public static Map<Integer, String> getReasonTypes() {
		return new HashMap<>(reasonTypes);
	}

	public static Map<Integer, String> getTopics() {
		return new HashMap<>(topics);
	}

	public static Map<Integer, String> getCertifications() {
		return new HashMap<>(certifications);
	}

	public static Map<Integer, String> getDevOpsRanks() {
		return new HashMap<>(devOpsRanks);
	}

	public static Map<Integer, String> getHibernateRanks() {
		return new HashMap<>(hibernateRanks);
	}

	public static Map<Integer, String> getQuestionReasons() {
		return new HashMap<>(questionReasons);
	}

	public static Map<Integer, String> getDesignPatterns() {
		return new HashMap<>(designPatterns);
	}

	public static Map<Integer, String> getUserReasons() {
		return new HashMap<>(userReasons);
	}

	public static Map<Integer, String> getQuestionDifficulties() {
		return new HashMap<>(questionDifficulties);
	}

	public static Map<Integer, String> getMimeTypes() {
		return new HashMap<>(mimeTypes);
	}
	
	public static Map<Integer, String> getMessageStatuses() {
		return new HashMap<>(messageStatuses);
	}

	static {
		javaRanks.put(JRANKS_BEGINNER, JRANKS_BEGINNER_STR);
		javaRanks.put(JRANKS_INTERMEDIATE, JRANKS_INTERMEDIATE_STR);
		javaRanks.put(JRANKS_EXPERT, JRANKS_EXPERT_STR);
		javaRanks.put(JRANKS_JGURU, JRANKS_JGURU_STR);

		angular4Ranks.put(ANG4RANKS_BEGINNER, ANG4RANKS_BEGINNER_STR);
		angular4Ranks.put(ANG4RANKS_INTERMEDIATE, ANG4RANKS_INTERMEDIATE_STR);
		angular4Ranks.put(ANG4RANKS_EXPERT, ANG4RANKS_EXPERT_STR);
		angular4Ranks.put(ANG4RANKS_NGACE, ANG4RANKS_NGACE_STR);

		devOpsRanks.put(DVOPSRANKS_BEGINNER, DVOPSRANKS_BEGINNER_STR);
		devOpsRanks.put(DVOPSRANKS_INTERMEDIATE, DVOPSRANKS_INTERMEDIATE_STR);
		devOpsRanks.put(DVOPSRANKS_EXPERT, DVOPSRANKS_EXPERT_STR);
		devOpsRanks.put(DVOPSRANKS_SCRUM_LORD, DVOPSRANKS_SCRUM_LORD_STR);

		hibernateRanks.put(HBMRANKS_BEGINNER, HBMRANKS_BEGINNER_STR);
		hibernateRanks.put(HBMRANKS_INTERMEDIATE, HBMRANKS_INTERMEDIATE_STR);
		hibernateRanks.put(HBMRANKS_EXPERT, HBMRANKS_EXPERT_STR);
		hibernateRanks.put(HBMRANKS_HBMASTER, HBMRANKS_HBMASTER_STR);

		certifications.put(ORACLE_CERTIFIED_ASSOCIATE, ORACLE_CERTIFIED_ASSOCIATE_STR);
		certifications.put(ORACLE_CERTIFIED_PROFESSIONAL, ORACLE_CERTIFIED_PROFESSIONAL_STR);
		certifications.put(ORACLE_CERTIFIED_MASTER, ORACLE_CERTIFIED_MASTER_STR);

		questionTypes.put(QUESTION_TRUE_FALSE, QUESTION_TRUE_FALSE_STR);
		questionTypes.put(QUESTION_MULTI_CHOICE, QUESTION_MULTI_CHOICE_STR);
		questionTypes.put(QUESTION_CODE, QUESTION_CODE_STR);

		questionDifficulties.put(DIFFICULTY_EASY, DIFFICULTY_EASY_STR);
		questionDifficulties.put(DIFFICULTY_MEDIUM, DIFFICULTY_MEDIUM_STR);
		questionDifficulties.put(DIFFICULTY_HARD, DIFFICULTY_HARD_STR);
		questionDifficulties.put(DIFFICULTY_VERY_HARD, DIFFICULTY_VERY_HARD_STR);

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

		topics.put(TOPIC_CORE_JAVA, TOPIC_CORE_JAVA_STR);
		topics.put(TOPIC_J2EE, TOPIC_J2EE_STR);
		topics.put(TOPIC_SELENIUM, TOPIC_SELENIUM_STR);
		topics.put(TOPIC_CUCUMBER, TOPIC_CUCUMBER_STR);
		topics.put(TOPIC_HIBERNATE, TOPIC_HIBERNATE_STR);
		topics.put(TOPIC_JPA, TOPIC_JPA_STR);
		topics.put(TOPIC_SPRING, TOPIC_SPRING_STR);
		topics.put(TOPIC_PLSQL, TOPIC_PLSQL_STR);
		topics.put(TOPIC_TSQL, TOPIC_TSQL_STR);
		topics.put(TOPIC_MYSQL, TOPIC_MYSQL_STR);
		topics.put(TOPIC_POSTGRESQL, TOPIC_POSTGRESQL_STR);
		topics.put(TOPIC_WEB_DEV, TOPIC_WEB_DEV_STR);
		topics.put(TOPIC_JQUERY, TOPIC_JQUERY_STR);
		topics.put(TOPIC_ANGULARJS, TOPIC_ANGULARJS_STR);
		topics.put(TOPIC_ANGULAR4, TOPIC_ANGULAR4_STR);
		topics.put(TOPIC_DEVOPS, TOPIC_DEVOPS_STR);
		topics.put(TOPIC_MICROSERVICES, TOPIC_MICROSERVICES_STR);
		topics.put(TOPIC_DESIGN_PATTERNS, TOPIC_DESIGN_PATTERNS_STR);

		designPatterns.put(DPRANKS_BEGINNER, DPRANKS_BEGINNER_STR);
		designPatterns.put(DPRANKS_INTERMEDIATE, DPRANKS_INTERMEDIATE_STR);
		designPatterns.put(DPRANKS_EXPERT, DPRANKS_EXPERT_STR);
		designPatterns.put(DPRANKS_HBMASTER, DPRANKS_GOF_KING_STR);

		questionReasons.put(QREASON_WRONG, QREASON_WRONG_STR);
		questionReasons.put(QREASON_OFF_TOPIC, QREASON_OFF_TOPIC_STR);
		questionReasons.put(QREASON_NOT_A_QUESTION, QREASON_NOT_A_QUESTION_STR);
		questionReasons.put(QREASON_TOO_VAGUE, QREASON_TOO_VAGUE_STR);
		questionReasons.put(QREASON_CONFUSING, QREASON_CONFUSING_STR);
		questionReasons.put(QREASON_WRONG_DIFFICULTY, QREASON_WRONG_DIFFICULTY_STR);
		questionReasons.put(QREASON_OTHER, QREASON_OTHER_STR);

		userReasons.put(USER_REASON_ABUSIVE, USER_REASON_ABUSIVE_STR);
		userReasons.put(USER_REASON_FAKE_ACCOUNT, USER_REASON_FAKE_ACCOUNT_STR);
		userReasons.put(USER_REASON_STOLEN_INTELLECTUAL_PROPERTY, USER_REASON_STOLEN_INTELLECTUAL_PROPERTY_STR);
		userReasons.put(USER_REASON_SPAMMER, USER_REASON_SPAMMER_STR);
		userReasons.put(USER_REASON_OTHER, USER_REASON_OTHER_STR);

		mimeTypes.put(MIME_PDF, MIME_PDF_STR);
		mimeTypes.put(MIME_JPG, MIME_JPG_STR);
		mimeTypes.put(MIME_PNG, MIME_PNG_STR);
		
		messageStatuses.put(MESSAGE_STATUS_READ, MESSAGE_STATUS_READ_STR);
		messageStatuses.put(MESSAGE_STATUS_UNREAD, MESSAGE_STATUS_UNREAD_STR);
		messageStatuses.put(MESSAGE_STATUS_DELETED, MESSAGE_STATUS_DELETED_STR);
		messageStatuses.put(MESSAGE_STATUS_SENT, MESSAGE_STATUS_SENT_STR);
		messageStatuses.put(MESSAGE_STATUS_DELIVERED, MESSAGE_STATUS_DELIVERED_STR);
		messageStatuses.put(MESSAGE_STATUS_RECEIVED, MESSAGE_STATUS_RECEIVED_STR);

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
	public static final String TABLE_QUESTION_POINTS = "QUESTION_POINTS";
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
	public static final String TABLE_USER_RANK = "USER_RANK";
	public static final String TABLE_QUIZ_QUESTION = "QUIZ_QUESTION";

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
	public static final String COLUMN_USER2_ID = "USER2_ID";
	public static final String COLUMN_TOPIC_ID = "TOPIC_ID";
	public static final String COLUMN_TOPIC_NAME = "TOPIC_NAME";
	public static final String COLUMN_TYPE_ID = "TYPE_ID";
	public static final String COLUMN_REASON_TYPE = "REASON_TYPE";
	public static final String COLUMN_REASON_ID = "REASON_ID";
	public static final String COLUMN_REASON = "REASON";
	public static final String COLUMN_RANK_NAME = "RANK_NAME";
	public static final String COLUMN_MERIT_THRESHOLD = "MERIT_THRESHOLD";
	public static final String COLUMN_QUIZ_ID = "QUIZ_ID";
	public static final String COLUMN_USER_SENDER = "USER_SENDER";
	public static final String COLUMN_USER_RECEIVER = "USER_RECEIVER";
	public static final String COLUMN_QUIZ_TIME = "QUIZ_TIME";
	public static final String COLUMN_QUESTION_ID = "QUESTION_ID";
	public static final String COLUMN_QUESTION_TYPE_ID = "QUESTION_TYPE_ID";
	public static final String COLUMN_QUESTION_TYPE_NAME = "QUESTION_TYPE_NAME";
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
	public static final String COLUMN_PASSWORD = "PASSWORD";
	public static final String COLUMN_SALT = "SALT";
	public static final String COLUMN_CERTIFICATION_NAME = "CERTIFICATION_NAME";
	public static final String COLUMN_REPORT_ID = "REPORT_ID";
	public static final String COLUMN_REPORTED_ID = "REPORTED_ID";
	public static final String COLUMN_REPORTER_ID = "REPORTER_ID";
	public static final String COLUMN_MULTIPLIER = "MULTIPLIER";
	public static final String COLUMN_BASE_VALUE = "BASE_VALUE";
	public static final String COLUMN_DESCRIPTION = "DESCRIPTION";
	
	public static final String TRANSACTION_HIBERNATE_MANAGER = "hibernateTransactionManager";

}
