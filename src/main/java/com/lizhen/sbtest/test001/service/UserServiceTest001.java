package com.lizhen.sbtest.test001.service;

import com.lizhen.sbtest.test001.dao.UserMapperTest001;
import com.lizhen.sbtest.test002.dao.UserMapperTest002;
import com.lizhen.sbtest.test002.service.UserServiceTest002;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/4/28 0028.
 */
@Service
@Slf4j
public class UserServiceTest001 {
    @Autowired
    private UserMapperTest001 userMapperTest001;
    @Autowired
    private UserMapperTest002 userMapperTest002;
    @Autowired
    private UserServiceTest002 userServiceTest002;
    @Transactional
    public Integer insert(String name, Integer age) {
        log.info("1创建用户的语句");
        int insert = userMapperTest001.insert(name, age);
        userServiceTest002.insert(name, age);
        Integer insert1 = userMapperTest002.insert(name, age);
        String[] aaa = {"1","2"};
        log.info("测试错误！！！！"+aaa[3]);
        int i = 1 / 0;
        log.info("插入数据成功！！！！");
        return insert;
    }
}
