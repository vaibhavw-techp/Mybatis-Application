package com.demo.MybatisApplication.repository;

import com.demo.MybatisApplication.model.SubjectEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectRepository {

    SubjectEntity findSubjectById(long id);
    List<SubjectEntity> findAll();
    void saveAll(List<SubjectEntity> subjects);
}
