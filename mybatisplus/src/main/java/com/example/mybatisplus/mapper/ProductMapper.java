package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatisplus.mapper
 * @ClassName: ProductMapper
 * @Datetime: 2023/07/05 14:18
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 一个产品数据访问接口
 */

@Repository // 表示这是一个用于数据访问的仓库类
// ProductMapper继承了BaseMapper，这是一个MyBatis-Plus提供的基础Mapper接口，用于提供一些基本的数据库操作方法
public interface ProductMapper extends BaseMapper {
    // 这个接口没有定义任何方法，因此它继承了BaseMapper的所有方法，包括入插、更新、删除和查询等数据库操作方法
}
