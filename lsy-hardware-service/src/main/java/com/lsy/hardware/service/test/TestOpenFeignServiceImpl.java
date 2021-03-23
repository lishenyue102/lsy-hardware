package com.lsy.hardware.service.test;

import com.lsy.hardware.api.test.TestOpenFeignService;
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "我是openFeign的第一个测试用例";
    }
}
