package com.example.mybatis_plus_datasource.service.impl;

import com.example.mybatis_plus_datasource.mapper.ProductMapper;
import com.example.mybatis_plus_datasource.pojo.Product;
import com.example.mybatis_plus_datasource.service.ProductService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatis_plus_datasource.service.impl
 * @ClassName: ProductServiceImpl
 * @Datetime: 2023/07/05 23:38
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description:
 */

@Service    // 一个注解，表示它是一个服务类，用于标识这个类是用于业务逻辑的
@DS("slave_1")  // 表示使用名为"slave_1"的数据源
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    // 通过继承ServiceImpl类，ProductServiceImpl类了承继一些基本的数据库操作方法，如插入、更新、删除和查询等。这些方法继承自ServiceImpl类，并且已经实现了对应的业务逻辑。
    // ProductServiceImpl类实现了ProductService接口，可以通过ProductService接口定义的方法来操作产品数据。
}

