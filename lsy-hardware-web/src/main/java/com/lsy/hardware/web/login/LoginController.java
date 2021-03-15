package com.lsy.hardware.web.login;

import com.lsy.hardware.api.WrapperResponse;
import com.lsy.hardware.api.login.dto.LoginInDTO;
import com.lsy.hardware.api.login.dto.LoginOutDTO;
import com.lsy.hardware.api.login.service.LoginService;
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
    private LoginService loginService;

    @PostMapping("/login")
    public WrapperResponse<LoginOutDTO> login(@RequestBody LoginInDTO loginInDTO){
        LoginOutDTO loginOutDTO = new LoginOutDTO();
        loginOutDTO.setToken("爷就是token");
        return  WrapperResponse.success(loginOutDTO);
    }
}
