package com.demo.MybatisApplication.repository.mgrepository;

import com.demo.MybatisApplication.config.MessManagementSQLConnMapper;
import com.demo.MybatisApplication.config.SchoolManagementSQLConnMapper;
import com.demo.MybatisApplication.model.mgmodel.MessEntity;
import com.demo.MybatisApplication.model.mgmodel.MessOwnerEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
@MessManagementSQLConnMapper("MessMapper")
public interface MessRepository {

    void save(MessEntity mess);

    List<MessEntity> findAll();

    MessOwnerEntity findOwnerByMessId(Long id);

    MessEntity findMessById(Long id);

}

