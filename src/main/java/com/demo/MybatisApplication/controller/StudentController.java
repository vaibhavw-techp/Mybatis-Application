package com.demo.MybatisApplication.controller;


import com.demo.MybatisApplication.dto.StudentAdditionDto;
import com.demo.MybatisApplication.dto.StudentSubjectsDisplayDto;
import com.demo.MybatisApplication.dto.StudentDisplayDto;
import com.demo.MybatisApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public StudentDisplayDto getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/{studentId}/subjects")
    public void assignSubjectsToStudent(@PathVariable Long studentId, @RequestBody List<Long> subjectIds) {
        studentService.assignSubjectsToStudent(studentId, subjectIds);
    }

    // Add student
    @PostMapping
    public StudentDisplayDto addStudent(@RequestBody StudentAdditionDto student){
        return studentService.addStudent(student);
    }

    @GetMapping
    public List<StudentDisplayDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}/subjects")
    public StudentSubjectsDisplayDto getStudentWithSubjects(@PathVariable Long studentId) {
        return studentService.getStudentWithSubjects(studentId);
    }

}
