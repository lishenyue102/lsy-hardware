package com.lsy.hardware.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lishenyue
 * @date 2021/03/03 15:43
 */
@SpringBootApplication(scanBasePackages = "com.lsy.hardware")
//@ImportResource(locations = {"classpath:config/spring.xml"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages= {"com.lsy.hardware"})
public class LsyHardwareWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsyHardwareWebApplication.class, args);
    }

}
