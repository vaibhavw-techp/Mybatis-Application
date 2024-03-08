package com.demo.MybatisApplication.controller;

import com.demo.MybatisApplication.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;
}
