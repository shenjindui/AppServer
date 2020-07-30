package com.xingcheng.appserver.mapper;

import com.xingcheng.appserver.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class IUserMapperTest {

    @Autowired IUserMapper userMapper;
    @Test
    void selectById() {
        /*User u = new User();
        u.setId(1);*/
        User user = userMapper.selectById(1);
    }
}