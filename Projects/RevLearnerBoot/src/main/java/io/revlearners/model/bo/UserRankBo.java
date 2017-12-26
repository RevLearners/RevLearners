package io.revlearners.model.bo;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;

public class UserRankBo {

	private UserRankPair pk = new UserRankPair();
	private Long merit;
	
	public UserRankBo() {
	}

	public UserRankBo(UserBo user, RankBo rank, Long merit) {
		this.pk = new UserRankPair(user, rank);
		this.merit = merit;
	}

	public UserRankPair getPk() {
		return pk;
	}

	public void setPk(UserRankPair id) {
		this.pk = id;
	}

	public UserBo getUser() {
		return pk.user;
	}

	public void setUser(UserBo user) {
		pk.user = user;
	}

	@Transient
	public RankBo getRank() {
		return pk.rank;
	}

	public void setRank(RankBo rank) {
		pk.rank = rank;
	}

	public Long getMerit() {
		return merit;
	}

	public void setMerit(Long merit) {
		this.merit = merit;
	}

	@Embeddable
	public static class UserRankPair {

		private static final long serialVersionUID = -3420765176964284918L;

		private UserBo user;

		private RankBo rank;

		public UserRankPair(UserBo user, RankBo rank) {
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
