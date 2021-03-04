package com.lsy.hardware.service.api.permission.service;

import com.lsy.hardware.service.api.permission.dto.UserDTO;

/**
 * @author lishenyue Created on 2021/3/4 0004 15:22
 * @version 1.0
 */
public interface UserService {

    /**
     * 测试接口
     * @param username
     * @return
     */
    UserDTO getByUsername(String username);
}
