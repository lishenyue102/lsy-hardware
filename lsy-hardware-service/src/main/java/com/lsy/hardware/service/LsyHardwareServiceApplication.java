package com.lsy.hardware.service;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lishenyue
 * @date 2021/03/03 15:43
 */
@SpringBootApplication
@MapperScan(value = {"com.lsy.hardware.**.dao"})
@ImportResource(locations = {"classpath:config/spring.xml"})
@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class LsyHardwareServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsyHardwareServiceApplication.class, args);
    }

}
