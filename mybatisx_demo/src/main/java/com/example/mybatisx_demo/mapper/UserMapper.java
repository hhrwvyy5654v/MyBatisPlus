package com.example.mybatisx_demo.mapper;
import org.apache.ibatis.annotations.Param;

import com.example.mybatisx_demo.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author HRQ
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2023-07-06 03:52:45
* @Entity com.example.mybatisx_demo.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
    int insertSelective(User user);
}




