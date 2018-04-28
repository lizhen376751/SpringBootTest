package com.lizhen.sbtest.test001.service;

import com.lizhen.sbtest.test001.dao.UserMapperTest001;
import com.lizhen.sbtest.test002.service.UserServiceTest002;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/4/28 0028.
 */
@Service
public class UserServiceTest001 {
    @Autowired
    private UserMapperTest001 userMapperTest001;
    @Autowired
    private UserServiceTest002 userServiceTest002;
    @Transactional
    public Integer insert(String name, Integer age) {
        System.out.println("1创建用户的语句");
        int insert = userMapperTest001.insert(name, age);
        int i = 1 / 0;
        System.out.println("插入数据成功！！！！");
        return insert;
    }
}
