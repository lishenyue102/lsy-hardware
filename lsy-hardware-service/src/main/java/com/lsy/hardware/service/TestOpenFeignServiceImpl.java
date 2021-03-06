package com.lsy.hardware.service;

import com.lsy.hardware.api.TestOpenFeignService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lishenyue Created on 2021/3/5 22:38
 * @version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestOpenFeignServiceImpl implements TestOpenFeignService {

    @Override
    @GetMapping("/get")
    public String test() {
        return "我是openFeign的第一个测试用例";
    }
}
