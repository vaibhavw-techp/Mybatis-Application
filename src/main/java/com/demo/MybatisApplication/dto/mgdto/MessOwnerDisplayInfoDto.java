package com.demo.MybatisApplication.dto.mgdto;

import lombok.Data;

import java.util.List;

@Data
public class MessOwnerDisplayInfoDto {
    private String name;
    private List<MessOwnerDisplayDto> owner;
}
