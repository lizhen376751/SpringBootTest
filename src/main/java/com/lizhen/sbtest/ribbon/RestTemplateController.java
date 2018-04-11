package com.lizhen.sbtest.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lizhen on 2018/4/10 0010.
 */
@RestController
public class RestTemplateController {
    @Autowired
    private RestTemplateService restTemplateService;

    //调用8761项目的接口
    @RequestMapping("/get8762Test001")
    public String get8762Test001() {
        System.out.println("订单服务开始调用会员服务");
        return restTemplateService.get8762Test001();
    }
    //调用8763项目接口
    @RequestMapping("/get8762Test002")
    public String get8762Test002() {
        System.out.println("订单服务开始调用会员服务");
        return restTemplateService.get8762Test002();
    }

    //暴露本项目接口
    @RequestMapping("/get8762Test003")
    public String get8763Name() {
        System.out.println("订单服务开始调用会员服务");
        return "I am 8762 ,you like me！";
    }


}
