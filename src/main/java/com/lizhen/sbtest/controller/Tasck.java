package com.lizhen.sbtest.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 定时任务测试
 * Created by Administrator on 2018/2/7.
 */
@Component
public class Tasck {

    @Scheduled(fixedRate = 1000)
    public void tasck(){
        System.out.println("打印.........");
    }
}
