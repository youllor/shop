package com.yl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author gzf
 * @date 2021/8/18 19:05
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
//    http://localhost:8088/swagger-ui.html     原路径
//    http://localhost:8088/doc.html     原路径
    //配置swagger2核心配置 docket
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)//指定API类型为swagger2
                .apiInfo(apiInfo())  //用于定义api文档汇总信息
                .select().apis(RequestHandlerSelectors
                        .basePackage("com.yl.controller"))     //指定controller包
                .paths(PathSelectors.any())     //所有controller
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("AShop接口api")        //文档标题
                .contact(new Contact("youllor", "https://github.com/youllor/shop", "youllorc@gmail.com"))
                .description("为AShop提供的api文档")//详细信息
                .version("1.0.1")
                .termsOfServiceUrl("") //网站地址
                .build();
    }
}
