package com.lsy.hardware.web.exception;

import com.lsy.hardware.api.WrapperResponse;
import com.lsy.hardware.service.common.exception.HardwareException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lishenyue Created on 2021/3/16 0016 11:26
 * @version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = HardwareException.class)
    @ResponseBody
    public <T> WrapperResponse<T> hardwareExceptionHandler(HardwareException e) {
        logger.error("发生异常！错误码：{}， 原因是：{}", e.getCode(), e.getMessage());
        return WrapperResponse.fail(e.getCode(), e.getMessage());
    }

    /**
     * 处理自定义的业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public <T> WrapperResponse<T> exceptionHandler(Exception e) {
        logger.error("发生异常! 原因是：{}", e.getMessage());
        return WrapperResponse.fail("内部服务器错误");
    }
}
