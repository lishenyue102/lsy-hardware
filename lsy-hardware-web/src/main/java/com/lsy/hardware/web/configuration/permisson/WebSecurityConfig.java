package com.lsy.hardware.web.configuration.permisson;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @author lishenyue Created on 2021/3/2 21:50
 * @version 1.0
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private LsyUserDetailsService lsyUserDetailsService;

    @Resource
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Resource
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Resource
    private JwtProperty jwtProperty;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
                .authorizeRequests();

        for (final String whiteUrl : jwtProperty.getWhiteUrlList()) {
            registry.antMatchers(whiteUrl).permitAll();
        }

        //允许跨域请求的OPTIONS请求
        registry.antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest()
                .authenticated()
                // 关闭跨站请求防护及不使用session
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                /*
                    自定义权限拒绝处理类
                    AuthenticationEntryPoint 用来解决匿名用户访问无权限资源时的异常
                    AccessDeineHandler 用来解决认证过的用户访问无权限资源时的异常
                 */
                .and()
                .exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint)

                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        //注入userDetailsService的实现类
        auth.userDetailsService(lsyUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
