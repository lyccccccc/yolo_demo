package com.zt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootApplication：开启组件扫描和自动配置。
 * MapperScan: mapper 接口类扫描包配置
 */
@SpringBootApplication
@MapperScan("com.zt.dao")
public class Application {

    public static void main(String[] args) {
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class, args);
        System.out.println("程序正在运行...");
    }

}
