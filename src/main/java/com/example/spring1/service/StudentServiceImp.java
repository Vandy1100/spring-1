package com.example.spring1.service;

import com.example.spring1.dto.UpdateStudenDto;
import com.example.spring1.model.Student;
import com.example.spring1.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImp implements StudentService {
    private final StudentRepository repository;

    public StudentServiceImp(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAllStudent() {
        return repository.getAllStudent();
    }

    @Override
    public void addStudent(Student student) {
        repository.addStudent(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return repository.getStudentById(id);
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return repository.getStudentByName(name);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void updateStudentById(Student student) {
        repository.updateStudentById(student);
    }
}
