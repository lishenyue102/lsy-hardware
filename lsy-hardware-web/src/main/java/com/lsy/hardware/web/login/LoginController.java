package com.lsy.hardware.web.login;

import com.lsy.hardware.api.WrapperResponse;
import com.lsy.hardware.api.login.dto.LoginInDTO;
import com.lsy.hardware.api.login.dto.LoginOutDTO;
import com.lsy.hardware.api.login.dto.UserDTO;
import com.lsy.hardware.api.login.service.UserService;
import com.lsy.hardware.service.common.enums.WebErrorCode;
import com.lsy.hardware.service.common.exception.HardwareException;
import com.lsy.hardware.web.configuration.permisson.JwtTokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lishenyue Created on 2021/3/15 20:33
 * @version 1.0
 */
@RestController
public class LoginController {

    @Resource
    private UserService userService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public WrapperResponse<LoginOutDTO> login(@RequestBody LoginInDTO loginInDTO) {
        UserDTO userDTO = userService.getByUsername(loginInDTO.getUsername());
        if (null == userDTO) {
            throw new HardwareException(WebErrorCode.E_10001);
        }
        if (!passwordEncoder.matches(loginInDTO.getPassword(), userDTO.getPassword())) {
            throw new HardwareException(WebErrorCode.E_10001);
        }

        LUserDetailsImpl lUserDetailsImpl = new LUserDetailsImpl();
        BeanUtils.copyProperties(userDTO, lUserDetailsImpl);

        if (!lUserDetailsImpl.getEnable()) {
            throw new HardwareException(WebErrorCode.E_10002);
        }

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(lUserDetailsImpl
                , null, lUserDetailsImpl.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(lUserDetailsImpl);
        LoginOutDTO loginOutDTO = new LoginOutDTO();
        loginOutDTO.setToken(token);
        return WrapperResponse.success(loginOutDTO);
    }
}
