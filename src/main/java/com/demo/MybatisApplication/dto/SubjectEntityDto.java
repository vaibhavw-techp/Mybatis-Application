package com.demo.MybatisApplication.dto;

import lombok.Data;

@Data
public class SubjectEntityDto {
    private Long id;
    private String name;
    private TeacherSubjectDto teacher;
}
