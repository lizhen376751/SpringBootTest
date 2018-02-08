package com.lizhen.sbtest.controller;

import com.lizhen.sbtest.dao.UserDao;
import com.lizhen.sbtest.entry.User;
import com.lizhen.sbtest.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/2/7.
 */
@RestController
public class UserController {
    @Autowired
    private Userservice userservice;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/CreateUser")
    public String createuser(int UserId, int GroupId) {
        userservice.createUser(UserId, GroupId);
        return "success";
    }

    @RequestMapping("/getUser")
    public User getUser(Integer ID) {
        User one = userDao.findOne(ID);
        System.out.println(one.toString());
        return userDao.findOne(ID);
    }
}
