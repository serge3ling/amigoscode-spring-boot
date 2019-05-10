package com.herokuapp.trett.service;

import com.herokuapp.trett.dao.StudentDao;
import com.herokuapp.trett.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {
    @Autowired
    @Qualifier("fakeData") // for Spring to know which implementation to inject
    private StudentDao studentDao;

    public Collection<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    public void removeStudentById(int id) {
        this.studentDao.removeStudentById(id);
    }
    
    public void updateStudent(Student student) {
        this.studentDao.updateStudent(student);
    }
    
    public void insertStudent(Student student) {
        this.studentDao.insertStudent(student);
    }
}
