package com.demo.MybatisApplication.mapstruct;

import com.demo.MybatisApplication.dto.SubjectAdditionDto;
import com.demo.MybatisApplication.dto.SubjectDisplayDto;
import com.demo.MybatisApplication.model.SubjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    @Mapping(target = "subjectId", source = "dto.subjectId")
    @Mapping(target = "teacher", source = "dto.teacher")
    @Mapping(target = "name", source = "dto.name")
    SubjectEntity subjectAdditionDtoToSubjectEntity(SubjectAdditionDto dto);

    @Mapping(target = "subjectId", source = "subjectEntity.subjectId")
    @Mapping(target = "name", source = "subjectEntity.name")
    SubjectDisplayDto subjectEntityToSubjectDisplayDto(SubjectEntity subjectEntity);

    List<SubjectDisplayDto> convertEntityListToDtoList(List<SubjectEntity> subjects);

    List<SubjectEntity> convertSubjectAddtionDtoToSubjectEntity(List<SubjectAdditionDto> subjects);

}
