package com.lsy.hardware.web.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lishenyue Created on 2021/3/2 21:36
 * @version 1.0
 */
@RestController
@RequestMapping("/admin/api")
public class AdminController {

    @GetMapping("/sayHi")
    public String sayHi() {
        return "Hello,admin";
    }
}
