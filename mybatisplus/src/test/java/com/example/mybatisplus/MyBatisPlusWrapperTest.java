package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @Project: mybatisplus
 * @Package: com.example.mybatisplus
 * @ClassName: MyBatisPlusWrapperTest
 * @Datetime: 2023/06/01 15:42
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 一个使用 MyBatis Plus 的 QueryWrapper 进行数据库查询和操作的测试类
 */


@SpringBootTest(classes = MybatisplusApplication.class) // 注解表示这是一个 Spring Boot 的集成测试类，它会加载整个应用程序的上下文

public class MyBatisPlusWrapperTest {
    // 注解用于自动注入 UserMapper 对象，它是一个 MyBatis Plus 自动生成的 Mapper 接口，用于执行数据库操作
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        /* 组装查询条件：查询用户名包含a，年龄在20到30之间，邮箱信息不为null的用户信息
         SELECT uid AS id,user_name AS name,age,email,is_deleted
         FROM t_user
         WHERE is_deleted=0
         AND (user_name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        */
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 使用链式调用的方式来封装查询条件
        queryWrapper.like("user_name", "a").between("age", 20, 30).isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);  // 遍历列表并打印每个元素
    }

    @Test
    public void test02() {
        /* 组装排序条件：查询用户信息，按照年龄的降序排序，若年龄相同，则按照id升序排序
        SELECT uid AS id,user_name AS name,age,email,is_deleted
        FROM t_user
        WHERE is_deleted=0
        ORDER BY age DESC,uid ASC
        */
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("uid");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test03() {
        /* 组装删除条件：删除邮箱地址为null的用户信息
        UPDATE t_user SET is_deleted=1
        WHERE is_deleted=0 AND (email IS NULL)
        */
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println("result:" + result);
    }

    @Test
    public void test04() {
        /* 组装删除条件：将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        UPDATE t_user SET user_name=?, email=?
        WHERE is_deleted=0
        AND (age > ? AND user_name LIKE ? OR email IS NULL)
        */
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20).like("user_name", "a").or().isNull("email");
        User user = new User();
        user.setName("小明");
        user.setEmail("xiaoming@gmail.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("result:" + result);
    }

    @Test
    public void test05() {
        /* 将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        UPDATE t_user SET user_name=?, email=?
        WHERE is_deleted=0
        AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        */
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", "a").and(i -> i.gt("age", 20).or().isNull("email"));
        User user = new User();
        user.setName("小红");
        user.setEmail("xiaohong@gmail.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("result:" + result);
    }

    @Test
    public void test06() {
        /* 组装select子句：查询用户的用户名、年龄、邮箱信息
        SELECT user_name,age,email
        FROM t_user
        WHERE is_deleted=0
        */
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_name", "age", "email");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test07() {
        /* 查询id小于等于100的用户信息
        SELECT uid AS id,user_name AS name,age,email,is_deleted
        FROM t_user
        WHERE is_deleted=0
        AND (uid IN (select uid from t_user where uid <= 100))
        */
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("uid", "select uid from t_user where uid<=100");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test08() {
        // 修改用户名中包含a并且(年龄大于20或者邮箱为null)的用户信息
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("user_name", "a").and(i -> i.gt("age", 20).or().isNull("email"));
        updateWrapper.set("user_name", "小黑").set("email", "xiaohei@gamil.com");
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result:" + result);
    }

    @Test
    public void test09() {
        /*
        SELECT uid AS id,user_name AS name,age,email,is_deleted
        FROM t_user
        WHERE is_deleted=0
        AND (user_name LIKE ? AND age <= ?)
        */
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)) {
            //isNotBlank判断某个字符串是否不为空字符串、不为null、不为空白符
            queryWrapper.like("user_name", username);
        }
        if (ageBegin != null) {
            queryWrapper.ge("age", ageBegin);    //大于等于
        }
        if (ageEnd != null) {
            queryWrapper.le("age", ageEnd);      //小于等于
        }
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test10() {
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), "user_name", username)
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test11() {
        /*
        SELECT uid AS id,user_name AS name,age,email,is_deleted
        FROM t_user
        WHERE is_deleted=0
        AND (user_name LIKE ? AND age <= ?)
        */
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), User::getName, username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test12() {
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.like(User::getName, "a")
                .and(i -> i.gt(User::getAge, 20).or().isNull(User::getEmail));
        updateWrapper.set(User::getName, "小黑").set(User::getEmail, "abc@atguigu.com");
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result：" + result);
    }
}

