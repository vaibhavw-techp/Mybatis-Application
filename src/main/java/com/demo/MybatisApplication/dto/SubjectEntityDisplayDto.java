package com.demo.MybatisApplication.dto;

import lombok.Data;

@Data
public class SubjectEntityDisplayDto {
    private Long id;
    private String name;
    private TeacherEntityDisplayDto teacher;
}
