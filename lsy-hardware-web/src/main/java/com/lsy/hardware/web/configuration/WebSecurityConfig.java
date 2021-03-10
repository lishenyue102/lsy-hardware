package com.lsy.hardware.web.configuration;

import com.lsy.hardware.web.login.LsyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.data.redis.RedisIndexedSessionRepository;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;

import javax.annotation.Resource;

/**
 * @author lishenyue Created on 2021/3/2 21:50
 * @version 1.0
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private LsyUserDetailsService LsyUserDetailsService;

    @Resource
    private SpringSessionBackedSessionRegistry redisSessionRegistry;


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                .antMatchers("app/api/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .sessionManagement()
                .maximumSessions(1)
                .sessionRegistry(redisSessionRegistry);
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        //注入userDetailsService的实现类
        auth.userDetailsService(LsyUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }


}
