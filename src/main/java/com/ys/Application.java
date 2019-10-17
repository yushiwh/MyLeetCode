package com.ys;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
public class Application {
    @Bean
    public WebMvcConfigurer corsConfigurer() { // 允许跨域
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("POST", "DELETE", "PUT", "GET",
                        "OPTIONS");
            }
        };
    }


    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
