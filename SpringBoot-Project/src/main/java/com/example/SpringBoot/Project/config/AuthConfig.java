package com.example.SpringBoot.Project.config;

import com.example.SpringBoot.Project.entities.User;
import com.example.SpringBoot.Project.services.AuthService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
//@ConditionalOnClass(name = "com.example.SpringBoot.Project.entity.User")
@ConditionalOnClass(value = User.class)
public class AuthConfig {
    @ConditionalOnBean(name = "login")
    @Bean
    public AuthService authService() {
        return new AuthService();
    }
}
