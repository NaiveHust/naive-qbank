package com.naive;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author YechenGu
 * @date 2021/6/28 4:08 下午
 */
@EnableSwagger2Doc
@EnableDiscoveryClient
@MapperScan("com.naive.dao")
@SpringBootApplication
@EnableFeignClients
public class PaperApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaperApplication.class,args);
    }
}
