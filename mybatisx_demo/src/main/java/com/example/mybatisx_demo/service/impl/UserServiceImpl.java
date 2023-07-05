package com.example.mybatisx_demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisx_demo.mapper.UserMapper;
import com.example.mybatisx_demo.pojo.User;
import com.example.mybatisx_demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author HRQ
 * @description 针对表【t_user】的数据库操作Service实现
 * @createDate 2023-07-06 03:52:45
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

}




