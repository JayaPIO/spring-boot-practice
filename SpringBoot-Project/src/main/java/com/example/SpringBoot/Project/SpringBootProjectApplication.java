package com.example.SpringBoot.Project;

import com.example.SpringBoot.Project.configurationProperties.AppPropertiesDemo;
import com.example.SpringBoot.Project.entities.Student;
import com.example.SpringBoot.Project.entities.User;
import com.example.SpringBoot.Project.repositories.StudentRepository;
import com.example.SpringBoot.Project.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

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

        ConfigurableApplicationContext context = SpringApplication.run(SpringBootProjectApplication.class, args);
        AppPropertiesDemo appPropertiesDemo = context.getBean("appPropertiesDemo", AppPropertiesDemo.class);
        appPropertiesDemo.displayEmployee();

        StudentRepository studentRepository =context.getBean(StudentRepository.class);

        //save a single student
        Student student = new Student();
        student.setName("Jaya");
        student.setCity("Jaipur");
        student.setState("Rajasthan");

        Student student1 = studentRepository.save(student);
        System.out.println(student1);

        //save a list of students
        Student s1 = new Student();
        s1.setName("sia");
        s1.setCity("Jaipur");
        s1.setState("Rajasthan");

        Student s2 = new Student();
        s2.setName("riya");
        s2.setCity("ajmer");
        s2.setState("Rajasthan");


        Student result1 = studentRepository.save(s1);
        Student result2 = studentRepository.save(s2);
        System.out.println(result1);
        System.out.println(result2);

        Optional<Student> optional = studentRepository.findById(353);
        Student getStudent = optional.get();
        System.out.println(getStudent);

        getStudent.setName("sia gokhlani");
        Student updated = studentRepository.save(getStudent);
        System.out.println(updated);

        studentRepository.deleteById(404);
        System.out.println("student deleted successfully");



    }

    @Override
    public void run(String... args) throws Exception {
        AuthService authService = container.getBean(AuthService.class);
        authService.authenticate();
    }
}
