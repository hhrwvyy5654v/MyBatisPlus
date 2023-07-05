package com.example.mybatis_plus_datasource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatis_plus_datasource.pojo.User;

/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatis_plus_datasource.service
 * @ClassName: UserService
 * @Datetime: 2023/07/05 23:37
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 一个Java服务接口，名为UserService
 */

public interface UserService extends IService<User> {
    // UserService接口定义了一些与用户相关的服务方法，如增删改查等。
    // 这些方法继承自IService接口，无需手动实现，MyBatis Plus会根据接口的泛型类型自动生成对应的SQL语句
}

