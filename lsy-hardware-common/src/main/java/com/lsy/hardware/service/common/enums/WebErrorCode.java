package com.lsy.hardware.service.common.enums;

/**
 * 前两位系统编号：后三位自增错误码
 *
 * @author lishenyue Created on 2021/3/16 0016 10:32
 * @version 1.0
 */
public enum WebErrorCode {
    E_10001(10001,"用户密码错误"),
    E_10002(10002,"账户已冻结");


    private Integer code;
    private String message;

    WebErrorCode(final Integer code, final String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

}
