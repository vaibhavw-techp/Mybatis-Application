package com.demo.MybatisApplication.service;

import com.demo.MybatisApplication.dto.StudentAddDto;
import com.demo.MybatisApplication.dto.StudentDisplayAsSubjects;
import com.demo.MybatisApplication.dto.StudentDisplayByIdDto;
import com.demo.MybatisApplication.dto.StudentsDisplayDto;
import com.demo.MybatisApplication.model.StudentEntity;
import com.demo.MybatisApplication.model.SubjectEntity;
import com.demo.MybatisApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.demo.MybatisApplication.mapstruct.StudentMapper;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    public StudentDisplayByIdDto getStudentById(Long id){
        StudentEntity studentEntity = studentRepository.getStudentById(id);
        return studentMapper.studentEntityToDisplayByIdDto(studentEntity);
    }

    public void addSubjectsToStudent(Long studentId, List<SubjectEntity> subjects) {
        studentRepository.addSubjectsToStudent(studentId, subjects);
    }

    public StudentDisplayByIdDto addStudent(StudentAddDto student){
        StudentEntity studentEntity = studentMapper.studentAddDtoToEntity(student);
        studentRepository.addStudent(studentEntity);
        return studentMapper.studentEntityToDisplayByIdDto(studentEntity);
    }

    public List<StudentsDisplayDto> getAllStudents() {
        List<StudentEntity> studentEntities = studentRepository.getAllStudents();
        return studentMapper.studentEntitiesToDisplayDtos(studentEntities);
    }

    public StudentDisplayAsSubjects getStudentWithSubjects(Long studentId) {
        StudentEntity studentEntity = studentRepository.getStudentWithSubjects(studentId);
        return studentMapper.studentEntityToDisplayAsSubjects(studentEntity);
    }
}
