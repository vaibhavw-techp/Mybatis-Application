package com.demo.MybatisApplication.repository;

import com.demo.MybatisApplication.model.SubjectEntity;

public interface SubjectRepository {
    SubjectEntity selectSubjectById(long subjectId);
}
