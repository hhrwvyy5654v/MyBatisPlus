package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.pojo.User;

/**
 * @Project: mybatisplus
 * @Package: com.example.mybatisplus.service
 * @ClassName: UserService
 * @Datetime: 2023/06/01 11:27
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 一个名为UserService的接口，它继承了MyBatis-Plus提供的IService接口指，并定了泛型类型为User
 */

public interface UserService extends IService<User> {
     /*
     * 在这个接口中，UserService并没有定义任何自己的方法，而是直接继承了IService接口。
     * 这是因为IService接口已经提供了常用的数据库操作方法，可以满足大部分的业务需求。
     * 如果需要在UserService中定义自己的方法，可以直接在接口中添加方法声明，并在实现类中实现这些方法。
     */
}