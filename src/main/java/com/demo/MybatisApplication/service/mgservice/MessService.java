package com.demo.MybatisApplication.service.mgservice;

import com.demo.MybatisApplication.dto.mgdto.MessAdditionDto;
import com.demo.MybatisApplication.dto.mgdto.MessDisplayDto;
import com.demo.MybatisApplication.dto.mgdto.MessOwnerDisplayDto;
import com.demo.MybatisApplication.dto.mgdto.MessOwnerDisplayInfoDto;
import com.demo.MybatisApplication.mapstruct.mgmapstruct.MessMapper;
import com.demo.MybatisApplication.model.mgmodel.MessEntity;
import com.demo.MybatisApplication.model.mgmodel.MessOwnerEntity;
import com.demo.MybatisApplication.repository.mgrepository.HostelRepository;
import com.demo.MybatisApplication.repository.mgrepository.MessOwnerRepository;
import com.demo.MybatisApplication.repository.mgrepository.MessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessService {

    @Autowired
    private MessRepository messRepository;

    @Autowired
    private MessMapper messMapper;

    @Autowired
    private MessOwnerRepository messOwnerRepository;

    public MessDisplayDto createMess(MessAdditionDto messAdditionDto) {
        MessEntity mess = messMapper.mapMessAdditionDtoToMessEntity(messAdditionDto);
        messRepository.save(mess);
        return messMapper.mapMessEntityToMessDisplayDto(mess);
    }

    public List<MessDisplayDto> getAllMess() {
        return messMapper.mapMessEntitiesToMessDisplayDtos(messRepository.findAll());
    }

    public MessOwnerDisplayInfoDto getOwnerByMessId(Long id){
        MessEntity messEntity = messRepository.findMessById(id);
        List<MessOwnerEntity> messOwnerEntities = messOwnerRepository.findOwnerByMessId(id);
        return messRepository.findOwnerByMessId(id);
    }

}

