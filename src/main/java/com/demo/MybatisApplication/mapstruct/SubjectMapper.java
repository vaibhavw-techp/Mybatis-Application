package com.demo.MybatisApplication.mapstruct;

import com.demo.MybatisApplication.dto.SubjectAdditionDto;
import com.demo.MybatisApplication.dto.SubjectDisplayDto;
import com.demo.MybatisApplication.dto.SubjectEntityDisplayDto;
import com.demo.MybatisApplication.model.SubjectEntity;
import com.demo.MybatisApplication.model.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = TeacherMapper.class)
public interface SubjectMapper {

    @Mapping(target = "teacher.id", source = "subjectAdditionDto.teacherId")
    @Mapping(target = "name", source = "subjectAdditionDto.name")
    SubjectEntity mapSubjectAdditionDtoToSubjectEntity(SubjectAdditionDto subjectAdditionDto);

    @Mapping(target = "id", source = "subjectEntity.id")
    @Mapping(target = "name", source = "subjectEntity.name")
    @Mapping(target = "teacher", source = "subjectEntity.teacher")
    SubjectEntityDisplayDto mapSubjectEntityToSubjectDisplayDto(SubjectEntity subjectEntity);

    List<SubjectDisplayDto> mapSubjectEntitiesToDtos(List<SubjectEntity> subjects);

    List<SubjectEntity> mapSubjectAddtionDtosToSubjectEntities(List<SubjectAdditionDto> subjects);

}
