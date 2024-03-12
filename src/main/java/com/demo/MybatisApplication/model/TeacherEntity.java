package com.demo.MybatisApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherEntity {
    private Long teacherId;
    private String teacherName;
    private int age;
    private String email;
}
