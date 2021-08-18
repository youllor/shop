package com.yl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author gzf
 * @date 2021/8/17 18:21
 */
@SpringBootApplication
// 扫描 mybatis 通用 mapper 所在的包
@MapperScan(basePackages = "com.yl.mapper")
// 扫描所有包以及相关组件包
@ComponentScan(basePackages = {"com.yl","org.n3r.idworker"})
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
