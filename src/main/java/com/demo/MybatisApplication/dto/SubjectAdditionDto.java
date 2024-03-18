package com.demo.MybatisApplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SubjectAdditionDto {
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Teacher ID cannot be null")
    private Long teacherId;
}
