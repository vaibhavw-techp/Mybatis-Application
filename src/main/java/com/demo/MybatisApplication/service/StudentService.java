package com.demo.MybatisApplication.service;

import com.demo.MybatisApplication.dto.StudentAdditionDto;
import com.demo.MybatisApplication.dto.StudentSubjectsDisplayDto;
import com.demo.MybatisApplication.dto.StudentDisplayDto;
import com.demo.MybatisApplication.dto.SubjectEntityDisplayDto;
import com.demo.MybatisApplication.mapstruct.SubjectMapper;
import com.demo.MybatisApplication.mapstruct.SubjectMapperImpl;
import com.demo.MybatisApplication.model.StudentEntity;
import com.demo.MybatisApplication.model.SubjectEntity;
import com.demo.MybatisApplication.model.TeacherEntity;
import com.demo.MybatisApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.MybatisApplication.mapstruct.StudentMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    public StudentDisplayDto getStudentById(Long id){
        StudentEntity studentEntity = studentRepository.findStudentById(id);
        return studentMapper.mapStudentEntityToDisplayByIdDto(studentEntity);
    }

    public void assignSubjectsToStudent(Long studentId, List<SubjectEntityDisplayDto> subjects) {
        SubjectMapperImpl subjectMapper = new SubjectMapperImpl();
        List<SubjectEntity> subjectEntities = subjects.stream()
                .map(subjectMapper::mapSubjectEntityDisplayDtoToSubjectEntity)
                .collect(Collectors.toList());
        studentRepository.updateSubjectsToStudent(studentId, subjectEntities);
    }

    public StudentDisplayDto addStudent(StudentAdditionDto student){
        StudentEntity studentEntity = studentMapper.mapStudentAddDtoToEntity(student);
        studentRepository.saveStudent(studentEntity);
        return studentMapper.mapStudentEntityToDisplayByIdDto(studentEntity);
    }

    public List<StudentDisplayDto> getAllStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAllStudents();
        return studentMapper.mapStudentEntitiesToDisplayDtos(studentEntities);
    }

    public StudentSubjectsDisplayDto getStudentWithSubjects(Long studentId) {
        StudentEntity studentEntity = studentRepository.findStudentWithSubjects(studentId);
        return studentMapper.mapStudentEntityToStudentSubjectsDisplayDto(studentEntity);
    }
}
