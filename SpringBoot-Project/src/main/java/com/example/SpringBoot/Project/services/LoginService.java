package com.example.SpringBoot.Project.services;
import com.example.SpringBoot.Project.entities.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component("login")
public class LoginService {
    private int userId;
    private User user;

    public LoginService() {
    }

    public LoginService(int userId, User user) {
        this.userId = userId;
        this.user = user;
    }

    @PostConstruct
    public void login(){
        System.out.println("Login Successful");
    }
}
