package com.demo.MybatisApplication.dto;

import lombok.Data;

@Data
public class StudentAdditionDto {
    private Long id;
    private String name;
    private String email;
    private Integer age;
}
