package com.lsy.hardware.web.configuration.permisson;

import cn.hutool.json.JSONUtil;
import com.lsy.hardware.api.WrapperResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * 自定义返回结果：未登录或登录过期
 * Created by macro on 2018/5/14.
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // 指定允许其他域名访问，一般指定为nginx的服务器，不要*
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(WrapperResponse.fail(HttpURLConnection.HTTP_UNAUTHORIZED,
                authException.getMessage())));
        response.getWriter().flush();
    }
}