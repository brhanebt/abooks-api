package com.abooksapimvn.abooks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        User.UserBuilder users = User.builder().passwordEncoder(encoder::encode);

        var joe = users.username("john").password("doe").roles("USER").build();
        var jane = users.username("jane").password("doe").roles("USER").build();
        var admin = users.username("admin").password("admin").roles("ADMIN").build();


        UserDetails userDetails = User.withDefaultPasswordEncoder().username("user").password("pass")
                            .roles("USER").build();
        return new InMemoryUserDetailsManager(userDetails,joe,jane,admin);
    }
}
