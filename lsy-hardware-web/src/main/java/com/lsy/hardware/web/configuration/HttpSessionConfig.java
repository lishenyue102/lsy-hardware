package com.lsy.hardware.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.session.FindByIndexNameSessionRepository;
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

    /**
     * findByIndexNameAndIndexValue 根据用户名反查该用户在线session集合
     */
    @Resource
    private FindByIndexNameSessionRepository sessionRepository;

    /**
     * SpringSessionBackedSessionRegistry是session为
     *
     * @return SpringSessionBackedSessionRegistry
     */
    @Bean
    public SpringSessionBackedSessionRegistry sessionRegistry(){
        return new SpringSessionBackedSessionRegistry(sessionRepository);
    }
}
