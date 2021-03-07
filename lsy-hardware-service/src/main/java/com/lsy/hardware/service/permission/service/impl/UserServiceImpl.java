package com.lsy.hardware.service.permission.service.impl;

import com.lsy.hardware.api.permission.dto.UserDTO;
import com.lsy.hardware.api.permission.service.UserService;
import com.lsy.hardware.service.permission.dao.UserDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lishenyue Created on 2021/3/4 0004 16:13
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Override
    @PostMapping("/getByUsername")
    public UserDTO getByUsername(String username) {
        return userDAO.getByUsername(username);
    }
}
