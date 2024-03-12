package com.demo.MybatisApplication.dto;

import lombok.Data;

@Data
public class TeacherDisplayWithIdDto {
    private Long teacherId;
    private String teacherName;
    private int age;
    private String email;
}
