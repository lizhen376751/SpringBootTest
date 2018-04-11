package com.lizhen.sbtest.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/10 0010.
 */
@Service
public class RestTemplateService {
    @Value("${server.port}")
    private String port;
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "hiError")
    public String getName() {
        System.out.println("================I am "+port);
        return restTemplate.getForObject("http://service-8761/get8761",String.class);
    }
    public String hiError() {
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("hi,sorry,error!");
        return "I am 8762 ,sorry 8761 error!";
    }
}
