package com.demo.MybatisApplication.controller;

import com.demo.MybatisApplication.model.StudentEntity;
import com.demo.MybatisApplication.model.SubjectEntity;
import com.demo.MybatisApplication.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;
    @GetMapping("/{subjectId}")
    public SubjectEntity getSubjectById(@PathVariable Long subjectId){
        return subjectRepository.selectSubjectById(subjectId);
    }

    @GetMapping
    public List<SubjectEntity> getSubjects(){
        return subjectRepository.getAllSubjects();
    }
    @PostMapping
    public List<SubjectEntity> addSubjects(@RequestBody List<SubjectEntity> subjects){
        subjectRepository.addSubjects(subjects);
        return subjectRepository.getAllSubjects();
    }

}
