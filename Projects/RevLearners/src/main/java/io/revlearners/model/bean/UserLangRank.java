package io.revlearners.model.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user_rank")
public class UserLangRank implements Serializable {

    @EmbeddedId
    private UserLangRankTrio userLangRankTrio;

    @Column(name="merit")
    private long merit;


    @Embeddable
    public static class UserLangRankTrio implements Serializable {
        private User user;

        private Rank rank;

        private Language language;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof UserLangRankTrio)) return false;

            UserLangRankTrio that = (UserLangRankTrio) o;

            return that.rank.getId() == rank.getId() &&
                    that.user.getId() == user.getId() &&
                    that.language.getId() == language.getId();
        }

        @Override
        public int hashCode() {
            int result = user != null ? user.hashCode() : 0;
            result = 31 * result + (rank != null ? rank.hashCode() : 0);
            result = 31 * result + (language != null ? language.hashCode() : 0);
            return result;
        }
    }
}
