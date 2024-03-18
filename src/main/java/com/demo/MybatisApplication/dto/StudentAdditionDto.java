package com.demo.MybatisApplication.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class StudentAdditionDto {
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Age cannot be null")
    @PositiveOrZero(message = "Age should be a positive number or zero")
    private Integer age;
}
