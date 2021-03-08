package com.lsy.hardware.web.test;

import com.lsy.hardware.api.TestOpenFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lishenyue Created on 2021/3/5 23:19
 * @version 1.0
 */
@RestController
@RequestMapping("/testOpenFeign")
public class TestOpenFeignController {

    @Resource
    private TestOpenFeignService testOpenFeignService;


    @GetMapping("/get")
    public String get() {
        return testOpenFeignService.test();
    }
}
