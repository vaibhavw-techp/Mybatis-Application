package com.demo.MybatisApplication.dto;

import com.demo.MybatisApplication.model.TeacherEntity;
import lombok.Data;

@Data
public class SubjectEntityDto {
    private Long subjectId;
    private String name;
    private TeacherEntity teacher;
}
