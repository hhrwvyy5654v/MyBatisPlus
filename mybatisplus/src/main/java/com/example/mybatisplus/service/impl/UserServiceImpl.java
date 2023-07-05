package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import com.example.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Project: mybatisplus
 * @Package: com.example.mybatisplus.service.impl
 * @ClassName: UserServiceImpl
 * @Datetime: 2023/06/01 11:27
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 一个基于MyBatis Plus的用户服务类，提供了一些操作用户数据的方法
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}