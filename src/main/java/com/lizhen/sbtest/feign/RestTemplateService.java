package com.lizhen.sbtest.feign;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/10 0010.
 */
@Service
public class RestTemplateService {
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "hiError")
    public ArrayList<String> getName() {
        return restTemplate.getForObject("http://service-member/getName",ArrayList.class);
    }
    public ArrayList<String> hiError() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hi,sorry,error!");
        return arrayList;
    }
}
