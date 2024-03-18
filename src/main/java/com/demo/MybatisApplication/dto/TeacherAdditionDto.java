package com.demo.MybatisApplication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class TeacherAdditionDto {
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @PositiveOrZero(message = "Age should be a positive number or zero")
    private int age;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;
}
