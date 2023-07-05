package com.example.mybatis_plus_datasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatis_plus_datasource.mapper.UserMapper;
import com.example.mybatis_plus_datasource.pojo.User;
import com.example.mybatis_plus_datasource.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatis_plus_datasource.service.impl
 * @ClassName: UserServiceImpl
 * @Datetime: 2023/07/05 23:38
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description:
 */

@Service    // 表示它是一个服务类，用于标识这个类是用于业务逻辑的
@DS("master")   // 一个注解，用于指定数据源的选择，表示使用名为 "master" 的数据源
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    // 通过继承ServiceImpl类，ServiceImplUser类继承一了基些本的数据库操作方法，如插入、更新、删除和查询等。这些方法继承自ServiceImpl类，并且已经实现了对应的辑逻
    // UserServiceImpl类实现了UserService接口，可以通过UserService接口定义的方法来操作用户数据
}

