package com.abooksapimvn.abooks.config;

import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config {
    @Bean
    public PhysicalNamingStrategyStandardImpl physical(){
        return new PhysicalNamingStrategyStandardImpl();
    }
    // @Bean
    // public ImplicitNamingStrategy implicit(){
    //     return new ImplicitNamingStrategyLegacyJpaImpl();
    // }
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer(){
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/v1/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
