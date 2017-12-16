package io.revlearners.model.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user_certification")
public class UserCertification implements Serializable {
    @EmbeddedId
    private UserCertPair userCertKey;

    @Column(name="certification_file")
    private FileBlob file;

    public UserCertification(UserCertPair userCertKey, FileBlob file) {
        this.userCertKey = userCertKey;
        this.file = file;
    }

    public UserCertification(User user, Certification certification, FileBlob file) {
        this.userCertKey = new UserCertPair(user, certification);
        this.file = file;
    }

    public UserCertification(User user, Certification certification) {
        this.userCertKey = new UserCertPair(user, certification);
        this.file = file;
    }

    public UserCertification() {
    }

    public UserCertPair getUserCertKey() {
        return userCertKey;
    }

    public void setUserCertKey(UserCertPair userCertKey) {
        this.userCertKey = userCertKey;
    }

    public FileBlob getFile() {
        return file;
    }

    public void setFile(FileBlob file) {
        this.file = file;
    }



    @Embeddable
    public static class UserCertPair implements Serializable {
        User user;
        Certification certification;

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

            return this.user.getId() == that.user.getId() &&
                   this.certification.getId() == that.certification.getId();
        }
        @Override
        public int hashCode() {
            int result = user != null ? user.hashCode() : 0;
            result = 31 * result + (certification != null ? certification.hashCode() : 0);
            return result;
        }
    }
}

