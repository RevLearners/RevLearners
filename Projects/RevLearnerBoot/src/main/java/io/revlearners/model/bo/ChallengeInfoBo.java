package io.revlearners.model.bo;

import com.fasterxml.jackson.annotation.JsonView;
import io.revlearners.model.jsonview.Views;

import java.util.List;

public class ChallengeInfoBo {
        @JsonView({Views.ToBackEnd.class})
        private int topicId;

        @JsonView({Views.ToBackEnd.class})
        private long senderId;

        @JsonView({Views.ToBackEnd.class})
        private List<Long> receiverIds;

        @JsonView({Views.ToBackEnd.class})
        private int numQuestions;

        public int getTopicId() {
            return topicId;
        }

        public void setTopicId(int topicId) {
            this.topicId = topicId;
        }

        public long getSenderId() {
            return senderId;
        }

        public void setSenderId(long senderId) {
            this.senderId = senderId;
        }

        public List<Long> getReceiverIds() {
            return receiverIds;
        }

        public void setReceiverIds(List<Long> receiverIds) {
            this.receiverIds = receiverIds;
        }

        public int getNumQuestions() {
            return numQuestions;
        }

        public void setNumQuestions(int numQuestions) {
            this.numQuestions = numQuestions;
        }
    }
