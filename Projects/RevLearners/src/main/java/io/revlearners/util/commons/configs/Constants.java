package io.revlearners.util.commons.configs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Constants {
	private Constants() {
	}
	
	public static final String FROM = " from ";
	
	// These should match both the @Qualifier strings and the PersistenceConfig method names
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
	public static final String TOPIC_MICROSERVICES_STR= "Microservices";
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
	public static final Integer JRANKS_INTERMEDIATE = 2;
	public static final String JRANKS_INTERMEDIATE_STR = "Intermediate";
	public static final Integer JRANKS_EXPERT = 3;
	public static final String JRANKS_EXPERT_STR = "Expert";
	public static final Integer JRANKS_JGURU = 4;
	public static final String JRANKS_JGURU_STR = "JGuru";
	
	public static final Integer ANG4RANKS_BEGINNER = 1;
	public static final String ANG4RANKS_BEGINNER_STR = "Beginner";
	public static final Integer ANG4RANKS_INTERMEDIATE = 2;
	public static final String ANG4RANKS_INTERMEDIATE_STR = "Intermediate";
	public static final Integer ANG4RANKS_EXPERT = 3;
	public static final String ANG4RANKS_EXPERT_STR = "Expert";
	public static final Integer ANG4RANKS_NGACE = 4;
	public static final String ANG4RANKS_NGACE_STR = "NgAce";
	
	public static final Integer DVOPSRANKS_BEGINNER = 1;
	public static final String DVOPSRANKS_BEGINNER_STR = "Beginner";
	public static final Integer DVOPSRANKS_INTERMEDIATE = 2;
	public static final String DVOPSRANKS_INTERMEDIATE_STR = "Intermediate";
	public static final Integer DVOPSRANKS_EXPERT = 3;
	public static final String DVOPSRANKS_EXPERT_STR = "Expert";
	public static final Integer DVOPSRANKS_SCRUM_LORD = 4;
	public static final String DVOPSRANKS_SCRUM_LORD_STR = "Scrum Lord";
	
	public static final Integer HBMRANKS_BEGINNER = 1;
	public static final String HBMRANKS_BEGINNER_STR = "Beginner";
	public static final Integer HBMRANKS_INTERMEDIATE = 2;
	public static final String HBMRANKS_INTERMEDIATE_STR = "Intermediate";
	public static final Integer HBMRANKS_EXPERT = 3;
	public static final String HBMRANKS_EXPERT_STR = "Expert";
	public static final Integer HBMRANKS_HBMASTER = 4;
	public static final String HBMRANKS_HBMASTER_STR = "HBMaster";
	
	public static final Integer DPRANKS_BEGINNER = 1;
	public static final String DPRANKS_BEGINNER_STR = "Beginner";
	public static final Integer DPRANKS_INTERMEDIATE = 2;
	public static final String DPRANKS_INTERMEDIATE_STR = "Intermediate";
	public static final Integer DPRANKS_EXPERT = 3;
	public static final String DPRANKS_EXPERT_STR = "Expert";
	public static final Integer DPRANKS_HBMASTER = 4;
	public static final String DPRANKS_GOF_KING_STR = "GoF King";
	
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
	
    public static final Integer MIME_PDF= 1;
    public static final String MIME_PDF_STR = ".pdf";
    public static final Integer MIME_JPG= 2;
    public static final String MIME_JPG_STR = ".jpg";
    
	// point values
	public static final double EASY_MULT = 1;
	public static final double MEDIUM_MULT = 4;
	public static final double HARD_MULT = 10;
	public static final double VERY_HARD_MULT = 40;
	
	public static final int BASE_TF = 10;
	public static final int BASE_MULT = 15;
	public static final int BASE_CODE = 100;
	
	public static final int ADV_USER_PTS = 1000;
	
	public Map<Integer, String> getJRanks(){
		return javaRanks;
	}
	
	public Map<Integer, String> getAngular4Ranks(){
		return angular4Ranks;
	}
	
	public static Map<Integer, String> getQuestiontypes() {
		return questionTypes;
	}

	public static Map<Integer, String> getUserroles() {
		return userRoles;
	}

	public static Map<Integer, String> getUserstatuses() {
		return userStatuses;
	}

	public static Map<Integer, String> getReasontypes() {
		return reasonTypes;
	}

	public static Map<Integer, String> getTopics() {
		return topics;
	}

	public static Map<Integer, String> getCertifications() {
		return certifications;
	}

	public Map<Integer, String> getDevOpsRanks(){
		return devOpsRanks;
	}
	
	public Map<Integer, String> getHibernateRanks(){
		return hibernateRanks;
	}
	
	public Map<Integer, String> getQuestionReasons(){
		return questionReasons;
	}
	
	public Map<Integer, String> getDesignPatterns(){
		return designPatterns;
	}
	
	public Map<Integer, String> getUserReasons(){
		return userReasons;
	}

	public static final String TRANSACTION_HIBERNATE_MANAGER = "hibernateTransactionManager";
}
