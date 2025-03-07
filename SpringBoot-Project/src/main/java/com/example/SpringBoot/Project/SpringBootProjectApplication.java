package com.example.SpringBoot.Project;

import com.example.SpringBoot.Project.entities.User;
import com.example.SpringBoot.Project.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
@ComponentScan(
        basePackages = {
                "com.example.SpringBoot.Project", "com.example.SpringBoot.Project1"
        },
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = User.class)
)
public class SpringBootProjectApplication implements CommandLineRunner {
    @Autowired
    WebApplicationContext container;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AuthService authService = container.getBean(AuthService.class);
        authService.authenticate();
    }
}
