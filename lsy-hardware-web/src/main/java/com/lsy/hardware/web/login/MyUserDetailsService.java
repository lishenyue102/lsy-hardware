package com.lsy.hardware.web.login;

import com.lsy.hardware.api.permission.dto.UserDTO;
import com.lsy.hardware.api.permission.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lishenyue Created on 2021/3/3 0003 16:41
 * @version 1.0
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserDTO userDTO = userService.getByUsername(username);
        if (null == userDTO){
            throw new UsernameNotFoundException("用户不存在");
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        // AuthorityUtils.commaSeparatedStringToAuthorityList是Spring Security提供的用于将逗号分隔的权限字符串分隔为集合
        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));

        return user;
    }
}
