package io.revlearners.model.bean;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;
import io.revlearners.model.jsonview.Views;
import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;

@Entity
@Table(name = Constants.TABLE_USER_RANK)
@AssociationOverrides({
		@AssociationOverride(name = Constants.PK_USER, joinColumns = @JoinColumn(name = Constants.COLUMN_USER_ID)),
		@AssociationOverride(name = Constants.PK_RANK, joinColumns = @JoinColumn(name = Constants.COLUMN_RANK_ID)) })
public class UserRank implements Serializable {

	private static final long serialVersionUID = -3402953668398433930L;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
	@EmbeddedId
	private UserRankPair pk = new UserRankPair();

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
	@Column(name = Constants.COLUMN_MERIT)
	private Long merit;

	public UserRank() {
	}

	public UserRank(User user, Rank rank, Long merit) {
		this.pk = new UserRankPair(user, rank);
		this.merit = merit;
	}

	public UserRankPair getPk() {
		return pk;
	}

	public void setPk(UserRankPair id) {
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
	public static class UserRankPair implements Serializable {

		private static final long serialVersionUID = -3420765176964284918L;

		@ManyToOne
		@JoinColumn(name = Constants.COLUMN_USER_ID)
		private User user;

        @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
		@ManyToOne
		@JoinColumn(name = Constants.COLUMN_RANK_ID)
		private Rank rank;

		public UserRankPair(User user, Rank rank) {
			this.user = user;
			this.rank = rank;
		}

		public UserRankPair() {
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof UserRankPair))
				return false;

			UserRankPair that = (UserRankPair) o;

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
