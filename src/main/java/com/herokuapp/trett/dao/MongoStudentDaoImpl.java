package com.herokuapp.trett.dao;

import com.herokuapp.trett.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements StudentDao {
    private static Map<Integer, Student> students;

    {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "Mario", "Nothing"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents() {
        return this.students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return this.students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public void insertStudent(Student student) {
        this.students.put(student.getId(), student);
    }
}
