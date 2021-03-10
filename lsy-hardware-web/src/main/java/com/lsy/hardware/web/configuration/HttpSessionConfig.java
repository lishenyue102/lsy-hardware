package com.lsy.hardware.web.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;

import javax.annotation.Resource;

/**
 *
 *
 * @author lishenyue Created on 2021/3/8 22:20
 * @version 1.0
 */
@EnableRedisHttpSession
public class HttpSessionConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        return new LettuceConnectionFactory();
    }

    /**
     * httpSession的事件监听，改用session提供的会话注册表
     *
     * @return
     */
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher(){
        return new HttpSessionEventPublisher();
    }

    /**
     * findByIndexNameAndIndexValue 根据用户名反查该用户在线session集合
     */
    @Autowired
    private FindByIndexNameSessionRepository sessionRepository;

    /**
     * SpringSessionBackedSessionRegistry是session为Spring Security提供的
     * 用于在集群环境下控制会话并发的会话注册表实现类
     *
     * @return SpringSessionBackedSessionRegistry
     */
    @Bean
    public SpringSessionBackedSessionRegistry sessionRegistry(){
        return new SpringSessionBackedSessionRegistry(sessionRepository);
    }
}
