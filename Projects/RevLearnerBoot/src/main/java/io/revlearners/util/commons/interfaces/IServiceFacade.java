package io.revlearners.util.commons.interfaces;

import java.util.*;

import org.springframework.data.domain.Page;

import io.revlearners.model.bo.*;

public interface IServiceFacade {

	// First we need methods for interfacing our basic CRUD requests

	// Topic Services
	public TopicBo getTopicById(Long id);

	public List<TopicBo> listTopics();

	public Page<TopicBo> pageTopics(int page, int size);

	public void createTopic(TopicBo topic);

	public void updateTopic(TopicBo topic);

	public void deleteTopicById(Long id);

	// Rank Services
	public RankBo getRankById(Long id);

	public List<RankBo> listRanks();

	public Page<RankBo> pageRanks(int page, int size);

	public void createRank(RankBo rank);

	public void updateRank(RankBo rank);

	public void deleteRankById(Long id);

	// User Services
	public UserBo getUserById(Long id);

	public List<UserBo> listUsers();

	public Page<UserBo> pageUsers(int page, int size);

	public void createUser(UserBo user);

	public void updateUser(UserBo user);

	public void deleteUserById(Long id);

	// Question Services
	public QuestionBo getQuestionById(Long id);

	public List<QuestionBo> listQuestions();

	public Page<QuestionBo> pageQuestions(int page, int size);

	public void createQuestion(QuestionBo question);

	public void updateQuestion(QuestionBo question);

	public void deleteQuestionById(Long id);

	// Challenge Services
	public ChallengeBo getChallengeById(Long id);

	public List<ChallengeBo> listChallenges();

	public Page<ChallengeBo> pageChallenges(int page, int size);

	public void createChallenge(ChallengeBo challenge);

	public void updateChallenge(ChallengeBo challenge);

	public void deleteChallengeById(Long id);

	// Messaging Services
	public MessageBo getMessageById(Long id);

	public List<MessageBo> listMessages();

	public Page<MessageBo> pageMessages(int page, int size);

	public void createMessage(MessageBo message);

	public void updateMessage(MessageBo message);

	public void deleteMessageById(Long id);

	// Notification Services
	public NotificationBo getNotificationById(Long id);

	public List<NotificationBo> listNotifications();

	public Page<NotificationBo> pageNotifications(int page, int size);

	public void createNotification(NotificationBo notification);

	public void updateNotification(NotificationBo notification);

	public void deleteNotificationById(Long id);
	
	// Reporting Services
	public ReportUserBo getReportUserById(Long id);

	public List<ReportUserBo> listReportUsers();

	public Page<ReportUserBo> pageReportUsers(int page, int size);

	public void createReportUser(ReportUserBo reportUser);

	public void updateReportUser(ReportUserBo reportUser);

	public void deleteReportUserById(Long id);
	
	public ReportQuestionBo getReportQuestionById(Long id);

	public List<ReportQuestionBo> listReportQuestions();

	public Page<ReportQuestionBo> pageReportQuestions(int page, int size);

	public void createReportQuestion(ReportQuestionBo reportQuestion);

	public void updateReportQuestion(ReportQuestionBo reportQuestion);

	public void deleteReportQuestionById(Long id);

	// Now we need some external service handling

	// Chat Services
	public void sendMessage(MessageBo msg);

	// Email Services
	public void sendEmail();
}
