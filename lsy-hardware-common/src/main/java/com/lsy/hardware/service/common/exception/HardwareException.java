package com.lsy.hardware.service.common.exception;

import cn.hutool.core.util.StrUtil;
import com.lsy.hardware.service.common.enums.WebErrorCode;


/**
 * @author lishenyue Created on 2021/3/16 0016 11:24
 * @version 1.0
 */
public class HardwareException extends RuntimeException {
    private static final long serialVersionUID = -992723846875030064L;

    int code = -1;

    public HardwareException() {
    }

    public HardwareException(int code) {
        super();
        this.code = code;
    }

    public HardwareException(WebErrorCode webErrorCode, String... dynaValues) {
        super(getMessage(webErrorCode, dynaValues));
        this.code = webErrorCode.getCode();
    }

    public HardwareException(String message) {
        super(message);
    }

    public HardwareException(int code, String message) {
        super(message);
        this.code = code;
    }

    public HardwareException(Throwable cause) {
        super(cause);
    }

    public HardwareException(String message, Throwable cause) {
        super(message, cause);
    }

    public HardwareException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    /**
     * 获取动态的错误信息
     *
     * @param webErrorCode 错误码枚举
     * @param dynaValues   动态数组
     * @return 错误信息
     */
    public static final String getMessage(WebErrorCode webErrorCode, String... dynaValues) {
        String oriMessage = webErrorCode.getMessage();
        String value = oriMessage;
        for (int i = 0; i < dynaValues.length; i++) {
            String dynaValue = dynaValues[i];
            value = StrUtil.replace(value, "{" + i + "}", dynaValue);
        }
        return value;
    }
}
