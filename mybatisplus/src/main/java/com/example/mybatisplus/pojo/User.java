package com.example.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.example.mybatisplus.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatisplus.pojo
 * @ClassName: User
 * @Datetime: 2023/05/30 14:29
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description:
 */
@Data
public class User {
    @TableId("uid")
    private Long id;

    @TableId("user_name")
    private String name;
    private Integer age;
    private String email;
    private SexEnum sex;

    @TableLogic
    private Integer isDeleted;

}

