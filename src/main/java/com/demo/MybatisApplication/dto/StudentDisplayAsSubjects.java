package com.demo.MybatisApplication.dto;

import com.demo.MybatisApplication.model.SubjectEntity;
import lombok.Data;

import java.util.List;

@Data
public class StudentDisplayAsSubjects {
    private String name;
    private List<SubjectDisplayDto> subjects;
}
