package com.example.mybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @Project: MyBatisPlus
 * @Package: com.example.mybatisplus
 * @ClassName: FastAutoGeneratorTest
 * @Datetime: 2023/07/05 14:42
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description: MyBatis Plus的代码生成器，根据配置信息自动生成代码文件，包括实体类、Mapper接口和Mapper XML文件等
 */

public class FastAutoGeneratorTest {
    public static void main(String[] args) {
        // 创建了一个FastAutoGenerator对象，并传入数据库连接信息
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/mybatis_plus?characterEncoding=utf-8&userSSL=false", "root", "root")
                // 设置全局配置
                .globalConfig(builder -> {
                    builder.author("example")   //设置作者
                            //.enableSwagger()  //开启 swagger 模式
                            .fileOverride()     //设置文件覆盖
                            .outputDir("CodeGenerator"); //指定输出目录
                })
                // 设置包配置
                .packageConfig(builder -> {
                    builder.parent("com.example")   // 设置父包名
                            .moduleName("mybatisplus")  // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "CodeGenerator"));  // 设置mapperXml生成路径
                })
                // 设置策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("t_user")    // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                // 设置模板引擎为Freemarker引擎
                .templateEngine(new FreemarkerTemplateEngine())
                // 执行代码生成器
                .execute();
    }
}

