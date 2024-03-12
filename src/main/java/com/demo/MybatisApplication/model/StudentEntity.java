package com.demo.MybatisApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class StudentEntity {
    private Long id;
    private String studentName;
    private String email;
    private Integer age;
    private List<SubjectEntity> studentSubjects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<SubjectEntity> getStudentSubjects() {
        return studentSubjects;
    }

    public void setStudentSubjects(List<SubjectEntity> studentSubjects) {
        this.studentSubjects = studentSubjects;
    }
}
