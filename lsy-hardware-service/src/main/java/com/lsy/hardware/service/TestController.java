package com.lsy.hardware.service;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lishenyue Created on 2021/3/2 21:36
 * @version 1.0
 */
@RestController
@RequestMapping("/config")
public class TestController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;


    @GetMapping("/test")
    public Boolean test() {
        return useLocalCache;
    }
}
