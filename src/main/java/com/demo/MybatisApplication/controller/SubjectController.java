package com.demo.MybatisApplication.controller;

import com.demo.MybatisApplication.dto.SubjectAdditionDto;
import com.demo.MybatisApplication.dto.SubjectDisplayDto;
import com.demo.MybatisApplication.dto.SubjectEntityDisplayDto;
import com.demo.MybatisApplication.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping("/{id}")
    public SubjectEntityDisplayDto getSubjectById(@PathVariable Long id){
        return subjectService.getSubjectById(id);
    }
    @GetMapping
    public List<SubjectDisplayDto> getSubjects(){
        return subjectService.getSubjects();
    }

    @PostMapping
    public List<SubjectAdditionDto> addSubjects(@Valid @RequestBody List<SubjectAdditionDto> subjects){
        return subjectService.addSubjects(subjects);
    }

}
