package io.revlearners.util.commons;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import io.revlearners.model.bean.*;
import io.revlearners.model.bo.*;
import io.revlearners.model.services.*;
import io.revlearners.model.services.interfaces.*;
import io.revlearners.util.commons.interfaces.IServiceFacade;

@Component
public class ServiceFacade implements IServiceFacade {
	
//	@Autowired
//	private  ICrudService<UserStatus> userStatusCrudService;
//	
//	@Autowired
//	private  ICrudService<UserRole> userRoleCrudService;
//	
//	@Autowired
//	private  ICrudService<MessageStatus> messageStatusCrudService;
//	
//	@Autowired
//	private  ICrudService<RequestStatus> requestStatusCrudService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ITopicService topicService;

	@Autowired
	private IRankService rankService;

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IQuestionService questionService;
	
	@Autowired
	private IChallengeService challengeService;
	
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

	@Override
	public TopicBo getTopicById(Serializable id) {
		Topic topic = topicService.findOne(id);
		return modelMapper.map(topic, TopicBo.class);
	}

	@Override
	public List<TopicBo> listTopics() {
		List<Topic> topics = topicService.findAll();
		List<TopicBo> topicDTOs = new LinkedList<TopicBo>();
		for (Topic t : topics) {
			topicDTOs.add(modelMapper.map(t, TopicBo.class));
		}
		return topicDTOs;
	}

	@Override
	public Page<TopicBo> pageTopics(int page, int size) {
		Page<Topic> topics = topicService.pageAll(page, size);
		return topics.map(new Converter<Topic, TopicBo>() {

			@Override
			public TopicBo convert(Topic source) {
				return modelMapper.map(source, TopicBo.class);
			}
		});
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
		List<RankBo> rankDTOs = new LinkedList<RankBo>();
		for (Rank t : ranks) {
			rankDTOs.add(modelMapper.map(t, RankBo.class));
		}
		return rankDTOs;
	}

	@Override
	public Page<RankBo> pageRanks(int page, int size) {
		Page<Rank> ranks = rankService.pageAll(page, size);
		return ranks.map(new Converter<Rank, RankBo>() {

			@Override
			public RankBo convert(Rank source) {
				return modelMapper.map(source, RankBo.class);
			}
		});
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
		List<UserBo> userDTOs = new LinkedList<UserBo>();
		for (User t : users) {
			userDTOs.add(modelMapper.map(t, UserBo.class));
		}
		return userDTOs;
	}

	@Override
	public Page<UserBo> pageUsers(int page, int size) {
		Page<User> users = userService.pageAll(page, size);
		return users.map(new Converter<User, UserBo>() {

			@Override
			public UserBo convert(User source) {
				return modelMapper.map(source, UserBo.class);
			}
		});
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
	public QuestionBo getQuestionById(Serializable id) {
		Question question = questionService.findOne(id);
		return modelMapper.map(question, QuestionBo.class);
	}

	@Override
	public List<QuestionBo> listQuestions() {
		List<Question> questions = questionService.findAll();
		List<QuestionBo> questionDTOs = new LinkedList<QuestionBo>();
		for (Question t : questions) {
			questionDTOs.add(modelMapper.map(t, QuestionBo.class));
		}
		return questionDTOs;
	}

	@Override
	public Page<QuestionBo> pageQuestions(int page, int size) {
		Page<Question> questions = questionService.pageAll(page, size);
		return questions.map(new Converter<Question, QuestionBo>() {

			@Override
			public QuestionBo convert(Question source) {
				return modelMapper.map(source, QuestionBo.class);
			}
		});
	}

	@Override
	public void createQuestion(QuestionBo question) {
//		Question quest = new Question();
	}

	@Override
	public void updateQuestion(QuestionBo question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteQuestionById(Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ChallengeBo getChallengeById(Serializable id) {
		Challenge challenge = challengeService.findOne(id);
		return modelMapper.map(challenge, ChallengeBo.class);
	}

	@Override
	public List<ChallengeBo> listChallenges() {
		List<Challenge> challenges = challengeService.findAll();
		List<ChallengeBo> challengeDTOs = new LinkedList<ChallengeBo>();
		for (Challenge t : challenges) {
			challengeDTOs.add(modelMapper.map(t, ChallengeBo.class));
		}
		return challengeDTOs;
	}

	@Override
	public Page<ChallengeBo> pageChallenges(int page, int size) {
		Page<Challenge> challenges = challengeService.pageAll(page, size);
		return challenges.map(new Converter<Challenge, ChallengeBo>() {

			@Override
			public ChallengeBo convert(Challenge source) {
				return modelMapper.map(source, ChallengeBo.class);
			}
		});
	}

	@Override
	public void createChallenge(ChallengeBo challenge) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateChallenge(ChallengeBo challenge) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteChallengeById(Serializable id) {
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
		List<MessageBo> messageDTOs = new LinkedList<MessageBo>();
		for (Message t : messages) {
			messageDTOs.add(modelMapper.map(t, MessageBo.class));
		}
		return messageDTOs;
	}

	@Override
	public Page<MessageBo> pageMessages(int page, int size) {
		Page<Message> messages = messageService.pageAll(page, size);
		return messages.map(new Converter<Message, MessageBo>() {

			@Override
			public MessageBo convert(Message source) {
				return modelMapper.map(source, MessageBo.class);
			}
		});
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
		List<NotificationBo> notificationDTOs = new LinkedList<NotificationBo>();
		for (Notification t : notifications) {
			notificationDTOs.add(modelMapper.map(t, NotificationBo.class));
		}
		return notificationDTOs;
	}

	@Override
	public Page<NotificationBo> pageNotifications(int page, int size) {
		Page<Notification> notifications = notificationService.pageAll(page, size);
		return notifications.map(new Converter<Notification, NotificationBo>() {

			@Override
			public NotificationBo convert(Notification source) {
				return modelMapper.map(source, NotificationBo.class);
			}
		});
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
	public ReportUserBo getReportUserById(Serializable id) {
		ReportUser reportUser = reportUService.findOne(id);
		return modelMapper.map(reportUser, ReportUserBo.class);
	}

	@Override
	public List<ReportUserBo> listReportUsers() {
		List<ReportUser> reportUsers = reportUService.findAll();
		List<ReportUserBo> reportUserDTOs = new LinkedList<ReportUserBo>();
		for (ReportUser t : reportUsers) {
			reportUserDTOs.add(modelMapper.map(t, ReportUserBo.class));
		}
		return reportUserDTOs;
	}

	@Override
	public Page<ReportUserBo> pageReportUsers(int page, int size) {
		Page<ReportUser> reportUsers = reportUService.pageAll(page, size);
		return reportUsers.map(new Converter<ReportUser, ReportUserBo>() {

			@Override
			public ReportUserBo convert(ReportUser source) {
				return modelMapper.map(source, ReportUserBo.class);
			}
		});
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
		List<ReportQuestionBo> reportReportQuestionDTOs = new LinkedList<ReportQuestionBo>();
		for (ReportQuestion t : reportReportQuestions) {
			reportReportQuestionDTOs.add(modelMapper.map(t, ReportQuestionBo.class));
		}
		return reportReportQuestionDTOs;
	}

	@Override
	public Page<ReportQuestionBo> pageReportQuestions(int page, int size) {
		Page<ReportQuestion> reportReportQuestions = reportQService.pageAll(page, size);
		return reportReportQuestions.map(new Converter<ReportQuestion, ReportQuestionBo>() {

			@Override
			public ReportQuestionBo convert(ReportQuestion source) {
				return modelMapper.map(source, ReportQuestionBo.class);
			}
		});
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
