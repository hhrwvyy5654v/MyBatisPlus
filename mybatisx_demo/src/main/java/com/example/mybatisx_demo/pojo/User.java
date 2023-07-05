package com.example.mybatisx_demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
public class User implements Serializable {
    private Long id;

    private String name;

    private Integer age;

    private String email;

    private static final long serialVersionUID = 1L;
}