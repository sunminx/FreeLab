package com.xy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class Swagger3Config {
    /**
     * 配置swagger的Docket bean * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30) // 指定swagger3.0版本
                .groupName("cruzgo")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xy.controller"))
                .build()
                .apiInfo(createApiInfo())
                .enable(true);
    }
    /**
     * 配置swagger的ApiInfo bean * @return
     */
    @Bean
    public ApiInfo createApiInfo(){
        return new ApiInfo("FreeLab Swagger",
                "Lab-account Api Document",
                "3.0",
                "http://www.xy.cn",
                new Contact("sunminx",
                "http://www.xy.cn", "sunminchina@126.com"),
                "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }
}
