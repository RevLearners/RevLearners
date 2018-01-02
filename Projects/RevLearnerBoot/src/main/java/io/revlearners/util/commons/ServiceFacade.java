package io.revlearners.util.commons;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.revlearners.model.bo.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Component;

import io.revlearners.model.bean.Challenge;
import io.revlearners.model.bean.ChallengeAttempt;
import io.revlearners.model.bean.FileBlob;
import io.revlearners.model.bean.Message;
import io.revlearners.model.bean.MessageStatus;
import io.revlearners.model.bean.MimeType;
import io.revlearners.model.bean.Notification;
import io.revlearners.model.bean.Question;
import io.revlearners.model.bean.QuestionOption;
import io.revlearners.model.bean.Rank;
import io.revlearners.model.bean.ReportQuestion;
import io.revlearners.model.bean.ReportUser;
import io.revlearners.model.bean.Topic;
import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserRole;
import io.revlearners.model.mapper.customConverters.MessageModelMapper;
import io.revlearners.model.services.EmailService;
import io.revlearners.model.services.interfaces.IChallengeService;
import io.revlearners.model.services.interfaces.IFileBlobService;
import io.revlearners.model.services.interfaces.IMessageService;
import io.revlearners.model.services.interfaces.INotificationService;
import io.revlearners.model.services.interfaces.IRankService;
import io.revlearners.model.services.interfaces.IReportQuestionService;
import io.revlearners.model.services.interfaces.IReportUserService;
import io.revlearners.model.services.interfaces.ITopicService;
import io.revlearners.model.services.interfaces.IUserCertificationService;
import io.revlearners.model.services.interfaces.IUserRankService;
import io.revlearners.model.services.interfaces.IUserRoleService;
import io.revlearners.model.services.interfaces.IUserService;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.commons.interfaces.IServiceFacade;

@Component
public class ServiceFacade implements IServiceFacade {

	@Autowired
	EmailService emailService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private MessageModelMapper msgModelMapper;

	@Autowired
	private ITopicService topicService;

	@Autowired
	private IRankService rankService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserRankService userRankService;

	@Autowired
	private IUserRoleService userRoleService;

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
		// topicService.create(modelMapper);
	}

	@Override
	public void updateTopic(TopicBo topic) {
		// topicService.update(topic);
	}

	@Override
	public void deleteTopicById(Serializable id) {
		// topicService.deleteById(id);
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
		// rankService.deleteById(id);
	}

	@Override
	public UserRoleBo getRoleById(Serializable id) {
		UserRole role = userRoleService.findOne(id);
		return modelMapper.map(role, UserRoleBo.class);
	};

	@Override
	public UserRoleBo getRoleByUserId(Serializable userId) {
		User user = modelMapper.map(getUserById(userId), User.class);
		UserRole role = userRoleService.findUserRole(user);
		return modelMapper.map(role, UserRoleBo.class);
	};

	@Override
	public List<UserRoleBo> listRoles() {
		List<UserRole> roles = userRoleService.findAll();
		List<UserRoleBo> roleDTOs = new LinkedList<>();
		for (UserRole t : roles) {
			roleDTOs.add(modelMapper.map(t, UserRoleBo.class));
		}
		return roleDTOs;
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

	/**
	 * returns null if user does not exist throws AuthenticationException
	 *
	 * @param username
	 * @param password
	 * @param device
	 * @return
	 */
	@Override
	public LoginInfoBo login(String username, String password, Device device) {
		MPair<User, String> info = userService.login(username, password, device);
		User user = info.getFirst();
		String token = info.getSecond();
		return new LoginInfoBo(modelMapper.map(user, UserBo.class), token);
	}

	@Override
	public void register(UserBo user, Device device) {
		String token = userService.register(user, device);
		if (token == null)
			return;
		emailService.sendVerificationEmail(user.getEmail(), token);
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

		System.out.print("n\n\n\n\n\n" + messages.toString() + "n\n\n\n\n\n");
		System.out.print("n\n\n\n\n\n" + messageDTOs.toString() + "n\n\n\n\n\n");

		return messageDTOs;
	}

	@Override
	public Page<MessageBo> pageMessages(int page, int size) {
		Page<Message> messages = messageService.pageAll(page, size);
		return messages.map(source -> modelMapper.map(source, MessageBo.class));
	}

	@Override
	public void createMessages(MessageBo message) {
	
		List<Message> messages = new LinkedList<Message>();
			
		if (message.getBlobs() != null && !message.getBlobs().isEmpty()) {
			
			Set<FileBlob> blobs = new LinkedHashSet<FileBlob>();
			MimeType mime;
			for (FileBlobBo fb : message.getBlobs()) {
				mime = (MimeType) blobService.findOneMime(fb.getMimeType().getId());
				blobs.add(new FileBlob(fb.getName(), fb.getSize(), fb.getContents(), mime));
			}
			
			Set<Long> ids = new HashSet<Long>();
			Set<User> receivers = new HashSet<User>();
			User sender = userService.findOne(message.getSender().getId());
			MessageStatus stat = messageService.findOneStatus(Constants.MESSAGE_STATUS_UNREAD);
						
			message.getReceivers().forEach(user -> ids.add(user.getId()));
			userService.findAll().forEach(user -> appendReceivers(receivers, ids, user));

			for(User u : receivers) {
				Set<User> cc = new HashSet<User>(receivers);
				cc.remove(u);
				messages.add(new Message(sender, u, cc, message.getTitle(), message.getContents(), blobs, message.getTime(), stat));
			}

			messages = messageService.create(messages);
		}
	}

	private void appendReceivers(Set<User> receivers, Set<Long> ids, User user) {
		if (ids.contains(user.getId()))
			receivers.add(user);
	}

	@Override
	public void updateMessage(MessageBo message) {
	}

	@Override
	public void updateMessages(List<MessageBo> messages) {
		List<Message> msgs = new LinkedList<Message>();
		for (MessageBo mbo : messages) {
			Message n = modelMapper.map(mbo, Message.class);
			msgs.add(n);
		}
		messageService.updateStatus(msgs);
	}

	@Override
	public void deleteMessageById(Serializable id) {
	}

	@Override
	public NotificationBo getNotificationById(Serializable id) {
		Notification notification = notificationService.findOne(id);
		return modelMapper.map(notification, NotificationBo.class);
	}
	
	@Override
	public void createNotifications(List<NotificationBo> notification) {
		
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
		List<Notification> notifs = new LinkedList<Notification>();
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
	public Challenge generateChallenge(ChallengeInfoBo info) {

		User sender = new User();
		sender.setId(info.getSenderId());
		Challenge challenge = this.questionService.generateChallenge(info);
		MessageStatus status = new MessageStatus(Constants.MESSAGE_STATUS_UNREAD, Constants.MESSAGE_STATUS_UNREAD_STR);
		notificationService.generateChallengeNotification(sender, challenge.getUsers(), status, challenge);
		return challenge;
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
		for (Long questId : answersMap.keySet()) {
			for (Long selectedOptId : answersMap.get(questId)) {
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

	//-------------------- REPORTS -----------------------
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

	//-------------------- ?? -----------------------
	@Override
	public void sendMessage(MessageBo msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendEmail() {
		// TODO Auto-generated method stub

	}

	@Override
	public String checkRefresh(String token) {
		return userService.tryRefresh(token);
	}

	@Override
	public String verifyUser(String token, Device device) {
		return userService.verify(token, device);
	}

	@Override
	public List<MessageBo> listMessagesByReceiverId(Long id) {
		List<MessageBo> bos = new LinkedList<MessageBo>();
		List<Message> messages = messageService.findByReceiverId(id);
		for(Message msg : messages) {
			bos.add(modelMapper.map(msg, MessageBo.class));
		}
		return bos;
		
	}

}
