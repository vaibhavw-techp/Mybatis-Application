package com.demo.MybatisApplication.service;

import com.demo.MybatisApplication.dto.*;
import com.demo.MybatisApplication.mapstruct.TeacherMapper;
import com.demo.MybatisApplication.model.StudentEntity;
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
    public TeacherDisplayDto getTeacherById(long teacherId){
        return teacherMapper.teacherEntityToTeacherDisplayDto(teacherRepository.getTeacherById(teacherId));
    }
    public List<TeacherDisplayWithIdDto> getAllTeachers(){
        List<TeacherDisplayWithIdDto> teachersList = teacherMapper.teacherDiplayIdDtosFromEntitiest(teacherRepository.getAllTeachers());
        return teachersList;
    }
    public TeacherSubjectDisplayDto getTeacherWithSubjectsById(Long teacherId) {
        return teacherMapper.teacherEntityToTeacherSubjectDisplayDto(teacherRepository.getTeacherStudents(teacherId));
    }

    public TeacherEntity addTeacher(TeacherAdditionDto teacher){
        if (teacher.getTeacherName() == null || teacher.getTeacherName().isEmpty()) {
            throw new IllegalArgumentException("Teacher name cannot be null or empty");
        }

        TeacherEntity teacherEntity = teacherMapper.teacherAddDtoToTeacherEntity(teacher);
        teacherRepository.addTeacher(teacherEntity);
        return teacherEntity;
    }

}
