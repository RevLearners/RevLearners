package io.revlearners.model.bo;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.revlearners.util.commons.configs.Constants;

public class UserBo implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 9102984883242741488L;

    Collection<GrantedAuthority> auths;

    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String username;

    private String password;

    private UserStatusBo status;

    private UserRoleBo role;

    private Set<UserRankBo> ranks;

    private LocalDateTime lastPasswordReset;


    public UserBo(Long id, String firstName, String middleName, String lastName, String email,
                  String username, String password, LocalDateTime lastPasswordReset, UserStatusBo status,
                  UserRoleBo role, Set<UserRankBo> ranks, Set<String> permissions) {

        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.status = status;
        this.role = role;
        this.ranks = ranks;
        this.lastPasswordReset = lastPasswordReset;
        this.permissions = permissions;
    }

    public UserBo() {
    }

    public LocalDateTime getLastPasswordReset() {
        return lastPasswordReset;
    }

    public void setLastPasswordReset(LocalDateTime lastPasswordReset) {
        this.lastPasswordReset = lastPasswordReset;
    }

    private Set<String> permissions;

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<GrantedAuthority> getAuths() {
        return auths;
    }

    public void setAuths(Collection<GrantedAuthority> auths) {
        this.auths = auths;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserStatusBo getStatus() {
        return status;
    }

    public void setStatus(UserStatusBo status) {
        this.status = status;
    }

    public UserRoleBo getRole() {
        return role;
    }

    public void setRole(UserRoleBo role) {
        this.role = role;
    }

    public Set<UserRankBo> getRanks() {
        return ranks;
    }

    public void setRanks(Set<UserRankBo> ranks) {
        this.ranks = ranks;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return auths;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status.getId().equals(Constants.STATUS_OK);
    }
}
