package com.lsy.hardware.api.permission.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lishenyue Created on 2021/3/4 0004 15:21
 * @version 1.0
 */
@Data
public class UserDTO implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String roles;
    private Boolean enable;
    private Date createTime;
    private Date modifyTime;

}
