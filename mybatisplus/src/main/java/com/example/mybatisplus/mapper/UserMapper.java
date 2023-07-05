package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatisplus.mapper
 * @ClassName: UserMapper
 * @Datetime: 2023/05/30 15:01
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 一个用户数据访问口接的层
 */

@Repository // Spring Framework中的注解之一,用于标识一个类为数据访问对象（DAO）,并将其注册到 Spring 容器中,表示这是一个用于数据访问的仓库类
// UserMapper继承了BaseMapper<User>，这是一个MyBatis-Plus提供的基础Mapper接口，用于提供一些基本的数据库操作方法
public interface UserMapper extends BaseMapper<User> {
    // 根据用户id查询用户信息，并返回一个Map对象
    Map<String, Object> selectMapById(Long id);

    // 通过年龄查询用户信息并进行分页，并返回一个Page对象
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);
}

