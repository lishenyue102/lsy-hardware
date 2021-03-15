package com.lsy.hardware.api.login.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author lishenyue Created on 2021/3/15 20:45
 * @version 1.0
 */
@Getter
@Setter
public class LoginInDTO implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
