package io.revlearners.util.commons.interfaces;

import java.util.*;

import io.revlearners.model.bean.Challenge;
import io.revlearners.model.bean.ChallengeAttempt;
import io.revlearners.model.bean.Question;
import io.revlearners.model.services.QuestionService;
import org.springframework.data.domain.Page;

import io.revlearners.model.bo.*;

public interface IServiceFacade {

    // Question Services
    Question getQuestionById(Long id);

    Challenge generateChallenge(QuestionService.ChallengeInfo info);

    Question createQuestion(Question question);

    void deleteQuestionById(Long id);

    Challenge getChallengeById(long id);

    List<Challenge> getChallengesByUser(long userId);

    List<ChallengeAttempt> getChallengeAttemptsByUser(long challengeId, long userId);

    Long scoreChallenge(ChallengeAttempt attempt);

    void updateChallenge(Challenge challenge);


    // First we need methods for interfacing our basic CRUD requests

    // Topic Services
    TopicBo getTopicById(Long id);

    List<TopicBo> listTopics();

    Page<TopicBo> pageTopics(int page, int size);

    void createTopic(TopicBo topic);

    void updateTopic(TopicBo topic);

    void deleteTopicById(Long id);

    // Rank Services
    RankBo getRankById(Long id);

    List<RankBo> listRanks();

    Page<RankBo> pageRanks(int page, int size);

    void createRank(RankBo rank);

    void updateRank(RankBo rank);

    void deleteRankById(Long id);

    // User Services
    UserBo getUserById(Long id);

    List<UserBo> listUsers();

    Page<UserBo> pageUsers(int page, int size);

    void createUser(UserBo user);

    void updateUser(UserBo user);

    void deleteUserById(Long id);

    // Messaging Services
    MessageBo getMessageById(Long id);

    List<MessageBo> listMessages();

    Page<MessageBo> pageMessages(int page, int size);

    void createMessage(MessageBo message);

    void updateMessage(MessageBo message);

    void deleteMessageById(Long id);

    // Notification Services
    NotificationBo getNotificationById(Long id);

    List<NotificationBo> listNotifications();

    Page<NotificationBo> pageNotifications(int page, int size);

    void createNotification(NotificationBo notification);

    void updateNotification(NotificationBo notification);

    void deleteNotificationById(Long id);

    // Reporting Services
    ReportUserBo getReportUserById(Long id);

    List<ReportUserBo> listReportUsers();

    Page<ReportUserBo> pageReportUsers(int page, int size);

    void createReportUser(ReportUserBo reportUser);

    void updateReportUser(ReportUserBo reportUser);

    void deleteReportUserById(Long id);

    ReportQuestionBo getReportQuestionById(Long id);

    List<ReportQuestionBo> listReportQuestions();

    Page<ReportQuestionBo> pageReportQuestions(int page, int size);

    void createReportQuestion(ReportQuestionBo reportQuestion);

    void updateReportQuestion(ReportQuestionBo reportQuestion);

    void deleteReportQuestionById(Long id);

    // Now we need some external service handling

    // Chat Services
    void sendMessage(MessageBo msg);

    // Email Services
    void sendEmail();
}
