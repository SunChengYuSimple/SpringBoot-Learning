package com.didispace.chapter33;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@Slf4j
@RunWith (SpringRunner.class)
@SpringBootTest
public class Chapter33ApplicationTests {
    
    @Autowired
    private UserService userSerivce;
    
    @Autowired
    private DataSource dataSource;
    
    @Before
    public void setUp() {
        // 准备，清空user表
        userSerivce.deleteAllUsers();
        
    }
    
    @Test
    public void test() throws Exception {
        // 插入5个用户
        userSerivce.create("Tom", 10);
        userSerivce.create("Mike", 11);
        userSerivce.create("Didispace", 30);
        userSerivce.create("Oscar", 21);
        userSerivce.create("Linda", 17);
        
        // 查询名为Oscar的用户，判断年龄是否匹配
        List<User> userList = userSerivce.getByName("Oscar");
        Assert.assertEquals(21, userList.get(0).getAge().intValue());
        
        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userSerivce.getAllUsers());
        
        // 删除两个用户
        userSerivce.deleteByName("Tom");
        userSerivce.deleteByName("Mike");
        
        // 查数据库，应该有5个用户
        Assert.assertEquals(3, userSerivce.getAllUsers());
        
    }
    
}
