package com.lsy.hardware.api;

import javafx.scene.web.WebErrorEvent;

import java.io.Serializable;

/**
 * @author lishenyue Created on 2021/3/15 0015 14:43
 * @version 1.0
 */
public class WrapperResponse<T> implements Serializable {

    private static final long serialVersionUID = 4230762724693731575L;

    /**
     * 成功状态码
     */
    public static Integer SUCCESS = 0;

    /**
     * 失败状态码
     */
    public static Integer FAIL = -1;

    /**
     * 请求成功默认消息
     */
    public static String MSG_SUCCESS = "成功";

    /**
     * 请求失败默认消息
     */
    public static String MSG_FAIL = "失败";

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String mesage;

    /**
     * 数据
     */
    private T data;

    public WrapperResponse() {
    }

    public WrapperResponse(final Integer code, final String mesage, final T data) {
        this.code = code;
        this.mesage = mesage;
        this.data = data;
    }

    public static <T> WrapperResponse<T> success() {
        return success(null);
    }

    public static <T> WrapperResponse<T> success(T data) {
        return new WrapperResponse(SUCCESS, MSG_SUCCESS, data);
    }

    public static <T> WrapperResponse<T> success(String message, T data) {
        return new WrapperResponse(SUCCESS, message, data);
    }

    public static <T> WrapperResponse<T> fail(T data) {
        return new WrapperResponse(FAIL, MSG_FAIL, data);
    }

    public static <T> WrapperResponse<T> fail(Integer code, String message) {
        return new WrapperResponse(code, message,null);
    }

    public static <T> WrapperResponse<T> fail(String message) {
        return new WrapperResponse(FAIL, message,null);
    }

    public Boolean isSuccess(){
        return SUCCESS.equals(this.code);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(final String mesage) {
        this.mesage = mesage;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }
}
