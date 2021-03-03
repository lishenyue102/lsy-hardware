package com.lsy.hardware.web.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author lishenyue Created on 2021/3/2 21:50
 * @version 1.0
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/api/**").hasRole("admin")
                .antMatchers("/user/api/**").hasRole("user")
                .antMatchers("app/api/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
    }
}
