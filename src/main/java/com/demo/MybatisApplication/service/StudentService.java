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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    public StudentDisplayByIdDto getStudentById(Long id){
        StudentEntity studentEntity = studentRepository.findStudentById(id);
        return studentMapper.studentEntityToDisplayByIdDto(studentEntity);
    }

    public void assignSubjectsToStudent(Long studentId, List<SubjectEntity> subjects) {
        studentRepository.updateSubjectsToStudent(studentId, subjects);
    }

    public StudentDisplayByIdDto addStudent(StudentAddDto student){
        StudentEntity studentEntity = studentMapper.studentAddDtoToEntity(student);
        studentRepository.saveStudent(studentEntity);
        return studentMapper.studentEntityToDisplayByIdDto(studentEntity);
    }

    public List<StudentsDisplayDto> getAllStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAllStudents();
        return studentMapper.studentEntitiesToDisplayDtos(studentEntities);
    }

    public StudentDisplayAsSubjects getStudentWithSubjects(Long studentId) {
        StudentEntity studentEntity = studentRepository.findStudentWithSubjects(studentId);
        return studentMapper.studentEntityToDisplayAsSubjects(studentEntity);
    }

    public List<StudentsDisplayDto> getAllStudentsWithFilters(String name, Integer age, String email) {
        Map<String, Object> filters = new HashMap<>();
        filters.put("name", name);
        filters.put("age", age);
        filters.put("email",email);
        List<StudentEntity> studentEntities = studentRepository.findAllStudentsUsingFilter(filters);
        return studentMapper.studentEntitiesToDisplayDtos(studentEntities);
    }
}
