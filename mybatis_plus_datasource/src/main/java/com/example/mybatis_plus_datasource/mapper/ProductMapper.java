package com.example.mybatis_plus_datasource.mapper;

import com.example.mybatis_plus_datasource.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;


/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatis_plus_datasource.mapper
 * @ClassName: ProductMapper
 * @Datetime: 2023/07/05 23:30
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 一个Java接口，名为ProductMapper
 */

@Repository // 表示这是一个仓库类，用于标识这个接口是用于数据访问的
// ProductMapper接口继承了BaseMapper接口，并指定了泛型类型为Product
public interface ProductMapper extends BaseMapper<Product> {
    // BaseMapper是MyBatis Plus提供的一个通用Mapper接口，它提供了一些基本的数据库操作方法如，插入、更新、删除和查询等
    // 通过继承BaseMapper接口，ProductMapper接口无手需动实现这些基本的数据库操作方法，MyBatis Plus会根据接口的泛型类型自动生成对应的SQL语句
}

