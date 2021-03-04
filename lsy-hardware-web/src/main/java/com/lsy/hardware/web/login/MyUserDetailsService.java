//package com.lsy.hardware.web.login;
//
//import com.lsy.hardware.dao.UserDAO;
//import com.lsy.hardware.entity.User;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
///**
// * @author lishenyue Created on 2021/3/3 0003 16:41
// * @version 1.0
// */
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Resource
//    private UserDAO userDAO;
//
//    @Override
//    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
//        User user = userDAO.getByUsername(username);
//
//        if (null == user){
//            throw new UsernameNotFoundException("用户不存在");
//        }
//        // AuthorityUtils.commaSeparatedStringToAuthorityList是Spring Security提供的用于将逗号分隔的权限字符串分隔为集合
//        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));
//
//        return user;
//    }
//}
