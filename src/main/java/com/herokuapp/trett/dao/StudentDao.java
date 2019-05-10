package com.herokuapp.trett.dao;

import com.herokuapp.trett.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void removeStudentById(int id);
    
    void updateStudent(Student student);
    
    void insertStudent(Student student);
}
