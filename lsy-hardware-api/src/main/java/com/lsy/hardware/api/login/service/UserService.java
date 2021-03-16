package com.lsy.hardware.api.login.service;

import com.lsy.hardware.api.login.dto.LoginInDTO;
import com.lsy.hardware.api.login.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lishenyue Created on 2021/3/4 0004 15:22
 * @version 1.0
 */
@FeignClient("lsy-hardware-service")
@RequestMapping("/user")
public interface UserService {

    /**
     * 测试接口
     * @param username
     * @return
     */
    @PostMapping("/getByUsername")
    UserDTO getByUsername(@RequestParam("username") String username);

}
