package io.revlearners.util.commons.configs;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public final class Constants {
    public static final String FROM = " from ";

    // These should match both the @Qualifier strings and the PersistenceConfig method names
    public static final String TRANSACTION_HIBERNATE_MANAGER = "hibernateTransactionManager";

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
    private static final Map<Integer, String> questionTypes = new HashMap<Integer, String>();
    private static final Map<Integer, String> userRoles = new HashMap<Integer, String>();
    private static final Map<Integer, String> userStatuses = new HashMap<Integer, String>();
    private static final Map<Integer, String> reasonTypes = new HashMap<Integer, String>();
    private static final Map<Integer, String> topics = new HashMap<Integer, String>();
    private static final Map<Integer, String> certifications = new HashMap<Integer, String>();
    private static final Map<Integer, String> javaRanks = new HashMap<Integer, String>();
    private static final Map<Integer, String> angular4Ranks = new HashMap<Integer, String>();
    private static final Map<Integer, String> hibernateRanks = new HashMap<Integer, String>();
    private static final Map<Integer, String> devOpsRanks = new HashMap<Integer, String>();

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

    // point values
    public static final double EASY_MULT = 1;
    public static final double MEDIUM_MULT = 4;
    public static final double HARD_MULT = 10;
    public static final double VERY_HARD_MULT = 40;

    public static final int BASE_TF = 10;
    public static final int BASE_MULT = 15;
    public static final int BASE_CODE = 100;

    public static final int ADV_USER_PTS = 1000;

    public Map<Integer, String> getJRanks() {
        return new HashMap<>(javaRanks);
    }

    public Map<Integer, String> getAngular4Ranks() {
        return new HashMap<>(angular4Ranks);
    }

    public Map<Integer, String> getDevOpsRanks() {
        return new HashMap<>(devOpsRanks);
    }

    public Map<Integer, String> getHibernateRanks() {
        return new HashMap<>(hibernateRanks);
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

        // todo: map will be replaced with actual maps
        Map<Integer, String> map = new HashMap<>();

        map.put(DIFFICULTY_EASY, DIFFICULTY_EASY_STR);
        map.put(DIFFICULTY_MEDIUM, DIFFICULTY_MEDIUM_STR);

        map.put(DIFFICULTY_HARD, DIFFICULTY_HARD_STR);
        map.put(DIFFICULTY_VERY_HARD, DIFFICULTY_VERY_HARD_STR);

        map.put(ROLE_BASIC, ROLE_BASIC_STR);
        map.put(ROLE_ADVANCED, ROLE_ADVANCED_STR);
        map.put(ROLE_CERTIFIED, ROLE_CERTIFIED_STR);
        map.put(ROLE_ADMIN, ROLE_ADMIN_STR);

        map.put(STATUS_OK, STATUS_OK_STR);
        map.put(STATUS_LOCKED, STATUS_LOCKED_STR);
        map.put(STATUS_PENDING, STATUS_PENDING_STR);
        map.put(STATUS_BANNED, STATUS_BANNED_STR);

        map.put(REASON_TYPE_QUESTION, REASON_TYPE_QUESTION_STR);
        map.put(REASON_TYPE_USER, REASON_TYPE_USER_STR);

        map.put(TOPIC_CORE_JAVA, TOPIC_CORE_JAVA_STR);
        map.put(TOPIC_J2EE, TOPIC_J2EE_STR);
        map.put(TOPIC_SELENIUM, TOPIC_SELENIUM_STR);
        map.put(TOPIC_CUCUMBER, TOPIC_CUCUMBER_STR);
        map.put(TOPIC_HIBERNATE, TOPIC_HIBERNATE_STR);
        map.put(TOPIC_JPA, TOPIC_JPA_STR);
        map.put(TOPIC_SPRING, TOPIC_SPRING_STR);
        map.put(TOPIC_PLSQL, TOPIC_PLSQL_STR);
        map.put(TOPIC_TSQL, TOPIC_TSQL_STR);
        map.put(TOPIC_MYSQL, TOPIC_MYSQL_STR);
        map.put(TOPIC_POSTGRESQL, TOPIC_POSTGRESQL_STR);
        map.put(TOPIC_WEB_DEV, TOPIC_WEB_DEV_STR);
        map.put(TOPIC_JQUERY, TOPIC_JQUERY_STR);
        map.put(TOPIC_ANGULARJS, TOPIC_ANGULARJS_STR);
        map.put(TOPIC_ANGULAR4, TOPIC_ANGULAR4_STR);
        map.put(TOPIC_DEVOPS, TOPIC_DEVOPS_STR);
        map.put(TOPIC_MICROSERVICES, TOPIC_MICROSERVICES_STR);
        map.put(TOPIC_DESIGN_PATTERNS, TOPIC_DESIGN_PATTERNS_STR);
    }
}
