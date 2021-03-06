package com.lsy.hardware.service;

import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan(value = {"com.lsy.hardware.**.dao"})
@ImportResource(locations = {"classpath:config/spring.xml"})
@EnableDiscoveryClient
public class LsyHardwareServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsyHardwareServiceApplication.class, args);
    }

}
