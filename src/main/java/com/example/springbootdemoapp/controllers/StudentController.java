package com.example.springbootdemoapp.controllers;


import com.example.springbootdemoapp.entitites.Student;
import com.example.springbootdemoapp.services.StudentService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {



    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/test")
    public String first(){
        return "Hey, congrats, your first API endpoint";
    }

    @GetMapping("/100randomstudents")
    public List<Student> second(){
        return studentService.get100RandomStudents();
    }

    @GetMapping("/students")
    public List<Student> students(){
        return studentService.getStudents();
    }
}
