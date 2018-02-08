package com.lizhen.sbtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lizhen on 2018/2/6.
 */
@Controller
public class IndexController {
    @RequestMapping("/IndexController")
    public String index(Map<String, Object> result) {
        System.out.println("index .......");

        result.put("name", "李振");
        result.put("sex", 0);

        List list = new ArrayList();
        list.add("zhangsan");
        list.add("lisi");

        result.put("user", list);
        return "index";
    }
}
