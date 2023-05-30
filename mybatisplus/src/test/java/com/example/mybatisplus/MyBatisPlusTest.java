package com.example.mybatisplus;

import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatisplus
 * @ClassName: MyBatisPlusTest
 * @Datetime: 2023/05/30 15:25
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 一个使用 MyBatis Plus 进行数据库操作的测试类
 */

@SpringBootTest
public class MyBatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        //通过条件构造器查询一个list集合，若没有条件，则可以设置null为参数
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }
}

