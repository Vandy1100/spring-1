package com.example.spring1.controller;

import com.example.spring1.dto.UpdateStudenDto;
import com.example.spring1.model.Student;
import com.example.spring1.service.StudentServiceImp;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentServiceImp serviceImp;

    public StudentController(StudentServiceImp serviceImp) {
        this.serviceImp = serviceImp;
    }

    @GetMapping("/student")
    List<Student> getAllStudent(){
        return serviceImp.getAllStudent();
    }
    @GetMapping("/*")
    String errorPage(){
        return "<h1>ERROR 404 NOT FOUND</h1>";
    }
    @PostMapping("/student")
    void addStudent(@RequestBody Student student){
        serviceImp.addStudent(student);
    }
    @GetMapping("/student/{id}")
    Student getStudentById(@PathVariable("id") Integer sid){
        return serviceImp.getStudentById(sid);
    }
    @GetMapping("/student-search-name")
    List<Student> getStudentByName(@RequestParam String name ){
        return serviceImp.getStudentByName(name);
    }
    @DeleteMapping("/student/{id}")
    void deleteStudentById(@PathVariable Integer id){
        serviceImp.deleteById(id);
    }
    @PutMapping("/student/")
    void updateStudentById(@RequestBody Student student){
        serviceImp.updateStudentById(student);

    }
}
