package com.demo.MybatisApplication.service;

import com.demo.MybatisApplication.dto.TeacherDisplayDto;
import com.demo.MybatisApplication.dto.TeacherDisplayWithIdDto;
import com.demo.MybatisApplication.mapstruct.TeacherMapper;
import com.demo.MybatisApplication.model.TeacherEntity;
import com.demo.MybatisApplication.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherMapper teacherMapper;

    public TeacherDisplayDto getTeacherById(@PathVariable long id){
        return teacherMapper.teacherEntityToTeacherDisplayDto(teacherRepository.findTeacherById(id));
    }

    public List<TeacherDisplayWithIdDto> getAllTeachers(){
        List<TeacherDisplayWithIdDto> teacherDisplayWithIdDtos = teacherMapper.teacherDiplayIdDtosFromEntities(teacherRepository.findAllTeachers());
        return teacherDisplayWithIdDtos;
    }

    public Object getTeacherWithSubjectsById(@PathVariable Long id) {
        return teacherRepository.findSubjectsAssignedToTeacher(id);
    }
}
