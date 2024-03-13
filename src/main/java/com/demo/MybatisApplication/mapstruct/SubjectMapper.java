package com.demo.MybatisApplication.mapstruct;

import com.demo.MybatisApplication.dto.SubjectAdditionDto;
import com.demo.MybatisApplication.dto.SubjectDisplayDto;
import com.demo.MybatisApplication.dto.SubjectEntityDto;
import com.demo.MybatisApplication.model.SubjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    @Mapping(target = "teacher", source = "dto.teacher")
    @Mapping(target = "name", source = "dto.name")
    SubjectEntity subjectAdditionDtoToSubjectEntity(SubjectAdditionDto dto);

    @Mapping(target = "subjectId", source = "subjectEntity.subjectId")
    @Mapping(target = "name", source = "subjectEntity.name")
    SubjectEntityDto subjectEntityToSubjectDisplayDto(SubjectEntity subjectEntity);

    List<SubjectDisplayDto> subjectEntitiesToSubjectDisplayDtos(List<SubjectEntity> subjectEntities);

    List<SubjectEntity> convertSubjectAddtionDtosToSubjectEntitities(List<SubjectAdditionDto> subjects);

}
