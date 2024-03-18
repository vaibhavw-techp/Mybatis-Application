package com.demo.MybatisApplication.service;

import com.demo.MybatisApplication.dto.SubjectAdditionDto;
import com.demo.MybatisApplication.dto.SubjectDisplayDto;
import com.demo.MybatisApplication.dto.SubjectEntityDisplayDto;
import com.demo.MybatisApplication.mapstruct.SubjectMapper;
import com.demo.MybatisApplication.model.StudentEntity;
import com.demo.MybatisApplication.model.SubjectEntity;
import com.demo.MybatisApplication.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    SubjectMapper subjectMapper;

    public SubjectEntityDisplayDto getSubjectById(@PathVariable Long id){
        return subjectMapper.mapSubjectEntityToSubjectDisplayDto(subjectRepository.findSubjectById(id));
    }

    public List<SubjectDisplayDto> getSubjects(){
        List<SubjectDisplayDto> subjects = subjectMapper.mapSubjectEntitiesToDtos(subjectRepository.findAllSubjects());
        return subjects;
    }

    public List<SubjectAdditionDto> addSubjects(@RequestBody List<SubjectAdditionDto> subjects) {
        List<SubjectEntity> subjectEntities = subjectMapper.mapSubjectAddtionDtosToSubjectEntities(subjects);
        subjectRepository.saveSubjects(subjectEntities);
        return subjects;
    }
}
