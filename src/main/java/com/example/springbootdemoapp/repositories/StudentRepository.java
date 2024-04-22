package com.example.springbootdemoapp.repositories;

import com.example.springbootdemoapp.entitites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
// This annotation is optional, but it is good practice to use it.
// It is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
public interface StudentRepository extends JpaRepository<Student, Long>{
}
