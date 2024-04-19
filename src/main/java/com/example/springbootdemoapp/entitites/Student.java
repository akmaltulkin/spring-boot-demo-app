package com.example.springbootdemoapp.entitites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long id;
    private String name;
    private LocalDate dob;

    private String email;

    private Integer age;

    public Student(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.age = LocalDate.now().compareTo(dob);
    }




}
