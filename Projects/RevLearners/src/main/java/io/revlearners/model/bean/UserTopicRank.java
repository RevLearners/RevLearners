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
    private UserOptionRankTrio id;

    @Column(name=Constants.COLUMN_MERIT)
    private Long merit;

    public UserTopicRank(User user, Rank rank, QuestionOption option, Long merit) {
        this.id = new UserOptionRankTrio(user, rank, option);
        this.merit = merit;
    }

    public UserTopicRank() {
    }

    public UserOptionRankTrio getId() {
        return id;
    }

    public void setId(UserOptionRankTrio id) {
        this.id = id;
    }

    public Long getMerit() {
        return merit;
    }

    public void setMerit(Long merit) {
        this.merit = merit;
    }

    @Embeddable
    public static class UserOptionRankTrio implements Serializable {
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
        private QuestionOption option;

        public UserOptionRankTrio(User user, Rank rank, QuestionOption option) {
            this.user = user;
            this.rank = rank;
            this.option = option;
        }

        public UserOptionRankTrio() {
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

        public QuestionOption getOption() {
            return option;
        }

        public void setOption(QuestionOption option) {
            this.option = option;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof UserOptionRankTrio)) return false;

            UserOptionRankTrio that = (UserOptionRankTrio) o;

            return that.rank.getId().equals(this.rank.getId()) &&
                    that.user.getId().equals(this.user.getId()) &&
                    that.option.getId().equals(this.option.getId());
        }

        @Override
        public int hashCode() {
            int result = user != null ? user.hashCode() : 0;
            result = 31 * result + (rank != null ? rank.hashCode() : 0);
            result = 31 * result + (this.option != null ? this.option.hashCode() : 0);
            return result;
        }
    }
}
