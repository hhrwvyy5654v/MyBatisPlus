package com.example.mybatisplus;

import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
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

@SpringBootTest // 指定测试类为Spring Boot应用程序的测试类
public class MyBatisPlusTest {
    @Autowired // 将UserMapper接口的实现对象注入到测试类中
    private UserMapper userMapper;

    @Test // 标记测试方法
    public void testSelectList() {
        // 调用了userMapper的selectList方法,使用条件构造器查询一个list集合
        List<User> list = userMapper.selectList(null); // 条件构造器为 null，表示查询所有记录
        list.forEach(System.out::println); // 通过forEach方法将集合中的每个元素输出到控制台
    }

    @Test   //标记测试方法
    public void testInsert() {
        User user = new User(); //创建User对象
        // 设置user对象的属性：姓名、年龄和电子邮件地址
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@gmail.com");
        // 调用userMapper的insert方法将该User对象插入到User表中
        int result = userMapper.insert(user);
        // 打印插入结果和插入的User对象的id
        System.out.println("result:" + result);
        System.out.println("id:" + user.getId());
    }

    @Test //标记测试方法
    public void testDelete(){
        /*
        通过id删除用户信息
        DELETE FROM user WHERE id=?
        int result = userMapper.deleteById(1492767055210991617L);
        System.out.println("result:"+result);

        根据map集合中所设置的条件删除用户信息
        DELETE FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 23);
        int result = userMapper.deleteByMap(map);
        System.out.println("result:"+result);

        通过多个id实现批量删除
        DELETE FROM user WHERE id IN ( ? , ? , ? )
        */
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println("result:"+result);
    }

    @Test //标记测试方法
    public void testUpdate(){
        // 创建一个User对象并设置其属性
        User user=new User();
        user.setId(4L);
        user.setName("李四");
        user.setEmail("lisi@gmail.com");
        // 使用userMapper.updateById()方法更新User表中id为4的用户信息
        int result = userMapper.updateById(user);
        System.out.println("result:"+result);
    }

    @Test
    public void testSelect(){
        /*
        通过id查询用户信息
        SELECT id,name,age,email FROM user WHERE id=?
        User user = userMapper.selectById(1L);
        System.out.println(user);

        根据多个id查询多个用户信息
        SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);

        根据map集合中的条件查询用户信息
        SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("age", 20);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);

        查询所有数据
        SELECT id,name,age,email FROM user
        */
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
        /*
        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
        */
    }
}
