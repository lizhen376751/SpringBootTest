package com.lizhen.sbtest.controller;

import com.lizhen.sbtest.service.Userservice;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizhen on 2018/2/6.
 */

/**
 * RestController 注解表示改接口返回的都是json格式的
 * EnableAutoConfiguration 帮你注入spring容器，并启动tomcat容器
 */

@RestController
public class HelloWordController {
    private static Logger log = Logger.getLogger(HelloWordController.class);
    @Autowired
    private Userservice userservice;

    @RequestMapping("/HelloWordController")
    public String index() {
        return "success";
    }

    @RequestMapping("/getMap")
    public Map<String, Object> getMap() {
        log.info("info日至打印测试....................");
        log.debug("debug日至打印测试....................");
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errorcode", 2000);
        result.put("errorMsg", "成功");
        return result;
    }

    /**
     * 异步调用测试
     *
     * @return
     */
    @RequestMapping("yibutest")
    public String yibutest() {
        System.out.println("我是第一");
        userservice.yibutest();
        System.out.println("我是第二");
        return "success";
    }

    /**
     * Value获取的是配置文件的信息
     */
    @Value("${lizhen}")
    private String lizhen;

    /**
     * 测试 获取配置文件信息
     * @return 返回配置文件的内容
     */
    @RequestMapping("/getValue")
    public String getvalue() {
        return lizhen;
    }


}
