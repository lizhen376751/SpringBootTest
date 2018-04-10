package com.lizhen.sbtest.feign;

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

    @RequestMapping("/getOrderUserAll")
    public List<String> getOrderUserAll() {
        System.out.println("订单服务开始调用会员服务");
        return restTemplateService.getName();
    }
    @RequestMapping("/getOrderServiceApi")
    public String getOrderServiceApi(){
        return "this is feign 服务工程";
    }
}
