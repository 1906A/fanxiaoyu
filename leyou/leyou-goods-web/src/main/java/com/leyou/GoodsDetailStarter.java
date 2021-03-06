package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient //注册到注册中心
@EnableFeignClients  //开启远程调用
public class GoodsDetailStarter {
    public static void main(String[] args) {
        SpringApplication.run(GoodsDetailStarter.class,args);
    }
}
