package com.demo.MybatisApplication.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentSubjectsDisplayDto {
    private String name;
    private List<SubjectDisplayDto> subjects;
}
