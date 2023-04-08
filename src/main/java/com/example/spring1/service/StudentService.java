package com.example.spring1.service;

import com.example.spring1.dto.UpdateStudenDto;
import com.example.spring1.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();

    void addStudent(Student student);

    Student getStudentById(Integer id);

    List<Student> getStudentByName(String name);

    void deleteById(Integer id);

    void updateStudentById(Student student);
}
