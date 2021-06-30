package com.naive;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author YechenGu
 * @date 2021/6/28 3:27 下午
 */
@EnableSwagger2Doc
@EnableDiscoveryClient
@MapperScan("com.naive.dao")
@SpringBootApplication
public class QuestionApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuestionApplication.class,args);
    }
}
