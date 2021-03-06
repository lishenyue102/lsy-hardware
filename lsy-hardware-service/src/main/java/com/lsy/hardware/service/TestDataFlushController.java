package com.lsy.hardware.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author lishenyue Created on 2021/3/2 21:36
 * @version 1.0
 */
@RestController
@RequestMapping("/config")
@RefreshScope // 配置自动刷新
public class TestDataFlushController {

    @Value("${useLocalCache}")
    private boolean useLocalCache;

    @GetMapping("/test")
    public Boolean test() {
        return useLocalCache;
    }
}
