package com.example.SpringBoot.Project.configurationProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppPropertiesDemo {
    @Autowired
    private Employee employee;

    public void displayEmployee(){
        System.out.println(employee.getEmpName());
        System.out.println(employee.getEmpId());
        System.out.println(employee.getDepartment());
        System.out.println(employee.getCredentials().getUserName());
        System.out.println(employee.getCredentials().getPassword());
        System.out.println(employee.permissions);
    }

}
