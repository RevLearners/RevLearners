package io.revlearners.model.bo;

public class LoginInfoBo {
    String token;

    UserBo user;

    public LoginInfoBo(UserBo user, String token) {
        this.token = token;
        this.user = user;
    }

    public LoginInfoBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserBo getUser() {
        return user;
    }

    public void setUser(UserBo user) {
        this.user = user;
    }
}
