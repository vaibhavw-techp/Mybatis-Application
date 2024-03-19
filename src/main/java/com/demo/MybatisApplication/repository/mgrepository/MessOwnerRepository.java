package com.demo.MybatisApplication.repository.mgrepository;

import com.demo.MybatisApplication.model.mgmodel.MessOwnerEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessOwnerRepository {

    void save(MessOwnerEntity messOwner);

    List<MessOwnerEntity> findAll();

}
