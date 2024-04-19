package com.example.springbootdemoapp.entitites;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Student(Long id, String name, LocalDate dob, String email) {

        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.age = LocalDate.now().compareTo(dob);
    }




}
