package com.lsy.hardware.api.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lishenyue Created on 2021/3/5 22:35
 * @version 1.0
 */
@FeignClient("lsy-hardware-service")
@RequestMapping("/test")
public interface TestOpenFeignService {

    @GetMapping("/get")
    String test();
}
