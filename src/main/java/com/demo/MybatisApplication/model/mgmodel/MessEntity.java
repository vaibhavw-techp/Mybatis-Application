package com.demo.MybatisApplication.model.mgmodel;

import lombok.Data;

import java.util.List;

@Data
public class MessEntity {
    private Long id;
    private String name;
    private int capacity;
    private String location;
}
