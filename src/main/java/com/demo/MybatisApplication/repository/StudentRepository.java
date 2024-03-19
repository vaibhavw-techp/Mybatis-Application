package com.demo.MybatisApplication.repository;


import com.demo.MybatisApplication.config.SchoolManagementSQLConnMapper;
import com.demo.MybatisApplication.model.StudentEntity;
import com.demo.MybatisApplication.model.SubjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@SchoolManagementSQLConnMapper("StudentMapper")
public interface StudentRepository {

    void save(StudentEntity student);
    void saveAllSubjectsForStudent(@Param("studentId") Long studentId, @Param("subjects") List<SubjectEntity> subjects);
    StudentEntity findStudentById(Long id);
    StudentEntity findBySubjects(Long id);
    List<StudentEntity> findAll(Map<String, Object> filters);
}
