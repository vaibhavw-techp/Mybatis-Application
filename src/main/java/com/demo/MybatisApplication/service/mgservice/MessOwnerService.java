package com.demo.MybatisApplication.service.mgservice;

import com.demo.MybatisApplication.model.mgmodel.MessOwnerEntity;
import com.demo.MybatisApplication.repository.mgrepository.HostelRepository;
import com.demo.MybatisApplication.repository.mgrepository.MessOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessOwnerService {

    @Autowired
    private MessOwnerRepository messOwnerRepository;

//    @Autowired
//    public MessOwnerService(@Qualifier("sqlSessionTemplate1") HostelRepository hostelRepository) {
//        this.messOwnerRepository = messOwnerRepository;
//    }

    public MessOwnerEntity createMessOwner(MessOwnerEntity messOwner) {
        messOwnerRepository.save(messOwner);
        return messOwner;
    }

    public List<MessOwnerEntity> getAllMessOwners() {
        return messOwnerRepository.findAll();
    }

}

