package com.demo.MybatisApplication.repository;

import com.demo.MybatisApplication.model.TeacherEntity;

public interface TeacherRepository {
    TeacherEntity selectTeacherById(long teacherId);
}
