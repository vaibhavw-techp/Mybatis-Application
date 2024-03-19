package com.demo.MybatisApplication.repository.mgrepository;

import com.demo.MybatisApplication.config.MessManagementSQLConnMapper;
import com.demo.MybatisApplication.config.SchoolManagementSQLConnMapper;
import com.demo.MybatisApplication.model.mgmodel.HostelEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@MessManagementSQLConnMapper("HostelMapper")
public interface HostelRepository {

    void save(HostelEntity hostel);

    List<HostelEntity> findAll();
}
