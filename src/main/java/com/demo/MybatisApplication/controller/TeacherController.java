package com.demo.MybatisApplication.controller;


import com.demo.MybatisApplication.dto.TeacherAdditionDto;
import com.demo.MybatisApplication.dto.TeacherDisplayDto;
import com.demo.MybatisApplication.dto.TeacherEntityDisplayDto;
import com.demo.MybatisApplication.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherEntityDisplayDto> addTeacher(@Valid @RequestBody TeacherAdditionDto teacherAdditionDto){
        return teacherService.addTeacher(teacherAdditionDto);
    }

    @GetMapping("/{id}")
    public TeacherDisplayDto getTeacherById(@PathVariable long id){
        return teacherService.getTeacherById(id);
    }

    @GetMapping
    public List<TeacherEntityDisplayDto> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

}
