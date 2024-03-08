package com.demo.MybatisApplication.controller;

import com.demo.MybatisApplication.model.SubjectEntity;
import com.demo.MybatisApplication.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;
    @GetMapping("subjects/{subjectId}")
    public SubjectEntity getSubjectById(@PathVariable Long subjectId){
        return subjectRepository.selectSubjectById(subjectId);
    }
}
