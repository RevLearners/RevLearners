
package io.revlearners.model.bean;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = Constants.TABLE_USER_CERTIFICATION)
@AssociationOverrides({
		@AssociationOverride(name = Constants.PK_USER, joinColumns = @JoinColumn(name = Constants.COLUMN_USER_ID)),
		@AssociationOverride(name = Constants.PK_CERTIFICATION, joinColumns = @JoinColumn(name = Constants.COLUMN_CERTIFICATION_ID)) })
public class UserCertification implements Serializable {

	private static final long serialVersionUID = -5568090599034834224L;

	@EmbeddedId
	private UserCertPair pk = new UserCertPair();
	
	public UserCertification(User user, Certification certification) {
		setUser(user);
		setCertification(certification);
	}

	public UserCertification() {
	}

	public UserCertPair getId() {
		return pk;
	}

	public void setId(UserCertPair userCertKey) {
		this.pk = userCertKey;
	}

	@Transient
	public User getUser() {
		return pk.user;
	}

	public void setUser(User user) {
		pk.user = user;
	}

	@Transient
	public Certification getCertification() {
		return pk.certification;
	}
	
	public void setCertification(Certification cert) {
		pk.certification = cert;
	}

	@Embeddable
	private static class UserCertPair implements Serializable {

		private static final long serialVersionUID = 4724550790684214251L;

		@ManyToOne
		@JoinColumn(name = Constants.COLUMN_USER_ID)
		private User user;

		@ManyToOne
		@JoinColumn(name = Constants.COLUMN_CERTIFICATION_ID)
		private Certification certification;

		public UserCertPair() {
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof UserCertPair))
				return false;

			UserCertPair that = (UserCertPair) o;

			return this.user.getId().equals(that.user.getId())
					&& this.certification.getId().equals(that.certification.getId());
		}

		@Override
		public int hashCode() {
			int result = user != null ? user.hashCode() : 0;
			result = 31 * result + (certification != null ? certification.hashCode() : 0);
			return result;
		}
	}
}
