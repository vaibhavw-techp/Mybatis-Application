package com.demo.MybatisApplication.controller;

import com.demo.MybatisApplication.dto.TeacherAdditionDto;
import com.demo.MybatisApplication.dto.TeacherDisplayDto;
import com.demo.MybatisApplication.dto.TeacherDisplayWithIdDto;
import com.demo.MybatisApplication.model.SubjectEntity;
import com.demo.MybatisApplication.model.TeacherEntity;
import com.demo.MybatisApplication.repository.TeacherRepository;
import com.demo.MybatisApplication.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherService teacherService;

    @PostMapping
    public TeacherEntity addTeacher(@RequestBody TeacherAdditionDto teacherAdditionDto){
        return teacherService.addTeacher(teacherAdditionDto);
    }

    @GetMapping("/{teacherId}")
    public TeacherDisplayDto listOfTeachers(@PathVariable long teacherId){
        return teacherService.getTeacherById(teacherId);
    }

    @GetMapping
    public List<TeacherDisplayWithIdDto> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{teacherId}/subjects")
    public Object getTeacherWithSubjectsById(@PathVariable Long teacherId) {
       return teacherService.getTeacherWithSubjectsById(teacherId);
    }
}
