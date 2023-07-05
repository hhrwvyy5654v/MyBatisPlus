package com.example.mybatisplus;

import com.example.mybatisplus.pojo.User;
import com.example.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: mybatisplus
 * @Package: com.example.mybatisplus
 * @ClassName: MyBatisPlusServiceTest
 * @Datetime: 2023/06/01 11:30
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 一个使用 MyBatis Plus 进行数据库操作的测试类
 */

@SpringBootTest // 注解表示这是一个 Spring Boot 的集成测试类，它会加载整个应用程序的上下文

public class MyBatisPlusServiceTest {
    // 注解用于自动注入 UserService 对象，它是一个自定义的服务类，用于执行数据库操作
    @Autowired
    private UserService userService;

    @Test
    // 演示了如何使用 MyBatis Plus 的服务类查询总记录数
    public void testGetCount() {
        // 获取数据库中的总记录数
        // SELECT COUNT( * ) FROM user
        long count = userService.count();
        System.out.println("总记录数：" + count);
    }

    @Test
    // 演示了如何使用 MyBatis Plus 的服务类进行批量添加操作
    public void testInsertMore() {
        //批量添加
        //INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
        // 循环添加多个用户对象到列表中
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setName("hrq" + i);
            user.setAge(20 + i);
            list.add(user);
        }
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }
}

