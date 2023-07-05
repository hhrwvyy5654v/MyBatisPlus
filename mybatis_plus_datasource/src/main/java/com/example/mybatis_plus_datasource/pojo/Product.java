package com.example.mybatis_plus_datasource.pojo;

import lombok.Data;

/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatis_plus_datasource.pojo
 * @ClassName: Product
 * @Datetime: 2023/07/05 23:24
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 一个名为Product产品对象Java类，包含了产品的各种属性信息
 */

@Data
public class Product {
    private Integer id; // 整数类型，表示产品的ID
    private String name;    // 类型，表示产品的名称
    private Integer price;  // 整数类型，表示产品的价格
    private Integer version;    // 整数类型，表示产品的版本号
}

