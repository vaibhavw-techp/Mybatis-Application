package com.demo.MybatisApplication.repository;

import com.demo.MybatisApplication.dto.StudentInfoDto;
import com.demo.MybatisApplication.model.StudentEntity;
import com.demo.MybatisApplication.model.SubjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentRepository {
    void addStudent(StudentEntity student);

    void addSubjectsToStudent(@Param("studentId") Long studentId, @Param("subjects") List<SubjectEntity> subjects);

    StudentEntity getStudentById(Long id);

    StudentEntity getStudentWithSubjects(Long id);

    List<StudentEntity> getAllStudents();
}
