package com.demo.MybatisApplication.mapstruct.mgmapstruct;

import com.demo.MybatisApplication.dto.mgdto.HostelAdditionDto;
import com.demo.MybatisApplication.dto.mgdto.HostelDisplayDto;
import com.demo.MybatisApplication.mapstruct.SubjectMapper;
import com.demo.MybatisApplication.model.mgmodel.HostelEntity;
import org.apache.catalina.Host;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HostelMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "hostelAdditionDto.name")
    @Mapping(target = "address", source = "hostelAdditionDto.address")
    @Mapping(target = "capacity", source = "hostelAdditionDto.capacity")
    @Mapping(target = "numRooms", source = "hostelAdditionDto.numRooms")
    HostelEntity mapHostelAdditionDtoToHostelEntity(HostelAdditionDto hostelAdditionDto);

    @Mapping(target = "name", source = "hostelEntity.name")
    @Mapping(target = "address", source = "hostelEntity.address")
    @Mapping(target = "capacity", source = "hostelEntity.capacity")
    @Mapping(target = "numRooms", source = "hostelEntity.numRooms")
    HostelDisplayDto mapHostelEntityToHostelDisplayDto(HostelEntity hostelEntity);

    List<HostelDisplayDto> mapHostelEntitiesToHostelDisplayDtos(List<HostelEntity> hostelEntities);
}
