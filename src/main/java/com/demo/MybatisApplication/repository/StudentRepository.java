package com.demo.MybatisApplication.repository;

import com.demo.MybatisApplication.model.StudentEntity;

public interface StudentRepository {
    StudentEntity selectStudentById(long id);
}
