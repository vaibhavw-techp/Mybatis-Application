package com.demo.MybatisApplication.service.mgservice;

import com.demo.MybatisApplication.dto.mgdto.HostelAdditionDto;
import com.demo.MybatisApplication.dto.mgdto.HostelDisplayDto;
import com.demo.MybatisApplication.mapstruct.mgmapstruct.HostelMapper;
import com.demo.MybatisApplication.model.mgmodel.HostelEntity;
import com.demo.MybatisApplication.repository.mgrepository.HostelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelService {

    @Autowired
    private HostelRepository hostelRepository;

    @Autowired
    private HostelMapper hostelMapper;

    public HostelDisplayDto createHostel(HostelAdditionDto hostel) {
        HostelEntity hostelEntity = hostelMapper.mapHostelAdditionDtoToHostelEntity(hostel);
        hostelRepository.save(hostelEntity);
        return hostelMapper.mapHostelEntityToHostelDisplayDto(hostelEntity);
    }

    public List<HostelDisplayDto> getAllHostels() {
        return hostelMapper.mapHostelEntitiesToHostelDisplayDtos(hostelRepository.findAll());
    }

}