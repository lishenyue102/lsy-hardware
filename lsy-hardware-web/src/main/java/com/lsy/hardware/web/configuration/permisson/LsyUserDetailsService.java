package com.lsy.hardware.web.configuration.permisson;

import com.lsy.hardware.api.login.dto.UserDTO;
import com.lsy.hardware.api.login.service.UserService;
import com.lsy.hardware.service.common.exception.HardwareException;
import com.lsy.hardware.web.login.LUserDetailsImpl;
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
public class LsyUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserDTO userDTO = userService.getByUsername(username);
        if (null == userDTO){
            throw new HardwareException("用户名或密码错误");
        }
        LUserDetailsImpl lUserDetailsImpl = new LUserDetailsImpl();
        BeanUtils.copyProperties(userDTO,lUserDetailsImpl);
        // AuthorityUtils.commaSeparatedStringToAuthorityList是Spring Security提供的用于将逗号分隔的权限字符串分隔为集合
        lUserDetailsImpl.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(lUserDetailsImpl.getRoles()));

        return lUserDetailsImpl;
    }
}
