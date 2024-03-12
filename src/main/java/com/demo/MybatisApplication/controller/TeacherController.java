package com.demo.MybatisApplication.controller;

import com.demo.MybatisApplication.model.TeacherEntity;
import com.demo.MybatisApplication.repository.TeacherRepository;
import com.demo.MybatisApplication.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{id}")
    public TeacherEntity listOfTeachers(@PathVariable long id){
        return teacherRepository.findTeacherById(id);
    }

    @GetMapping
    public List<TeacherEntity> getAllTeachers(){
        return teacherRepository.findAllTeachers();
    }

    @GetMapping("/{id}/subjects")
    public TeacherEntity getTeacherWithSubjectsById(@PathVariable Long id) {
       return teacherRepository.findSubjectsAssignedToTeacher(id);
    }


}
