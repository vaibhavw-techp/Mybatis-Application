package com.demo.MybatisApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SubjectEntity {
    private Long subjectId;
    private String name;
    private TeacherEntity teacher;
}
