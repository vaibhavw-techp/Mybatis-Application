package com.demo.MybatisApplication.repository;


import com.demo.MybatisApplication.model.StudentEntity;
import com.demo.MybatisApplication.model.SubjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentRepository {

    void saveStudent(StudentEntity student);
    void updateSubjectsToStudent(@Param("studentId") Long studentId, @Param("subjects") List<SubjectEntity> subjects);
    StudentEntity findStudentById(Long id);
    StudentEntity findStudentWithSubjects(Long id);
    List<StudentEntity> findAllStudents();
    List<StudentEntity> findAllStudentsUsingFilter(Map<String, Object> filters);
}
