package com.demo.MybatisApplication.dto;

import com.demo.MybatisApplication.model.SubjectEntity;
import lombok.Data;


@Data
public class StudentsDisplayDto {
    private Long id;
    private String name;
    private String email;
    private Integer age;
}
