package io.revlearners.util.commons.interfaces;

import java.io.Serializable;
import java.util.*;

import io.revlearners.model.bean.Challenge;
import io.revlearners.model.bean.ChallengeAttempt;
import io.revlearners.model.bean.Question;
import org.springframework.data.domain.Page;
import org.springframework.mobile.device.Device;

import io.revlearners.model.bo.*;

public interface IServiceFacade {

 	// First we need methods for interfacing our basic CRUD requests

	// Topic Services
	TopicBo getTopicById(Serializable id);

	List<TopicBo> listTopics();

	Page<TopicBo> pageTopics(int page, int size);

	void createTopic(TopicBo topic);

	void updateTopic(TopicBo topic);

	void deleteTopicById(Serializable id);

	// Rank Services
	RankBo getRankById(Serializable id);

	List<RankBo> listRanks();

	Page<RankBo> pageRanks(int page, int size);

	void createRank(RankBo rank);

	void updateRank(RankBo rank);

	void deleteRankById(Serializable id);

	// User Services
	UserBo getUserById(Serializable id);

	List<UserBo> listUsers();

	Page<UserBo> pageUsers(int page, int size);

	String login(String username, String password, Device device);

	void register(UserBo user, Device device);

	void updateUser(UserBo user);

	void deleteUserById(Serializable id);

	// Messaging Services
	MessageBo getMessageById(Serializable id);

	List<MessageBo> listMessages();

	Page<MessageBo> pageMessages(int page, int size);

	void createMessage(MessageBo message);

	void updateMessage(MessageBo message);

	void deleteMessageById(Serializable id);

	// Notification Services
	NotificationBo getNotificationById(Serializable id);

	List<NotificationBo> listNotifications();

	Page<NotificationBo> pageNotifications(int page, int size);

	public void updateNotification(List<NotificationBo> notifications);

	void deleteNotificationById(Serializable id);

    // Challenge/Question/Quiz services

    Challenge generateChallenge(ChallengeInfoBo info);

    Question createQuestion(Question question);

    Challenge getChallengeById(Long id);

    List<Challenge> getChallengesByUser(Long userId);

    List<ChallengeAttempt> getChallengeAttemptsByUser(Long challengeId, Long userId);

    float scoreChallenge(ChallengeAttemptBo2 info);

    void updateChallenge(Challenge challenge);

	// Reporting Services
	ReportUserBo getReportUserById(Serializable id);

	List<ReportUserBo> listReportUsers();

	Page<ReportUserBo> pageReportUsers(int page, int size);

	void createReportUser(ReportUserBo reportUser);

	void updateReportUser(ReportUserBo reportUser);

	void deleteReportUserById(Serializable id);

	ReportQuestionBo getReportQuestionById(Serializable id);

	List<ReportQuestionBo> listReportQuestions();

	Page<ReportQuestionBo> pageReportQuestions(int page, int size);

	void createReportQuestion(ReportQuestionBo reportQuestion);

	void updateReportQuestion(ReportQuestionBo reportQuestion);

	void deleteReportQuestionById(Serializable id);

	// Now we need some external service handling

	// Chat Services
	void sendMessage(MessageBo msg);

	// Email Services
	void sendEmail();

	String checkRefresh(String token);

	String verifyUser(String token, Device device);

}
