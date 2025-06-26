package com.abooksapimvn.abooks.config;

import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
