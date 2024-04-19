package com.example.springbootdemoapp;

import com.example.springbootdemoapp.entitites.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication

public class SpringBootDemoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoAppApplication.class, args);
    }



}
