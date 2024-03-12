package com.demo.MybatisApplication.repository;


import com.demo.MybatisApplication.model.StudentEntity;
import com.demo.MybatisApplication.model.SubjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentRepository {

    void saveStudent(StudentEntity student);

    void updateSubjectsToStudent(@Param("studentId") Long studentId, @Param("subjects") List<SubjectEntity> subjects);

    StudentEntity findStudentById(Long id);

    StudentEntity findStudentWithSubjects(Long id);

    List<StudentEntity> findAllStudents();
}
