package com.demo.MybatisApplication.mapstruct.mgmapstruct;

import com.demo.MybatisApplication.dto.mgdto.MessDisplayDto;
import com.demo.MybatisApplication.dto.mgdto.MessOwnerAdditionDto;
import com.demo.MybatisApplication.dto.mgdto.MessOwnerDisplayDto;
import com.demo.MybatisApplication.model.mgmodel.MessEntity;
import com.demo.MybatisApplication.model.mgmodel.MessOwnerEntity;
import org.mapstruct.Mapping;

import java.util.List;

public interface MessOwnerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "messOwnerAdditionDto.name")
    @Mapping(target = "contactNumber", source = "messOwnerAdditionDto.contactNumber")
    @Mapping(target = "mess", source = "messEntity")
    MessOwnerEntity mapMessOwnerAdditionDtoToMessOwnerEntity(MessOwnerAdditionDto messOwnerAdditionDto, MessEntity messEntity);

    @Mapping(target = "id", source = "messOwnerEntity.id")
    @Mapping(target = "name", source = "messOwnerEntity.name")
    @Mapping(target = "contactNumber", source = "messOwnerEntity.contactNumber")
    @Mapping(target = "messId", source = "messOwnerEntity.mess.id")
    MessOwnerDisplayDto mapMessOwnerEntityToMessOwnerDisplayDto(MessOwnerEntity messOwnerEntity);

    List<MessOwnerDisplayDto> mapMessOwnerEntitiesToMessDisplayDtos(List<MessOwnerEntity> messOwnerEntities);
}
