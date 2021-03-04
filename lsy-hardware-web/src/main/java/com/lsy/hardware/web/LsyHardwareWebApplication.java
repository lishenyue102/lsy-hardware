package com.lsy.hardware.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lishenyue
 * @date 2021/03/03 15:43
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:config/spring.xml"})
public class LsyHardwareWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsyHardwareWebApplication.class, args);
    }

}
