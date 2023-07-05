package com.example.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.mapper.ProductMapper;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.Product;
import com.example.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatisplus
 * @ClassName: MyBatisPlusPluginsTest
 * @Datetime: 2023/07/05 09:13
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 一个使用 MyBatis Plus 进行数据库操作的测试类
 */

@SpringBootTest // 注解表示这是一个 Spring Boot 的集成测试类会它，加载整个应用程序的上下文

public class MyBatisPlusPluginsTest {
    // 注解用于自动注入 UserMapper 和 ProductMapper 对象，它们是 MyBatis Plus 自动生成的 Mapper 接口，用于执行数据库操作
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;

    @Test
    // 演示使用 MyBatis Plus 的分页功能
    public void testPage() {
        // 创建一个 Page 对象，指定页码和每页记录数
        Page<User> page = new Page<>(2, 3);
        // 进行分页查询，将查询结果存储在 page 对象中
        userMapper.selectPage(page, null);
        // 打印分页查询的结果
        System.out.println(page.getRecords());  // 记录列表
        System.out.println(page.getPages());    // 总页数
        System.out.println(page.getTotal());    // 总记录数
        System.out.println(page.hasNext());     // 是否有下一页
        System.out.println(page.hasPrevious()); // 是否有上一页
    }

    @Test
    // 演示如何使用 MyBatis Plus 的自定义分页查询
    public void testPageVo() {
        // 创建一个 Page 对象，指定页码和每页记录数
        Page<User> page = new Page<>(1, 3);
        // 自定义的查询参数为20
        userMapper.selectPageVo(page, 20);
        // 打印分页查询的结果
        System.out.println(page.getRecords());  // 记录列表
        System.out.println(page.getPages());    // 总页数
        System.out.println(page.getTotal());    // 总记录数
        System.out.println(page.hasNext());     // 是否有下一页
        System.out.println(page.hasPrevious()); // 是否有上一页
    }

    @Test
    public void testProduct01() {
        //小李查询商品价格
        Product productLi = (Product) productMapper.selectById(1);
        System.out.println("小李查询的商品价格：" + productLi.getPrice());
        //小王查询商品价格
        Product productWang = (Product) productMapper.selectById(1);
        System.out.println("小王查询的商品价格：" + productWang.getPrice());
        //小李将商品价格+50
        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);
        //小王将商品价格-30
        productWang.setPrice(productWang.getPrice() - 30);
        int result = productMapper.updateById(productWang);
        if (result == 0) {
            //操作失败，重试
            Product productNew = (Product) productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice() - 30);
            productMapper.updateById(productNew);
        }
        //老板查询商品价格
        Product productLaoban = (Product) productMapper.selectById(1);
        System.out.println("老板查询的商品价格：" + productLaoban.getPrice());
    }

}

