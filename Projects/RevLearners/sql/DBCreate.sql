--select 'DROP table', table_name, 'cascade constraints;' from user_tables;

CREATE TABLE USER_STATUS (
    US_STAT_ID NUMBER(1),
    US_STAT VARCHAR2(20) NOT NULL,
    CONSTRAINT PK_US_STAT PRIMARY KEY (US_STAT_ID)
);

CREATE TABLE USER_ROLe (
    US_ROLE_ID NUMBER(1),
    US_ROLE VARCHAR2(20) NOT NULL,
    CONSTRAINT PK_US_ROLE PRIMARY KEY (US_ROLE_ID)
);

CREATE TABLE TOPIC (
    TOPIC_ID NUMBER(2),
    TOPIC_NAME VARCHAR2(20) NOT NULL,
    CONSTRAINT PK_TOPIC PRIMARY KEY(TOPIC_ID)
);

CREATE TABLE CERTIFICATION (
    CERT_ID NUMBER(1),
    CERT_NAME VARCHAR2(20) NOT NULL,
    TOPIC_ID NUMBER(2),
    CONSTRAINT PK_CERT PRIMARY KEY (CERT_ID),
    CONSTRAINT FK_CERT_TOPIC FOREIGN KEY(TOPIC_ID)
        REFERENCES TOPIC (TOPIC_ID)
);

CREATE TABLE USERS (
    USER_ID NUMBER(6),
    USER_NAME VARCHAR(20) NOT NULL,
    US_STAT_ID NUMBER(1),
    US_ROLE_ID NUMBER(1),
    CONSTRAINT PK_USER PRIMARY KEY(USER_ID),
    CONSTRAINT FK_USER_US_STAT FOREIGN KEY (US_STAT_ID)
        REFERENCES USER_STATUS (US_STAT_ID),
    CONSTRAINT FK_USER_US_ROLE FOREIGN KEY (US_ROLE_ID)
        REFERENCES USER_ROLE (US_ROLE_ID)
);

CREATE TABLE CREDENTIALS (
    USER_ID NUMBER(6),
    EMAIL VARCHAR2(20) UNIQUE NOT NULL,
    PASSWORD_HASH VARCHAR2(64) NOT NULL,
    SALT VARCHAR(8) UNIQUE NOT NULL,
    CONSTRAINT PK_CREDS PRIMARY KEY(USER_ID),
    CONSTRAINT FK_CREDS_USER FOREIGN KEY(USER_ID)
        REFERENCES USERS(USER_ID)
);

CREATE TABLE US_CERT_JUNCTION(
    USER_ID NUMBER(6),
    CERT_ID NUMBER(6),
    CONSTRAINT FK_UCJ_USER FOREIGN KEY(USER_ID)
        REFERENCES USERS (User_ID),
    CONSTRAINT FK_UCJ_CERT FOREIGN KEY(CERT_ID)
        REFERENCES CERTIFICATION (CERT_ID)
);

CREATE TABLE FRIENDS_LIST(
    LIST_ID NUMBER(6),
    USER_ID NUMBER(6),
    FRIEND_ID NUMBER(6),
    CONSTRAINT PK_FL PRIMARY KEY(LIST_ID),
    CONSTRAINT FK_FL_USER FOREIGN KEY(USER_ID)
        REFERENCES USERS(USER_ID),
    CONSTRAINT FK_FL_FRIEND FOREIGN KEY(FRIEND_ID)
        REFERENCES USERS (USER_ID)
);

CREATE TABLE MESSAGE_STATUS (
    MSG_STAT_ID NUMBER(1),
    MSG_STATUS VARCHAR2(20) NOT NULL,
    CONSTRAINT PK_MSG_ID PRIMARY KEY(MSG_STAT_ID)
);

CREATE TABLE NOTIFICATIONS (
    NOTE_ID NUMBER(6),
    FROM_USER NUMBER(6),
    TO_USER NUMBER(6),
    TITLE VARCHAR2(20) NOT NULL,
    MSG VARCHAR2(500) NOT NULL,
    TIME_CREATED TIMESTAMP(0) NOT NULL,
    MSG_STAT_ID NUMBER(1) NOT NULL,
    CONSTRAINT PK_NOTIFS PRIMARY KEY(NOTE_ID),
    CONSTRAINT FK_NOTIFS_FROM FOREIGN KEY(FROM_USER)
        REFERENCES USERS (USER_ID),
    CONSTRAINT FK_NOTIFS_TO FOREIGN KEY(TO_USER)
        REFERENCES USERS (USER_ID),
    CONSTRAINT FK_NOTICS_MSG FOREIGN KEY(MSG_STAT_ID)
        REFERENCES MESSAGE_STATUS(MSG_STAT_ID)
);

CREATE TABLE BLOBS (
    BLOB_ID NUMBER(6),
    FNAME VARCHAR2(50) NOT NULL,
    FSIZE NUMBER(12) NOT NULL,
    MIME_TYPE VARCHAR2(10) NOT NULL,
    CONTENTZ BLOB NOT NULL,
    CONSTRAINT PK_BLOB PRIMARY KEY(BLOB_ID)
);

CREATE TABLE MESSAGES (
    MSG_ID NUMBER(6),
    TO_ID NUMBER(6),
    FROM_ID NUMbER(6),
    TITLE VARCHAR2(20) NOT NULL,
    MSG VARCHAR2(50) NOT NULL,
    BLOB_ID NUMBER(6),
    TIME_CREATE TIMESTAMP(0) NOT NULL,
    MSG_STAT_ID NUMBER(1),
    CONSTRAINT PK_MESSAGE PRIMARY KEY(MSG_ID),
    CONSTRAINT FK_MSG_TO FOREIGN KEY(TO_ID)
        REFERENCES USERS(USER_ID),
    CONSTRAINT FK_MSG_FROM FOREIGN KEY(FROM_ID)
        REFERENCES USERS(USER_ID),
    CONSTRAINT FK_MSG_BLOB FOREIGN KEY(BLOB_ID)
        REFERENCES BLOBS (BLOB_ID),
    CONSTRAINT FK_MSG_MSG_STAT FOREIGN KEY(MSG_STAT_ID)
        REFERENCES MESSAGE_STATUS(MSG_STAT_ID)
);

CREATE TABLE TOPIC_RANK (
    TOPIC_RANK_ID NUMBER(3),
    RANK_NAME VARCHAR(2),
    MERIT_THRESHOLD NUMBER(6) NOT NULL,
    CONSTRAINT PK_TOPIC_RANK PRIMARY KEY(TOPIC_RANK_ID)
);

CREATE TABLE RANKS (
    TOPIC_ID NUMBER(3),
    USER_ID NUMBER(6),
    TOPIC_RANK_ID NUMBER(3),
    MERIT NUMBER(6) NOT NULL,
    CONSTRAINT PK_RANK PRIMARY KEY(USER_ID, TOPIC_ID),
    CONSTRAINT FK_RANK_USER FOREIGN KEY(USER_ID)
        REFERENCES USERS(USER_ID),
    CONSTRAINT FK_RANK_TOPIC FOREIGN KEY(TOPIC_ID)
        REFERENCES TOPIC(TOPIC_ID),
    CONSTRAINT FK_RANK_TOPIC_RANK FOREIGN KEY(TOPIC_RANK_ID)
        REFERENCES TOPIC_RANK (TOPIC_RANK_ID)
);

CREATE TABLE Q_TYPE (
    Q_TYPE_ID NUMBER(1),
    Q_TYPE_NAME VARCHAR2(20) NOT NULL,
    CONSTRAINT PK_Q_TYPE PRIMARY KEY (Q_TYPE_ID)
);

CREATE TABLE Q_DIFF (
    Q_DIFF_ID NUMBER(1),
    Q_TYPE_NAME VARCHAR2(20) NOT NULL,
    CONSTRAINT PK__DIFF PRIMARY KEY (Q_DIFF_ID)
);

CREATE TABLE Q_POINTS (
    Q_TYPE_ID NUMBER(1),
    Q_DIFF_ID NUMBER(1),
    Q_POINTS NUMBER(3) NOT NULL,
    CONSTRAINT PK_Q_POINTS PRIMARY KEY (Q_TYPE_ID, Q_DIFF_ID),
    CONSTRAINT FK_Q_POINTS_Q_TYPE FOREIGN KEY (Q_TYPE_ID)
        REFERENCES Q_TYPE(Q_TYPE_ID),
    CONSTRAINT FK_Q_POINTS_Q_DIFF FOREIGN KEY (Q_DIFF_ID)
        REFERENCES Q_DIFF (Q_DIFF_ID)
);

CREATE TABLE QUESTION (
    Q_ID NUMBER(6),
    TOPIC_ID NUMBER(2),
    Q_TYPE_ID NUMBER(2),
    Q_DIFF_ID NUMBER(1),
    Q_TEXT VARCHAR2(300) NOT NULL,
    CONSTRAINT PK_QUESTION PRIMARY KEY(Q_ID),
    CONSTRAINT FK_Q_Q_TYPE FOREIGN KEY(Q_TYPE_ID)
        REFERENCES Q_TYPE(Q_TYPE_ID),
    CONSTRAINT FK_Q_Q_TOPIC FOREIGN KEY(TOPIC_ID)
        REFERENCES TOPIC(TOPIC_ID),
    CONSTRAINT FK_Q_Q_DIFF FOREIGN KEY(Q_DIFF_ID)
        REFERENCES Q_DIFF(Q_DIFF_ID)
);

CREATE TABLE OPTIONS (
    OPTS_ID NUMBER(6),
    Q_ID NUMBER(6),
    CONTENTZ VARCHAR2(300) NOT NULL,
    CORRECT NUMBER(1) NULL,
    CONSTRAINT PK_OPTS PRIMARY KEY (OPTS_ID),
    CONSTRAINT FK_OPTS_Q_ID FOREIGN KEY (Q_ID)
        REFERENCES QUESTION (Q_ID)
);

CREATE TABLE QUIZ (
    QUIZ_ID NUMBER(6),
    TO_USER NUMBER(6),
    FROM_USER NUMBER(6),
    TIME_CREATED TIMESTAMP(0) NOT NULL,
    CONSTRAINT PK_QZ PRIMARY KEY(QUIZ_ID),
    CONSTRAINT FK_QZ_TO_USER FOREIGN KEY(TO_USER)
        REFERENCES USERS(USER_ID),
    CONSTRAINT FK_QZ_FROM_USER FOREIGN KEY(FROM_USER)
        REFERENCES USERS(USER_ID)
);

CREATE TABLE QUIZ_Q_JUNCTION (
    Q_ID NUMBER(6),
    QUIZ_ID NUMBER(6),
    CONSTRAINT FK_QQJ_Q FOREIGN KEY(Q_ID)
        REFERENCES QUESTION(Q_ID),
    CONSTRAINT FK_QQJ_QZ FOREIGN KEY(QUIZ_ID)
        REFERENCES QUIZ (QUIZ_ID)
);

CREATE TABLE TOPIC_Q_JUNCTION (
    TOPIC_ID NUMBER(2),
    Q_ID NUMBER(6),
    CONSTRAINT FK_TQJ_TOPIC FOREIGN KEY(TOPIC_ID)
        REFERENCES TOPIC (TOPIC_ID),
    CONSTRAINT FK_TQJ_QUESTION FOREIGN KEY (Q_ID)
        REFERENCES QUESTION (Q_ID)
);

CREATE TABLE USER_REASON (
    REASON_ID NUMBER(1),
    REASON_NAME VARCHAR(20) NOT NULL,
    CONSTRAINT PK_U_REASON_REASON PRIMARY KEY (REASON_ID)
);

CREATE TABLE USER_REPORT (
    REPORT_ID NUMBER(6),
    REPORTED_ID NUMBER(6),
    REPORTER_ID NUMBER(6),
    REASON_ID NUMBER(1),
    CONSTRAINT PK_U_REPORT PRIMARY KEY (REPORT_ID),
    CONSTRAINT FK_U_REPORT_REPORTED FOREIGN KEY(REPORTED_ID)
        REFERENCES USERS (USER_ID),
    CONSTRAINT FK_U_REPORT_REPORTER FOREIGN KEY(REPORTER_ID)
        REFERENCES USERS (USER_ID),
    CONSTRAINT FK_U_REPORT_REASON FOREIGN KEY (REASON_ID)
        REFERENCES USER_REASON (REASON_ID)
);

CREATE TABLE QUESTION_REASON (
    REASON_ID NUMBER(1),
    REASON_NAME VARCHAR(20) NOT NULL,
    CONSTRAINT FK_Q_REASON_REASON PRIMARY KEY (REASON_ID)
);

CREATE TABLE QUESTION_REPORT (
    REPORT_ID NUMBER(6),
    REPORTED_ID NUMBER(6),
    REPORTER_ID NUMBER(6),
    REASON_ID NUMBER(1),
    CONSTRAINT PK_Q_REPORT PRIMARY KEY (REPORT_ID),
    CONSTRAINT FK_Q_REPORT_REPORTED FOREIGN KEY(REPORTED_ID)
        REFERENCES QUESTION (Q_ID),
    CONSTRAINT FK_Q_REPORT_REPORTER FOREIGN KEY(REPORTER_ID)
        REFERENCES USERS (USER_ID),
    CONSTRAINT FK_Q_REPORT_REASON FOREIGN KEY (REASON_ID)
        REFERENCES QUESTION_REASON (REASON_ID)
);