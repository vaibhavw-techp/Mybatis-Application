package com.demo.MybatisApplication.mapstruct.mgmapstruct;

import com.demo.MybatisApplication.dto.mgdto.MessAdditionDto;
import com.demo.MybatisApplication.dto.mgdto.MessDisplayDto;
import com.demo.MybatisApplication.model.mgmodel.MessEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "messAdditionDto.name")
    @Mapping(target = "capacity", source = "messAdditionDto.capacity")
    @Mapping(target = "location", source = "messAdditionDto.location")
    MessEntity mapMessAdditionDtoToMessEntity(MessAdditionDto messAdditionDto);

    @Mapping(target = "id", source = "mess.id")
    @Mapping(target = "name", source = "mess.name")
    @Mapping(target = "capacity", source = "mess.capacity")
    @Mapping(target = "location", source = "mess.location")
    MessDisplayDto mapMessEntityToMessDisplayDto(MessEntity mess);

    List<MessDisplayDto> mapMessEntitiesToMessDisplayDtos(List<MessEntity> messEntities);

}
