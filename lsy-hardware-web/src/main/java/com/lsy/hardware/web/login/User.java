//package com.lsy.hardware.web.login;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
///**
// * @author lishenyue Created on 2021/3/3 20:03
// * @version 1.0
// */
//public class User implements UserDetails {
//
//    private Integer id;
//    private String username;
//    private String password;
//    private String roles;
//    private Boolean enable;
//    private List<GrantedAuthority> authorities;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.enable;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(final Integer id) {
//        this.id = id;
//    }
//
//    public void setUsername(final String username) {
//        this.username = username;
//    }
//
//    public void setPassword(final String password) {
//        this.password = password;
//    }
//
//    public String getRoles() {
//        return roles;
//    }
//
//    public void setRoles(final String roles) {
//        this.roles = roles;
//    }
//
//    public Boolean getEnable() {
//        return enable;
//    }
//
//    public void setEnable(final Boolean enable) {
//        this.enable = enable;
//    }
//
//    public void setAuthorities(final List<GrantedAuthority> authorities) {
//        this.authorities = authorities;
//    }
//}
