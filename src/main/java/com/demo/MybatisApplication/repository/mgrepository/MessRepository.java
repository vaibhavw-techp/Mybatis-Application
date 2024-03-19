package com.demo.MybatisApplication.repository.mgrepository;

import com.demo.MybatisApplication.model.mgmodel.MessEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessRepository {

    void save(MessEntity mess);

    List<MessEntity> findAll();

}

