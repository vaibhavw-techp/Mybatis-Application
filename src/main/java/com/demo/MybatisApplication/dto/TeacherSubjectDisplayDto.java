package com.demo.MybatisApplication.dto;

import com.demo.MybatisApplication.model.SubjectEntity;
import lombok.Data;

import java.util.List;

@Data
public class TeacherSubjectDisplayDto {
    private Long teacherId;
    private String teacherName;
    private int age;
    private String email;
    private List<SubjectDisplayDto> subjects;
}
