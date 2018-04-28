package com.lizhen.sbtest.test002.service;

import com.lizhen.sbtest.test002.dao.UserMapperTest002;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/4/28 0028.
 */
@Service
public class UserServiceTest002 {
    @Autowired
    private UserMapperTest002 userMapperTest002;

    @Transactional
    public Integer insert(String name, Integer age) {
        System.out.println("2创建用户的语句");
        int insert2 = userMapperTest002.insert(name, age);
        int i = 1 / 0;
        System.out.println("插入数据成功！！！！");
        return insert2;
    }
}
