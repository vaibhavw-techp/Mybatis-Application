package com.demo.MybatisApplication.service.mgservice;

import com.demo.MybatisApplication.model.mgmodel.HostelEntity;
import com.demo.MybatisApplication.repository.mgrepository.HostelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelService {

    @Autowired
//    @Qualifier("sqlSessionTemplate2")
    private HostelRepository hostelRepository;

//    @Autowired
//    public HostelService(@Qualifier("sqlSessionTemplate2") HostelRepository hostelRepository) {
//        this.hostelRepository = hostelRepository;
//    }

    public HostelEntity createHostel(HostelEntity hostel) {
        hostelRepository.save(hostel);
        return hostel;
    }

    public List<HostelEntity> getAllHostels() {
        return hostelRepository.findAll();
    }

}