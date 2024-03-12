package com.demo.MybatisApplication.controller;

import com.demo.MybatisApplication.model.SubjectEntity;
import com.demo.MybatisApplication.model.TeacherEntity;
import com.demo.MybatisApplication.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/{teacherId}")
    public TeacherEntity listOfTeachers(@PathVariable long teacherId){
        return teacherRepository.getTeacherById(teacherId);
    }

    @GetMapping
    public List<TeacherEntity> getAllTeachers(){
        return teacherRepository.getAllTeachers();
    }

    @GetMapping("/{teacherId}/subjects")
    public Object getTeacherWithSubjectsById(@PathVariable Long teacherId) {
       return teacherRepository.getTeacherStudents(teacherId);
    }


}
