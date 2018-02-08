package com.lizhen.sbtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/2/6.
 */
@Service
public class Userservice {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createUser(int UserId, int GroupId) {
        System.out.println("创建用户的语句");
        jdbcTemplate.update(" INSERT INTO ZMT_User_UserGroup VALUES (?,?)", UserId, GroupId);
        System.out.println("插入数据成功！！！！");
    }

    /**
     * 测试异步调用的方法
     * Async 注解用于异步调用的方式
     */
    @Async
    public void yibutest() {
        System.out.println("我是第三");
        for (int i = 0; i < 5; i++) {
            System.out.println("我是I:" + i);
        }
        System.out.println("我是第三");
    }


}
