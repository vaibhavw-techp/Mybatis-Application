package com.demo.MybatisApplication.service.mgservice;

import com.demo.MybatisApplication.model.mgmodel.MessEntity;
import com.demo.MybatisApplication.repository.mgrepository.HostelRepository;
import com.demo.MybatisApplication.repository.mgrepository.MessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessService {

    @Autowired
//    @Qualifier("sqlSessionTemplate1")
    private MessRepository messRepository;

//    @Autowired
//    public MessService(@Qualifier("sqlSessionTemplate1") HostelRepository hostelRepository) {
//        this.messRepository = messRepository;
//    }

    public MessEntity createMess(MessEntity mess) {
        messRepository.save(mess);
        return mess;
    }

    public List<MessEntity> getAllMess() {
        return messRepository.findAll();
    }


}

