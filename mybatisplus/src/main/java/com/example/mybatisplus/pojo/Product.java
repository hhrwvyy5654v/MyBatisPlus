package com.example.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatisplus.pojo
 * @ClassName: Product
 * @Datetime: 2023/07/05 14:23
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 定义了一个产品对象，并使用了乐观锁机制来实现并发控制
 */

@Data   // 使用了Lombok库的@Data注解，自动生成了getter、setter、equals、hashCode和toString等方法
public class Product {
    private Long id;    // 产品的唯一标识类型
    private String name;    // 产品的名称
    private Integer price;  // 产品的价格
    @Version //用于标识乐观锁的版本号字段，乐观锁是一种并发控制机制，用于解决多个线程同时修改同一数据时可能出现的数据冲突问题
    private Integer version;    // 表示乐观锁的版本号字段，用于实现乐观锁机制，类型为Integer
}

