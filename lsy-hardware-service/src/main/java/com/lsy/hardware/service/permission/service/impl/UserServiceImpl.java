package com.lsy.hardware.service.permission.service.impl;

import com.lsy.hardware.service.api.permission.dto.UserDTO;
import com.lsy.hardware.service.api.permission.service.UserService;
import com.lsy.hardware.service.permission.dao.UserDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lishenyue Created on 2021/3/4 0004 16:13
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Override
    public UserDTO getByUsername(String username) {
        return userDAO.getByUsername(username);
    }
}
