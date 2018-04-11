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

    @RequestMapping("/get8762")
    public String getOrderUserAll() {
        System.out.println("订单服务开始调用会员服务");
        return restTemplateService.getName();
    }

}
