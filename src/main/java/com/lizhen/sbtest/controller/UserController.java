package com.lizhen.sbtest.controller;

//import com.lizhen.sbtest.dao.UserDao;
//import com.lizhen.sbtest.entry.User;
import com.lizhen.sbtest.test001.service.UserServiceTest001;
import com.lizhen.sbtest.test002.service.UserServiceTest002;
import com.lizhen.sbtest.service.Userservice;
import com.lizhen.sbtest.test001.dao.UserMapperTest001;
import com.lizhen.sbtest.test002.dao.UserMapperTest002;
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
    private UserServiceTest001 userServiceTest001;
    @Autowired
    private UserServiceTest002  userServiceTest002;
    @Autowired
    private UserMapperTest001 userMapperTest001;
    @Autowired
    private UserMapperTest002 userMapperTest002;
//    @Autowired
//    private UserDao userDao;

    @RequestMapping("/CreateUser")
    public String createuser(int UserId, int GroupId) {
        userservice.createUser(UserId, GroupId);
        return "success";
    }
//
//    @RequestMapping("/getUser")
//    public User getUser(Integer ID) {
//        User one = userDao.findOne(ID);
//        System.out.println(one.toString());
//        return userDao.findOne(ID);
//    }

    //使用test001数据源
    @RequestMapping("/CreateUserTest001")
    public Integer createuserTest001(String name, Integer age) {
        int insert = userServiceTest001.insert(name, age);
        return insert;
    }

    //使用test002数据源
    @RequestMapping("/CreateUserTest002")
    public Integer createuserTest002(String name, Integer age) {
        int insert = userServiceTest002.insert(name, age);
        return insert;
    }
}
