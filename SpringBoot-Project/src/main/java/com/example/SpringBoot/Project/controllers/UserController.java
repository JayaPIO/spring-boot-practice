package com.example.SpringBoot.Project.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    // Get method by default
    @RequestMapping(path = "/hello")
    public String sayHello() {
        return "Hello!..";
    }

    @GetMapping("/greet")
    public String greetUser(@RequestParam(name = "name", defaultValue = "Guest") String name) {
        return "hello " + name;
    }


    @GetMapping("user/{id}")
    public String getUserById(@PathVariable int id) {
        return "User Id: " + id;
    }


}
