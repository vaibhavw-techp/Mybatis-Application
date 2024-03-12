package com.demo.MybatisApplication.repository;

import com.demo.MybatisApplication.model.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherRepository {

    TeacherEntity findTeacherById(long id);
    TeacherEntity findSubjectsAssignedToTeacher(@Param("id") Long id);
    List<TeacherEntity> findAllTeachers();
    void saveTeacher(TeacherEntity teacher);
}
