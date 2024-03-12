package com.demo.MybatisApplication.mapstruct;

import com.demo.MybatisApplication.dto.SubjectAdditionDto;
import com.demo.MybatisApplication.dto.SubjectDisplayDto;
import com.demo.MybatisApplication.dto.SubjectEntityDisplayDto;
import com.demo.MybatisApplication.model.SubjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    @Mapping(target = "teacher", source = "dto.teacher")
    @Mapping(target = "name", source = "dto.name")
    SubjectEntity subjectAdditionDtoToSubjectEntity(SubjectAdditionDto dto);

    @Mapping(target = "id", source = "subjectEntity.id")
    @Mapping(target = "name", source = "subjectEntity.name")
    SubjectEntityDisplayDto subjectEntityToSubjectDisplayDto(SubjectEntity subjectEntity);

    List<SubjectDisplayDto> EntitiesToDtos(List<SubjectEntity> subjects);

    List<SubjectEntity> SubjectAddtionDtosToSubjectEntities(List<SubjectAdditionDto> subjects);

}
