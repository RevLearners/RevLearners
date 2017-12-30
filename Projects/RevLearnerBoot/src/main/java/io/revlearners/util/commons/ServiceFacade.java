package io.revlearners.util.commons;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import io.revlearners.model.bean.*;
import io.revlearners.model.bo.*;
import io.revlearners.model.services.*;
import io.revlearners.model.services.interfaces.*;
import io.revlearners.util.commons.interfaces.IServiceFacade;

@Component
public class ServiceFacade implements IServiceFacade {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ITopicService topicService;

    @Autowired
    private IRankService rankService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRankService userRankService;

    @Autowired
    private IUserCertificationService userCertificationService;

    @Autowired
    private INotificationService notificationService;

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IReportUserService reportUService;

    @Autowired
    private IReportQuestionService reportQService;

    @Autowired
    private IFileBlobService blobService;

    @Autowired
    private IChallengeService questionService;


    @Override
    public TopicBo getTopicById(Serializable id) {
        Topic topic = topicService.findOne(id);
        return modelMapper.map(topic, TopicBo.class);
    }

    @Override
    public List<TopicBo> listTopics() {
        List<Topic> topics = topicService.findAll();
        List<TopicBo> topicDTOs = new LinkedList<>();
        for (Topic t : topics) {
            topicDTOs.add(modelMapper.map(t, TopicBo.class));
        }
        return topicDTOs;
    }

    @Override
    public Page<TopicBo> pageTopics(int page, int size) {
        Page<Topic> topics = topicService.pageAll(page, size);
        return topics.map(source -> modelMapper.map(source, TopicBo.class));
    }

    @Override
    public void createTopic(TopicBo topic) {
//		 topicService.create(modelMapper);
    }

    @Override
    public void updateTopic(TopicBo topic) {
        // topicService.update(topic);
    }

    @Override
    public void deleteTopicById(Serializable id) {
//		topicService.deleteById(id);
    }

    @Override
    public RankBo getRankById(Serializable id) {
        Rank rank = rankService.findOne(id);
        return modelMapper.map(rank, RankBo.class);
    }

    @Override
    public List<RankBo> listRanks() {
        List<Rank> ranks = rankService.findAll();
        List<RankBo> rankDTOs = new LinkedList<>();
        for (Rank t : ranks) {
            rankDTOs.add(modelMapper.map(t, RankBo.class));
        }
        return rankDTOs;
    }

    @Override
    public Page<RankBo> pageRanks(int page, int size) {
        Page<Rank> ranks = rankService.pageAll(page, size);
        return ranks.map(source -> modelMapper.map(source, RankBo.class));
    }

    @Override
    public void createRank(RankBo rankBo) {
        // Topic topic = topicService.findOneEntity(rankBo.getTopicId());
        // Rank rank = new Rank(rankBo.getId(), rankBo.getName(),
        // rankBo.getRelativeWeight(), rankBo.getMeritThreshold(), topic);
        // rankService.create(rank);
    }

    @Override
    public void updateRank(RankBo rank) {
        // rankService.update(rank);
    }

    @Override
    public void deleteRankById(Serializable id) {
//		rankService.deleteById(id);
    }

    @Override
    public UserBo getUserById(Serializable id) {
        User user = userService.findOne(id);
        return modelMapper.map(user, UserBo.class);
    }

    @Override
    public List<UserBo> listUsers() {
        List<User> users = userService.findAll();
        List<UserBo> userDTOs = new LinkedList<>();
        for (User t : users) {
            userDTOs.add(modelMapper.map(t, UserBo.class));
        }
        return userDTOs;
    }

    @Override
    public Page<UserBo> pageUsers(int page, int size) {
        Page<User> users = userService.pageAll(page, size);
        return users.map(source -> modelMapper.map(source, UserBo.class));
    }

    @Override
    public void login(UserBo user) {
        // userService.login(user);
    }

    @Override
    public void register(UserBo user) {
        userService.register(user);
    }

    @Override
    public void updateUser(UserBo user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteUserById(Serializable id) {
        // TODO Auto-generated method stub

    }

    @Override
    public MessageBo getMessageById(Serializable id) {
        Message message = messageService.findOne(id);
        return modelMapper.map(message, MessageBo.class);
    }

    @Override
    public List<MessageBo> listMessages() {
        List<Message> messages = messageService.findAll();
        List<MessageBo> messageDTOs = new LinkedList<>();
        for (Message t : messages) {
            messageDTOs.add(modelMapper.map(t, MessageBo.class));
        }
        return messageDTOs;
    }

    @Override
    public Page<MessageBo> pageMessages(int page, int size) {
        Page<Message> messages = messageService.pageAll(page, size);
        return messages.map(source -> modelMapper.map(source, MessageBo.class));
    }

    @Override
    public void createMessage(MessageBo message) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateMessage(MessageBo message) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteMessageById(Serializable id) {
        // TODO Auto-generated method stub

    }

    @Override
    public NotificationBo getNotificationById(Serializable id) {
        Notification notification = notificationService.findOne(id);
        return modelMapper.map(notification, NotificationBo.class);
    }

    @Override
    public List<NotificationBo> listNotifications() {
        List<Notification> notifications = notificationService.findAll();
        List<NotificationBo> notificationDTOs = new LinkedList<>();
        for (Notification t : notifications) {
            notificationDTOs.add(modelMapper.map(t, NotificationBo.class));
        }
        return notificationDTOs;
    }

    @Override
    public Page<NotificationBo> pageNotifications(int page, int size) {
        Page<Notification> notifications = notificationService.pageAll(page, size);
        return notifications.map(source -> modelMapper.map(source, NotificationBo.class));
    }

	@Override
	public void updateNotification(List<NotificationBo> notifications) {
		List<Notification> notifs = null;
		for (NotificationBo nbo : notifications) {
			Notification n = modelMapper.map(nbo, Notification.class);
			notifs.add(n);
		}
		notificationService.updateStatus(notifs);
	}

    @Override
    public void deleteNotificationById(Serializable id) {
        // TODO Auto-generated method stub

    }


    @Override
    public Challenge generateChallenge(ChallengeService.ChallengeInfo info) {
        return this.questionService.generateChallenge(info);
    }

    @Override
    public Question createQuestion(Question question) {
        return questionService.saveQuestion(question);
    }

    @Override
    public Challenge getChallengeById(Long id) {
        return questionService.getChallengeById(id);
    }

    @Override
    public List<Challenge> getChallengesByUser(Long userId) {
        return questionService.getChallengesByUser(userId);
    }

    @Override
    public List<ChallengeAttempt> getChallengeAttemptsByUser(Long challengeId, Long userId) {
        // todo: validate user id is logged in user
        return questionService.getChallengeAttemptsByUser(challengeId, userId);
    }

    @Override
    public float scoreChallenge(ChallengeAttemptBo2 info) {
        Map<Long, List<Long>> answersMap = info.getAnswers();
        Set<QuestionOption> flattened = new HashSet<>();
        for (Long questId: answersMap.keySet()) {
            for (Long selectedOptId: answersMap.get(questId)) {
                QuestionOption opt = new QuestionOption();
                opt.setId(selectedOptId);
                opt.setQuestion(new Question(questId));
                flattened.add(opt);
            }
        }

        ChallengeAttempt attempt = new ChallengeAttempt();
        attempt.setAnswers(flattened);

        // populate from db so service can access quiz, questions
        attempt.setChallenge(questionService.getChallengeById(info.getChallengeId()));
        User user = new User();
        user.setId(info.getUserId());
        attempt.setUser(user);
        return questionService.submitChallengeAttempt(attempt);
    }

    @Override
    public void updateChallenge(Challenge challenge) {
        // TODO Auto-generated method stub
    }


    @Override
    public ReportUserBo getReportUserById(Serializable id) {
        ReportUser reportUser = reportUService.findOne(id);
        return modelMapper.map(reportUser, ReportUserBo.class);
    }

    @Override
    public List<ReportUserBo> listReportUsers() {
        List<ReportUser> reportUsers = reportUService.findAll();
        List<ReportUserBo> reportUserDTOs = new LinkedList<>();
        for (ReportUser t : reportUsers) {
            reportUserDTOs.add(modelMapper.map(t, ReportUserBo.class));
        }
        return reportUserDTOs;
    }

    @Override
    public Page<ReportUserBo> pageReportUsers(int page, int size) {
        Page<ReportUser> reportUsers = reportUService.pageAll(page, size);
        return reportUsers.map(source -> modelMapper.map(source, ReportUserBo.class));
    }

    @Override
    public void createReportUser(ReportUserBo reportUser) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateReportUser(ReportUserBo reportUser) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteReportUserById(Serializable id) {
        // TODO Auto-generated method stub

    }

    @Override
    public ReportQuestionBo getReportQuestionById(Serializable id) {
        ReportQuestion question = reportQService.findOne(id);
        return modelMapper.map(question, ReportQuestionBo.class);
    }

    @Override
    public List<ReportQuestionBo> listReportQuestions() {
        List<ReportQuestion> reportReportQuestions = reportQService.findAll();
        List<ReportQuestionBo> reportReportQuestionDTOs = new LinkedList<>();
        for (ReportQuestion t : reportReportQuestions) {
            reportReportQuestionDTOs.add(modelMapper.map(t, ReportQuestionBo.class));
        }
        return reportReportQuestionDTOs;
    }

    @Override
    public Page<ReportQuestionBo> pageReportQuestions(int page, int size) {
        Page<ReportQuestion> reportReportQuestions = reportQService.pageAll(page, size);
        return reportReportQuestions.map(source -> modelMapper.map(source, ReportQuestionBo.class));
    }

    @Override
    public void createReportQuestion(ReportQuestionBo reportQuestion) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateReportQuestion(ReportQuestionBo reportQuestion) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteReportQuestionById(Serializable id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void sendMessage(MessageBo msg) {
        // TODO Auto-generated method stub

    }

    @Override
    public void sendEmail() {
        // TODO Auto-generated method stub

    }
}
