package io.revlearners.model.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user_certification")
public class UserCertification implements Serializable {
    @EmbeddedId
    private UserCertPair id;

    @OneToOne
    @JoinColumn(name="BLOB_ID")
    private FileBlob file;

    public UserCertification(User user, Certification certification, FileBlob file) {
        this.id = new UserCertPair(user, certification);
        this.file = file;
    }

    public UserCertification(User user, Certification certification) {
        this.id = new UserCertPair(user, certification);
        this.file = file;
    }

    public UserCertification() {
    }

    public UserCertPair getId() {
        return id;
    }

    public void setId(UserCertPair userCertKey) {
        this.id = userCertKey;
    }

    public FileBlob getFile() {
        return file;
    }

    public void setFile(FileBlob file) {
        this.file = file;
    }



    @Embeddable
    public static class UserCertPair implements Serializable {
        @ManyToOne
        @JoinColumn(name="USER_ID")
        private User user;

        @ManyToOne
        @JoinColumn(name="CERTIFICATION_ID")
        private Certification certification;

        public UserCertPair(User user, Certification certification) {
            this.user = user;
            this.certification = certification;
        }

        public UserCertPair() {}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof UserCertPair)) return false;

            UserCertPair that = (UserCertPair) o;

            return this.user.getId().equals(that.user.getId()) &&
                   this.certification.getId().equals(that.certification.getId());
        }
        @Override
        public int hashCode() {
            int result = user != null ? user.hashCode() : 0;
            result = 31 * result + (certification != null ? certification.hashCode() : 0);
            return result;
        }
    }
}

