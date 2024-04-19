package com.example.springbootdemoapp.services;

import com.example.springbootdemoapp.entitites.Student;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;


@Service
// @Component // this is also valid, but @Service is more specific and more readable
public class StudentService {


    public static List<Student> get100RandomStudents() {
        List<Student> students = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++) {
            //create a student with random data
            students.add(new Student(
                    Long.valueOf(faker.number().numberBetween(1,1000)),
                    faker.name().fullName(),
                    faker. date().birthday(18,67).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    faker.internet().emailAddress()
            )  );
        }

        return students;
    }
}
