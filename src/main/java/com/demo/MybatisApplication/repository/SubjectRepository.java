package com.demo.MybatisApplication.repository;

import com.demo.MybatisApplication.model.SubjectEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectRepository {
    SubjectEntity selectSubjectById(long subjectId);

    List<SubjectEntity> getAllSubjects();

    void addSubjects(List<SubjectEntity> subject);
}
