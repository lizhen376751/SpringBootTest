package com.lizhen.sbtest;

import com.lizhen.sbtest.datasource.DBConfig1;
import com.lizhen.sbtest.datasource.DBConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lizhen on 2018/2/6.
 * ComponentScan 包扫描的注解
 * SpringBootApplication 注解 启动容器 整合常用注解
 * EnableJpaRepositories JPa注解
 * EnableAsync 异步调用注解
 * EnableScheduling 定时任务注解
 * EnableHystrix注解开启Hystrix
 * EnableDiscoveryClient向服务中心注册
 */
//启动的时候读取配置文件
@EnableConfigurationProperties(value = { DBConfig1.class, DBConfig2.class })
@SpringBootApplication
//@EnableEurekaClient
//@EnableHystrix
//@EnableDiscoveryClient
public class App {
    /**
     * 整个项目最好只有一个main方法不然访问不到，因为这样会有多个入口
     */
    public static void main(String[] args) {
        /**
         * 主函数运行springboot项目
         */
        SpringApplication.run(App.class, args);
    }

    /**
     * 并且向程序的ioc注入一个bean:restTemplate;
     * 并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
