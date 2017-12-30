package io.revlearners.util.commons.interfaces;

import java.io.Serializable;
import java.util.*;

import org.springframework.data.domain.Page;

import io.revlearners.model.bo.*;

public interface IServiceFacade {

	// First we need methods for interfacing our basic CRUD requests

	// Topic Services
	public TopicBo getTopicById(Serializable id);

	public List<TopicBo> listTopics();

	public Page<TopicBo> pageTopics(int page, int size);

	public void createTopic(TopicBo topic);

	public void updateTopic(TopicBo topic);

	public void deleteTopicById(Serializable id);

	// Rank Services
	public RankBo getRankById(Serializable id);

	public List<RankBo> listRanks();

	public Page<RankBo> pageRanks(int page, int size);

	public void createRank(RankBo rank);

	public void updateRank(RankBo rank);

	public void deleteRankById(Serializable id);

	// User Services
	public UserBo getUserById(Serializable id);

	public List<UserBo> listUsers();

	public Page<UserBo> pageUsers(int page, int size);
	
	public void login(UserBo user);
	
	public void register(UserBo user);

	public void updateUser(UserBo user);

	public void deleteUserById(Serializable id);

	// Question Services
	public QuestionBo getQuestionById(Serializable id);

	public List<QuestionBo> listQuestions();

	public Page<QuestionBo> pageQuestions(int page, int size);

	public void createQuestion(QuestionBo question);

	public void updateQuestion(QuestionBo question);

	public void deleteQuestionById(Serializable id);

	// Challenge Services
	public ChallengeBo getChallengeById(Serializable id);

	public List<ChallengeBo> listChallenges();

	public Page<ChallengeBo> pageChallenges(int page, int size);

	public void createChallenge(ChallengeBo challenge);

	public void updateChallenge(ChallengeBo challenge);

	public void deleteChallengeById(Serializable id);

	// Messaging Services
	public MessageBo getMessageById(Serializable id);

	public List<MessageBo> listMessages();

	public Page<MessageBo> pageMessages(int page, int size);

	public void createMessage(MessageBo message);

	public void updateMessage(MessageBo message);

	public void deleteMessageById(Serializable id);

	// Notification Services
	public NotificationBo getNotificationById(Serializable id);

	public List<NotificationBo> listNotifications();

	public Page<NotificationBo> pageNotifications(int page, int size);

	public void updateNotification(List<NotificationBo> notifications);

	public void deleteNotificationById(Serializable id);
	
	// Reporting Services
	public ReportUserBo getReportUserById(Serializable id);

	public List<ReportUserBo> listReportUsers();

	public Page<ReportUserBo> pageReportUsers(int page, int size);

	public void createReportUser(ReportUserBo reportUser);

	public void updateReportUser(ReportUserBo reportUser);

	public void deleteReportUserById(Serializable id);
	
	public ReportQuestionBo getReportQuestionById(Serializable id);

	public List<ReportQuestionBo> listReportQuestions();

	public Page<ReportQuestionBo> pageReportQuestions(int page, int size);

	public void createReportQuestion(ReportQuestionBo reportQuestion);

	public void updateReportQuestion(ReportQuestionBo reportQuestion);

	public void deleteReportQuestionById(Serializable id);

	// Now we need some external service handling

	// Chat Services
	public void sendMessage(MessageBo msg);

	// Email Services
	public void sendEmail();
}
