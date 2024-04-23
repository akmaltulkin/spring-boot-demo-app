package com.example.springbootdemoapp.controllers;


import com.example.springbootdemoapp.entitites.Student;
import com.example.springbootdemoapp.exceptions.EmailTakenException;
import com.example.springbootdemoapp.exceptions.StudentNotFoundException;
import com.example.springbootdemoapp.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



    @GetMapping("/student/{id}") //
    public Student studentById(@PathVariable Long id) {
        //@PathVariable is used to bind the id value from the URL to the id parameter of the method.

       return studentService.getStudentById(id);
    }

    @PostMapping("/student")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        // if this method throws email taken exception, it will be handled by the handleEmailTakenException method

    }


    // This method is used to handle the StudentNotFoundException.
    // The @ExceptionHandler annotation is used to handle exceptions.
    // The method returns a ResponseEntity object with the exception message and the HTTP status code.
    //
    @ExceptionHandler(EmailTakenException.class) // This annotation is used to handle exceptions.
    public ResponseEntity<String> handleEmailTakenException(EmailTakenException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus. BAD_REQUEST);
    }

}
