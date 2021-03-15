package com.lsy.hardware.api.login.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author lishenyue Created on 2021/3/15 20:47
 * @version 1.0
 */
@Getter
@Setter
public class LoginOutDTO implements Serializable {

    /**
     * 令牌
     */
    private String token;
}
