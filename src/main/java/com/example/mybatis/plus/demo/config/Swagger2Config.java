package com.example.mybatis.plus.demo.config;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.*;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Value("${swagger2.title}")
    private String title;
    @Value("${swagger2.version}")
    private String version;
    @Value("${swagger2.description}")
    private String description;
    @Value("${swagger2.base-package}")
    private String basePackage;
    @Bean
    public Docket swagger2Api() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("default")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(ApiIgnore.class)
                .enableUrlTemplating(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .version(version)
                .description(description)
                .termsOfServiceUrl("http://springfox.io")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/xiaohuaihuai/mybatis-plus-demo/blob/master/LICENSE")
                .build();
    }

    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(userPaths())
                .build()
                .ignoredParameterTypes(ApiIgnore.class)
                .enableUrlTemplating(true);
    }

    private Predicate<String> userPaths() {
        return regex("/user.*");
    }

}
