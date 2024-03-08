package com.demo.MybatisApplication.repository;

import com.demo.MybatisApplication.model.StudentEntity;
import com.demo.MybatisApplication.model.SubjectEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentRepository {
    StudentEntity selectStudentById(long id);
    List<SubjectEntity> selectSubjectsByStudentId(Long id);
}
