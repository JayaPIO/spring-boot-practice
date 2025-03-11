package com.example.SpringBoot.project1;

import com.example.SpringBoot.Project.entities.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Logout {
    private int userId;
    private User user;

    public Logout() {
    }

    public Logout(int userId, User user) {
        this.userId = userId;
        this.user = user;
    }

    @PostConstruct
    public void logout(){
        System.out.println("Logout Successful");
    }
}
