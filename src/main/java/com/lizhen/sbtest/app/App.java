package com.lizhen.sbtest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by lizhen on 2018/2/6.
 * ComponentScan 包扫描的注解
 * SpringBootApplication 注解 启动容器 整合常用注解
 * EnableJpaRepositories JPa注解
 * EnableAsync 异步调用注解
 * EnableScheduling 定时任务注解
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.lizhen.sbtest.controller","com.lizhen.sbtest.service"})
@EnableJpaRepositories("com.lizhen.sbtest.dao")
@EntityScan("com.lizhen.sbtest.entry")
@EnableAutoConfiguration
@EnableAsync
@EnableScheduling
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
}
