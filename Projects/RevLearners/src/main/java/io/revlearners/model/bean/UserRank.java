package io.revlearners.model.bean;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;

@Entity
@Table(name = Constants.TABLE_USER_RANK)
@AssociationOverrides({
		@AssociationOverride(name = Constants.PK_USER, joinColumns = @JoinColumn(name = Constants.COLUMN_USER_ID)),
		@AssociationOverride(name = Constants.PK_RANK, joinColumns = @JoinColumn(name = Constants.COLUMN_RANK_ID)) })
public class UserRank implements Serializable {

	private static final long serialVersionUID = -3402953668398433930L;

	@EmbeddedId
	private UserTopicRankPair pk;

	@Column(name = Constants.COLUMN_MERIT)
	private Long merit;
	
	public UserRank() {
		
	}

	public UserRank(User user, Rank rank, Long merit) {
		this.pk = new UserTopicRankPair(user, rank);
		this.merit = merit;
	}

	public UserTopicRankPair getPk() {
		return pk;
	}

	public void setPk(UserTopicRankPair id) {
		this.pk = id;
	}

	@Transient
	public User getUser() {
		return pk.user;
	}

	public void setUser(User user) {
		pk.user = user;
	}

	@Transient
	public Rank getRank() {
		return pk.rank;
	}

	public void setRank(Rank rank) {
		pk.rank = rank;
	}

	public Long getMerit() {
		return merit;
	}

	public void setMerit(Long merit) {
		this.merit = merit;
	}

	@Embeddable
	public static class UserTopicRankPair implements Serializable {

		private static final long serialVersionUID = -3420765176964284918L;

		@ManyToOne
		@JoinColumn(name = Constants.COLUMN_USER_ID)
		private User user;

		@ManyToOne
		@JoinColumn(name = Constants.COLUMN_RANK_ID)
		private Rank rank;

		public UserTopicRankPair(User user, Rank rank) {
			this.user = user;
			this.rank = rank;
		}

		public UserTopicRankPair() {
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof UserTopicRankPair))
				return false;

			UserTopicRankPair that = (UserTopicRankPair) o;

			return that.rank.getId().equals(this.rank.getId()) && that.user.getId().equals(this.user.getId());
		}

		@Override
		public int hashCode() {
			int result = user != null ? user.hashCode() : 0;
			result = 31 * result + (rank != null ? rank.hashCode() : 0);
			return result;
		}
	}
}
