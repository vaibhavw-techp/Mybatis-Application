package com.demo.MybatisApplication.repository;

import com.demo.MybatisApplication.config.SchoolManagementSQLConnMapper;
import com.demo.MybatisApplication.model.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
@SchoolManagementSQLConnMapper("TeacherMapper")
public interface TeacherRepository {

    TeacherEntity findTeacherById(long id);
    TeacherEntity findAllByTeacher(@Param("id") Long id);
    List<TeacherEntity> findAll();
    void save(TeacherEntity teacher);
}
