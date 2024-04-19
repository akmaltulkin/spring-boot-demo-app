package com.example.springbootdemoapp.controllers;


import com.example.springbootdemoapp.entitites.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

@RestController
@RequestMapping("/api/v1")
public class StudentController {



    @GetMapping("/test")
    public String first(){
        return "Hey, congrats, your first API endpoint";
    }

    @GetMapping("/teststudent")
    public Student second(){
        return new Student("Rahul", LocalDate.of(1998, Month.JANUARY, 5), "rahul@gain.com");
    }
}
