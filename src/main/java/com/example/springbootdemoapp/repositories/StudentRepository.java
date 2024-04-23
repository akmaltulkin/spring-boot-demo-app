package com.example.springbootdemoapp.repositories;

import com.example.springbootdemoapp.entitites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
// This annotation is optional, but it is good practice to use it.
// It is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
public interface StudentRepository extends JpaRepository<Student, Long>{

    // The JpaRepository interface provides methods for performing CRUD operations on the entity.
   //Commonly used methods are:
    // save() - to save an entity
    // findById() - to find an entity by id
    // findAll() - to find all entities
    // deleteById() - to delete an entity by id
    // count() - to count the number of entities
    // existsById() - to check if an entity exists by id
    // deleteAll() - to delete all entities
    // delete() - to delete an entity
    // saveAll() - to save a list of entities
    // findAllById() - to find a list of entities by id
    // flush() - to flush the changes to the database
    // deleteAllInBatch() - to delete all entities in a batch


    //Besides extending the JpaRepository interface,
    // we can define custom methods in the repository interface.
    Optional<Object> findStudentByEmail(String email);
    // This method is used to find a student by email.

}
