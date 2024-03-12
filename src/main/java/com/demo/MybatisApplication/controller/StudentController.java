package com.demo.MybatisApplication.controller;

import com.demo.MybatisApplication.dto.StudentInfoDto;
import com.demo.MybatisApplication.model.StudentEntity;
import com.demo.MybatisApplication.model.SubjectEntity;
import com.demo.MybatisApplication.repository.StudentRepository;
import com.demo.MybatisApplication.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/{id}")
    public StudentEntity getStudentById(@PathVariable Long id){
        return studentRepository.getStudentById(id);
    }

    @PostMapping("/{studentId}/subjects")
    public void addSubjectsToStudent(@PathVariable Long studentId, @RequestBody List<SubjectEntity> subjects) {
        studentRepository.addSubjectsToStudent(studentId, subjects);
    }

    //Add student
    @PostMapping
    public StudentEntity addStudent(@RequestBody StudentEntity student){
        studentRepository.addStudent(student);
        return studentRepository.getStudentById(student.getId());
    }

    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @GetMapping("/{studentId}/subjects")
    public StudentEntity getStudentWithSubjects(@PathVariable Long studentId) {
        return studentRepository.getStudentWithSubjects(studentId);
    }

}
