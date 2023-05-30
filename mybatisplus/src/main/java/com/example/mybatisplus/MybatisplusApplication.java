package com.example.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //表示这是一个Spring Boot应用程序的入口类
@MapperScan("com.example.mybatisplus.mapper") //表示需要扫描指定路径下的Mapper接口，并将其注册到Spring容器中

public class MybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusApplication.class, args);
    }

}
