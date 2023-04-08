package com.example.spring1.repository;

import com.example.spring1.dto.UpdateStudenDto;
import com.example.spring1.model.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Repository
@Mapper
public interface StudentRepository {
    @Select("SELECT *FROM student_tbl")
    List<Student> getAllStudent();
    @Insert("INSERT INTO student_tbl" +
            "(id, name, score) " +
            "VALUES (#{id}, #{name}, #{score})")
    void addStudent(Student student);
    @Select("""
            SELECT *FROM student_tbl
            WHERE id=#{id}
            """)
    Student getStudentById(@PathVariable("id") Integer id);
    @Select("""
            SELECT * FROM student_tbl
            WHERE name LIKE CONCAT('%', #{name}, '%')
            """)
    List<Student> getStudentByName(@Param("name") String name);
    @Delete(
            """
            DELETE FROM student_tbl 
            WHERE id=#{id}        
            """
    )
    void deleteById(@PathVariable("id") Integer id);
    @Update(
            """
            UPDATE student_tbl
            SET name=#{name},
                score=#{score}
            WHERE id=#{id}
            """
    )
    void updateStudentById(@RequestBody Student student);
}
