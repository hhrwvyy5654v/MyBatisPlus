package com.example.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatisplus.enums
 * @ClassName: SexEnum
 * @Datetime: 2023/05/30 14:32
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 定义了一个枚举类SexEnum,用于表示性别
 */

@Getter //自动生成sex和sexName的getter方法,可以在其他地方通过枚举值获取对应的属性值
public enum SexEnum {
    //枚举类的两个属性
    MALE(1, "男"),
    FEMALE(1, "女");

    @EnumValue // 表示sex属性是一个枚举类型的值,在进行数据库操作时需要将其转化为对应的整数值
    private Integer sex;
    private String sexName;

    // 构造函数，初始化每个枚举值的属性
    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
