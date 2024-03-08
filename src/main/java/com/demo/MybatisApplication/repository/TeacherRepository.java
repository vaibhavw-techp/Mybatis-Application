package com.demo.MybatisApplication.repository;

import com.demo.MybatisApplication.model.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherRepository {
    TeacherEntity selectTeacherById(long teacherId);
}
