package com.example.mybatis_plus_datasource.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatis_plus_datasource.pojo
 * @ClassName: User
 * @Datetime: 2023/07/05 23:18
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 映射数据库中的用户表，并提供了相应的属性和方法来操作用户数据
 */
@Data   // 自动生成了getter、setter和toString等方法
@TableName("t_user")    // 指定数据库的表名
public class User {
    @TableId
    private Integer uid;    // 整数类型，表示用户ID
    private String username;    // 字符串类型，表示用户名
    private Integer age;    // 整数类型，表示年龄
    private Integer sex;    // 整数类型，表示性别
    private String email;   // 字符串表示，类型电子邮件
    private Integer isDelete;   // 整数类型，表示是否删除
}

