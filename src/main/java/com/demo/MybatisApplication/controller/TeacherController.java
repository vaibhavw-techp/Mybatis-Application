package com.demo.MybatisApplication.controller;


import com.demo.MybatisApplication.dto.TeacherAdditionDto;
import com.demo.MybatisApplication.dto.TeacherDisplayDto;
import com.demo.MybatisApplication.dto.TeacherDisplayWithIdDto;
import com.demo.MybatisApplication.model.TeacherEntity;
import com.demo.MybatisApplication.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping
    public TeacherEntity addTeacher(@RequestBody TeacherAdditionDto teacherAdditionDto){
        return teacherService.addTeacher(teacherAdditionDto);
    }

    @GetMapping("/{id}")
    public TeacherDisplayDto getTeacherById(@PathVariable long id){
        return teacherService.getTeacherById(id);
    }

    @GetMapping
    public List<TeacherDisplayWithIdDto> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}/subjects")
    public Object getTeacherWithSubjectsById(@PathVariable Long id) {
       return teacherService.getTeacherWithSubjectsById(id);
    }
}
