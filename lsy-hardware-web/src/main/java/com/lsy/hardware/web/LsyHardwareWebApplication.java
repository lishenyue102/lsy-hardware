package com.lsy.hardware.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lishenyue
 * @date 2021/03/03 15:43
 */
@SpringBootApplication
@MapperScan(value = {"com.lsy.hardware.**.dao"})
public class LsyHardwareWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsyHardwareWebApplication.class, args);
    }

}
