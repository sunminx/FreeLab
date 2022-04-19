package com.xy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.ArrayList;

@EnableOpenApi
@Configuration
public class Swagger3Config {

    @Value("${swagger.enabled}")
    private boolean enabled;

    /**
     * 配置swagger的Docket bean * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30) // 指定swagger3.0版本
                .groupName("cruzgo")
                .apiInfo(createApiInfo())
                .enable(enabled);
    }
    /**
     * 配置swagger的ApiInfo bean * @return
     */
    @Bean
    public ApiInfo createApiInfo(){
        return new ApiInfo("FreeLab Swagger",
                "Lab-gateway Api Document",
                "3.0",
                "http://www.xy.cn",
                new Contact("sunminx",
                        "http://www.xy.cn", "sunminchina@126.com"),
                "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }
}
