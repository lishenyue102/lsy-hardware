package com.lsy.hardware.web.configuration.permisson;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lishenyue Created on 2021/3/15 21:55
 * @version 1.0
 */
@Component
@ConfigurationProperties("jwt")
public class JwtProperty {

    /**
     * JWT存储的请求头
     */
    private String tokenHeader;

    /**
     * 秘钥
     */
    private String secret;

    /**
     * 过期时间
     */
    private Long expiration;

    /**
     * 负载中拿到开头
     */
    private String tokenHead;

    /**
     * 白名单
     */
    private List<String> whiteUrlList;

    public String getTokenHeader() {
        return tokenHeader;
    }

    public void setTokenHeader(final String tokenHeader) {
        this.tokenHeader = tokenHeader;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(final String secret) {
        this.secret = secret;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(final Long expiration) {
        this.expiration = expiration;
    }

    public String getTokenHead() {
        return tokenHead;
    }

    public void setTokenHead(final String tokenHead) {
        this.tokenHead = tokenHead;
    }

    public List<String> getWhiteUrlList() {
        return whiteUrlList;
    }

    public void setWhiteUrlList(final List<String> whiteUrlList) {
        this.whiteUrlList = whiteUrlList;
    }
}
