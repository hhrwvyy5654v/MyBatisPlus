package com.example.mybatisplus;

import com.example.mybatisplus.enums.SexEnum;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatisplus
 * @ClassName: MyBatisPlusEnumTest
 * @Datetime: 2023/07/05 15:27
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 一个使用 MyBatis Plus 进行数据库操作的测试类
 */

@SpringBootTest // 注解表示这是一个 Spring Boot 的集成测试类，它会加载整个应用程序的上下文
public class MyBatisPlusEnumTest {
    @Autowired // 注解用于自动注入 UserMapper 对象，这是一个 MyBatis Plus 自动生成的 Mapper 接口，用于执行数据库操作
    private UserMapper userMapper;

    @Test // 注解表示这是一个测试方法
    public void test() {
        // 创建一个 User 对象，并设置其属性值，包括姓名、年龄和性别
        User user = new User();
        user.setName("admin");
        user.setAge(33);
        user.setSex(SexEnum.MALE);
        // 将该用户对象插入到数据库中
        int result = userMapper.insert(user);
        // 打印插入结果
        System.out.println("result:" + result);
    }
}

