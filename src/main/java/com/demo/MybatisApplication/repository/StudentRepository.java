package com.demo.MybatisApplication.repository;

import com.demo.MybatisApplication.dto.StudentAddDto;
import com.demo.MybatisApplication.dto.StudentDisplayAsSubjects;
import com.demo.MybatisApplication.dto.StudentDisplayByIdDto;
import com.demo.MybatisApplication.dto.StudentsDisplayDto;
import com.demo.MybatisApplication.model.StudentEntity;
import com.demo.MybatisApplication.model.SubjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentRepository {
    void addStudent(StudentEntity student);
    void addSubjectsToStudent(@Param("studentId") Long studentId, @Param("subjects") List<SubjectEntity> subjects);
    StudentEntity getStudentById(Long id);
    StudentEntity getStudentWithSubjects(Long id);
    List<StudentEntity> getAllStudents();
    List<StudentEntity> getAllStudentsUsingFilter(Map<String, Object> filters);
}
