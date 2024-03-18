package com.demo.MybatisApplication.service;

import com.demo.MybatisApplication.dto.TeacherAdditionDto;
import com.demo.MybatisApplication.dto.TeacherDisplayDto;
import com.demo.MybatisApplication.dto.TeacherEntityDisplayDto;
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
        return teacherMapper.mapTeacherEntityToTeacherDisplayDto(teacherRepository.findTeacherById(id));
    }

    public List<TeacherEntityDisplayDto> getAllTeachers(){
        List<TeacherEntityDisplayDto> teacherDisplayWithIdDtos = teacherMapper.mapTeacherEntitiesToTeacherEntityDisplayDto(teacherRepository.findAllTeachers());
        return teacherDisplayWithIdDtos;
    }

    public TeacherEntity addTeacher(TeacherAdditionDto teacher){
        if (teacher.getName() == null || teacher.getName().isEmpty()) {
            throw new IllegalArgumentException("Teacher name cannot be null or empty");
        }

        TeacherEntity teacherEntity = teacherMapper.teacherAddDtoToTeacherEntity(teacher);
        teacherRepository.save(teacherEntity);
        return teacherEntity;
    }

}
