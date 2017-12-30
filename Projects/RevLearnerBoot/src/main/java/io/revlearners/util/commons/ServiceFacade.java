package io.revlearners.util.commons;

import java.util.List;

import io.revlearners.model.bean.Challenge;
import io.revlearners.model.bean.ChallengeAttempt;
import io.revlearners.model.bean.Question;
import io.revlearners.model.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import io.revlearners.model.bo.*;
import io.revlearners.model.services.interfaces.*;
import io.revlearners.util.commons.interfaces.IServiceFacade;

@Component
public class ServiceFacade implements IServiceFacade {

    @Autowired
    private ITopicService topicService;

    @Autowired
    private IRankService rankService;

    @Autowired
    private IQuestionService questionService;


    //-----------------------------------------------------------------------------------
    @Override
    public Question getQuestionById(Long id) {
        return null;
    }

    @Override
    public Challenge generateChallenge(QuestionService.ChallengeInfo info) {
        return this.questionService.generateChallenge(info);
    }

    @Override
    public Question createQuestion(Question question) {
        return questionService.saveQuestion(question);
    }

    @Override
    public void deleteQuestionById(Long id) {
        // TODO Auto-generated method stub
    }

    @Override
    public Challenge getChallengeById(long id) {
        return questionService.getChallengeById(id);
    }

    @Override
    public List<Challenge> getChallengesByUser(long userId) {
        return questionService.getChallengesByUser(userId);
    }

    @Override
    public List<ChallengeAttempt> getChallengeAttemptsByUser(long challengeId, long userId) {
        // todo: validate user id is logged in user
        return questionService.getChallengeAttemptsByUser(challengeId, userId);
    }

    @Override
    public Long scoreChallenge(ChallengeAttempt attempt) {
        return -1L;
        //return questionService.scoreChallenge(attempt);
    }

    @Override
    public void updateChallenge(Challenge challenge) {
        // TODO Auto-generated method stub
    }
//-----------------------------------------------------------------------------------


    @Override
    public TopicBo getTopicById(Long id) {
        return topicService.findOne(id);
    }

    @Override
    public List<TopicBo> listTopics() {
        return topicService.findAll();
    }

    @Override
    public Page<TopicBo> pageTopics(int page, int size) {
        return topicService.pageAll(page, size);
    }

    @Override
    public void createTopic(TopicBo topic) {
//		topicService.create(topic);
    }

    @Override
    public void updateTopic(TopicBo topic) {
//		topicService.update(topic);
    }

    @Override
    public void deleteTopicById(Long id) {
        topicService.deleteById(id);
    }

    @Override
    public RankBo getRankById(Long id) {
        return rankService.findOne(id);
    }

    @Override
    public List<RankBo> listRanks() {
        return rankService.findAll();
    }

    @Override
    public Page<RankBo> pageRanks(int page, int size) {
        return rankService.pageAll(page, size);
    }

    @Override
    public void createRank(RankBo rankBo) {
//		Topic topic = topicService.findOneEntity(rankBo.getTopicId());
//		Rank rank = new Rank(rankBo.getId(), rankBo.getName(), rankBo.getRelativeWeight(), rankBo.getMeritThreshold(), topic);
//		rankService.create(rank);
    }

    @Override
    public void updateRank(RankBo rank) {
//		rankService.update(rank);
    }

    @Override
    public void deleteRankById(Long id) {
        rankService.deleteById(id);
    }

    @Override
    public UserBo getUserById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserBo> listUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<UserBo> pageUsers(int page, int size) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createUser(UserBo user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateUser(UserBo user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteUserById(Long id) {
        // TODO Auto-generated method stub

    }


    @Override
    public MessageBo getMessageById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MessageBo> listMessages() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<MessageBo> pageMessages(int page, int size) {
        // TODO Auto-generated method stub
        return null;
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
    public void deleteMessageById(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public NotificationBo getNotificationById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<NotificationBo> listNotifications() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<NotificationBo> pageNotifications(int page, int size) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createNotification(NotificationBo notification) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateNotification(NotificationBo notification) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteNotificationById(Long id) {
        // TODO Auto-generated method stub

    }


    @Override
    public ReportUserBo getReportUserById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ReportUserBo> listReportUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<ReportUserBo> pageReportUsers(int page, int size) {
        // TODO Auto-generated method stub
        return null;
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
    public void deleteReportUserById(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public ReportQuestionBo getReportQuestionById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ReportQuestionBo> listReportQuestions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<ReportQuestionBo> pageReportQuestions(int page, int size) {
        // TODO Auto-generated method stub
        return null;
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
    public void deleteReportQuestionById(Long id) {
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
