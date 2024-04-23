package com.example.springbootdemoapp.services;

import com.example.springbootdemoapp.entitites.Student;
import com.example.springbootdemoapp.exceptions.EmailTakenException;
import com.example.springbootdemoapp.exceptions.StudentNotFoundException;
import com.example.springbootdemoapp.repositories.StudentRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
// @Component // this is also valid, but @Service is more specific and more readable
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> get100RandomStudents() {
        List<Student> students = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++) {
            //create a student with random data
            students.add(new Student(
                    (long) faker.number().numberBetween(1, 1000),
                    faker.name().fullName(),
                    faker. date().birthday(18,67).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    faker.internet().emailAddress()
            )  );
        }

        return students;
    }

    public List<Student> getStudents() {
        List<Student> all = studentRepository.findAll();
        return all;
    }

    public Student getStudentById(Long id){
        Optional<Student> byId = studentRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        } else {
            throw new StudentNotFoundException("Student with id " + id + " not found");
        }
    }

    public void addStudent(Student student) {

        if (studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
            throw new EmailTakenException("Email taken");
        }

       studentRepository.save(student);
    }
}
