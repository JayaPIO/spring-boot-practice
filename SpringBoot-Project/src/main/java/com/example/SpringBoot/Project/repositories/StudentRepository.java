package com.example.SpringBoot.Project.repositories;

import com.example.SpringBoot.Project.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
