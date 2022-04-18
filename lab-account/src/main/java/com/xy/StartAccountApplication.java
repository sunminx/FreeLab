package com.xy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class StartAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartAccountApplication.class, args);
    }
}
