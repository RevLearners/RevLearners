package io.revlearners.model.bean;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;

@Entity
@Table(name=Constants.TABLE_USER_RANK)
public class UserTopicRank implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = -3402953668398433930L;

	@EmbeddedId
    private UserTopicRankTrio id;

    @Column(name=Constants.COLUMN_MERIT)
    private Long merit;

    public UserTopicRank(User user, Rank rank, Topic topic, Long merit) {
        this.id = new UserTopicRankTrio(user, rank, topic);
        this.merit = merit;
    }

    public UserTopicRank() {
    }

    public UserTopicRankTrio getId() {
        return id;
    }

    public void setId(UserTopicRankTrio id) {
        this.id = id;
    }

    public Long getMerit() {
        return merit;
    }

    public void setMerit(Long merit) {
        this.merit = merit;
    }

    @Embeddable
    public static class UserTopicRankTrio implements Serializable {
        /**
		 *
		 */
		private static final long serialVersionUID = -3420765176964284918L;

		@ManyToOne
        @JoinColumn(name=Constants.COLUMN_USER_ID)
        private User user;

        @ManyToOne
        @JoinColumn(name=Constants.COLUMN_RANK_ID)
        private Rank rank;

        @ManyToOne
        @JoinColumn(name=Constants.COLUMN_OPTION_ID)
        private Topic topic;

        public UserTopicRankTrio(User user, Rank rank, Topic topic) {
            this.user = user;
            this.rank = rank;
            this.topic = topic;
        }

        public UserTopicRankTrio() {
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Rank getRank() {
            return rank;
        }

        public void setRank(Rank rank) {
            this.rank = rank;
        }

        public Topic getOption() {
            return topic;
        }

        public void setOption(Topic option) {
            this.topic = option;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof UserTopicRankTrio)) return false;

            UserTopicRankTrio that = (UserTopicRankTrio) o;

            return that.rank.getId().equals(this.rank.getId()) &&
                    that.user.getId().equals(this.user.getId()) &&
                    that.topic.getId().equals(this.topic.getId());
        }

        @Override
        public int hashCode() {
            int result = user != null ? user.hashCode() : 0;
            result = 31 * result + (rank != null ? rank.hashCode() : 0);
            result = 31 * result + (this.topic != null ? this.topic.hashCode() : 0);
            return result;
        }
    }
}
