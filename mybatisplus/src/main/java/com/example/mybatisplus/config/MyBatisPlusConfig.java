package com.example.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatisplus.config
 * @ClassName: MyBatisPlusConfig
 * @Datetime: 2023/07/04 22:18
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: 一个Java类，用于配置MyBatis-Plus的相关设置
 */


@Configuration  // 一个Spring注解，表示这个类是一个配置类，用于配置应用程序的相关设置
@MapperScan("org.example.mybatisplus.mapper")   // 一个MyBatis注解，用于指定要扫描的Mapper接口所在的包路径

public class MyBatisPlusConfig {
    @Bean   // 定义了一个名为mybatisPlusInterceptor的Bean,这个Bean是MybatisPlusInterceptor类型的对象，用于配置MyBatis Plus的拦截器
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // PaginationInnerInterceptor是一个分页插件，用于实现分页查询功能。DbType.MYSQL表示使用MySQL数据库
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        // OptimisticLockerInnerInterceptor是一个乐观锁插件，用于实现乐观锁功能
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        // 将创建的MybatisPlusInterceptor对象返回作为mybatisPlusInterceptor方法的结果，以便在应用程序中使用
        return interceptor;
    }
}