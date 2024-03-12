package com.demo.MybatisApplication.dto;

import com.demo.MybatisApplication.model.SubjectEntity;
import lombok.Data;

import java.util.List;

@Data
public class TeacherAdditionDto {
    private String teacherName;
    private int age;
    private String email;
}
