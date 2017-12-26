
package io.revlearners.model.bo;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;
import java.util.Set;


public class UserCertificationBo {

    private UserCertPair pk = new UserCertPair();

    private Set<FileBlobBo> blobs;

    private RequestStatusBo status;


    public UserCertificationBo() {
    }

    public UserCertificationBo(UserBo user, CertificationBo certification) {
        setUser(user);
        setCertification(certification);
    }

    public UserCertificationBo(UserBo user, CertificationBo certification, RequestStatusBo requestStatus) {
        this.pk.user = user;
        this.pk.certification = certification;
        this.status = requestStatus;
    }

    public UserCertPair getId() {
        return pk;
    }

    public void setId(UserCertPair userCertKey) {
        this.pk = userCertKey;
    }

    public UserBo getUser() {
        return pk.user;
    }

    public void setUser(UserBo user) {
        pk.user = user;
    }

    @Transient
    public CertificationBo getCertification() {
        return pk.certification;
    }

    public void setCertification(CertificationBo cert) {
        pk.certification = cert;
    }

    public UserCertPair getPk() {
        return pk;
    }

    public void setPk(UserCertPair pk) {
        this.pk = pk;
    }

    public Set<FileBlobBo> getBlobs() {
        return blobs;
    }

    public void setBlobs(Set<FileBlobBo> blob) {
        this.blobs = blob;
    }

    public RequestStatusBo getStatus() {
        return status;
    }

    public void setStatus(RequestStatusBo status) {
        this.status = status;
    }

    @Embeddable
    private static class UserCertPair {

        private static final long serialVersionUID = 4724550790684214251L;

        @ManyToOne
        @JoinColumn(name = Constants.COLUMN_USER_ID)
        private UserBo user;

        @ManyToOne
        @JoinColumn(name = Constants.COLUMN_CERTIFICATION_ID)
        private CertificationBo certification;

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
