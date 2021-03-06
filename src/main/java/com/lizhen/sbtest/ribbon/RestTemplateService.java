package com.lizhen.sbtest.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * Created by Administrator on 2018/4/10 0010.
 */
@Service
public class RestTemplateService {
    @Value("${server.port}")
    private String port;
    @Autowired
    private RestTemplate restTemplate;
    //调用8761项目的接口
    @HystrixCommand(fallbackMethod = "hiError")
    public String get8762Test001() {
        System.out.println("================I am "+port);
        return restTemplate.getForObject("http://service-8761/get8761",String.class);
    }
    //调用8763项目的接口
    @HystrixCommand(fallbackMethod = "hiError")
    public String get8762Test002() {
        System.out.println("================I am "+port);
        return restTemplate.getForObject("http://service-8763/get8763Test003",String.class);
    }

    public String hiError() {
        return "I am 8762 ,sorry 8761 error!";
    }
}
