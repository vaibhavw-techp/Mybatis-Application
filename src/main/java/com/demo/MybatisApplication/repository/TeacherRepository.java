package com.demo.MybatisApplication.repository;

import com.demo.MybatisApplication.model.SubjectEntity;
import com.demo.MybatisApplication.model.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherRepository {
    TeacherEntity getTeacherById(long teacherId);
    Object getTeacherStudents(@Param("teacherId") Long teacherId);

    void addTeacher(TeacherEntity teacher);

    List<TeacherEntity> getAllTeachers();
}
