package com.demo.MybatisApplication.dto;

import lombok.Data;


@Data
public class StudentDisplayDto {
    private Long id;
    private String name;
    private String email;
    private Integer age;
}
