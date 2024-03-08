package com.demo.MybatisApplication.controller;

import com.demo.MybatisApplication.model.StudentEntity;
import com.demo.MybatisApplication.repository.StudentRepository;
import com.demo.MybatisApplication.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students/{id}")
    public StudentEntity getStudentById(@PathVariable Long id){
        return studentRepository.selectStudentById(id);
    }

}
