package com.demo.MybatisApplication.service.mgservice;

import com.demo.MybatisApplication.dto.mgdto.MessOwnerAdditionDto;
import com.demo.MybatisApplication.dto.mgdto.MessOwnerDisplayDto;
import com.demo.MybatisApplication.mapstruct.mgmapstruct.MessMapper;
import com.demo.MybatisApplication.mapstruct.mgmapstruct.MessOwnerMapper;
import com.demo.MybatisApplication.model.mgmodel.MessEntity;
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

    @Autowired
    private MessOwnerMapper messOwnerMapper;


    public MessOwnerDisplayDto createMessOwner(MessOwnerAdditionDto messOwnerAdditionDto) {
        MessOwnerEntity messOwnerEntity = messOwnerMapper.mapMessOwnerAdditionDtoToMessOwnerEntity(messOwnerAdditionDto);
        return messOwnerMapper.mapMessOwnerEntityToMessOwnerDisplayDto(messOwnerEntity);
    }

    public List<MessOwnerDisplayDto> getAllMessOwners() {
        return messOwnerMapper.mapMessOwnerEntitiesToMessDisplayDtos(messOwnerRepository.findAll());
    }

}

