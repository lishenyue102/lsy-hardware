package com.lsy.hardware.web.configuration;


import org.springframework.context.annotation.Bean;

import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.FindByIndexNameSessionRepository;

import org.springframework.session.data.redis.RedisIndexedSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 *
 *
 * @author lishenyue Created on 2021/3/8 22:20
 * @version 1.0
 */
@EnableRedisHttpSession
public class HttpSessionConfig {

    /**
     * httpSession的事件监听，改用session提供的会话注册表
     *
     * @return
     */
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher(){
        return new HttpSessionEventPublisher();
    }

}
