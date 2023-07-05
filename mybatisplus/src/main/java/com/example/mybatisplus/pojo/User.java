package com.example.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.mybatisplus.enums.SexEnum;
import lombok.Data;

/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatisplus.pojo
 * @ClassName: User
 * @Datetime: 2023/05/30 14:29
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 一个用户实体类,名为User,定义了用户的属性和对应的数据库表字段
 */
@Data //Lombok的注解，用于自动生成实体类的getter、setter、toString等方法
@TableName("t_user")    //指定实体类所对应的表名为“t_user”

public class User {
    // @TableId(value = "uid", type = IdType.AUTO)
    // value属性用于指定主键的字段,type属性设置主键生成策略
    // 用于指定属性所对应的字段名，并且将该字段指定为主键
    @TableId("uid")
    private Long id;
    // 指定属性所对应的字段名
    @TableField("user_name")
    private String name;
    private Integer age;
    private String email;
    private SexEnum sex;
    // 指定逻辑删除字段：逻辑删除是指在删除数据时，不是真正地从数据库中删除，而是通过修改一个
    // 标识字段来表示该数据已被删除。这样可以保留历史数据，提高查询效率，避免物理删除带来的风险
    @TableLogic
    private Integer isDeleted;
}

