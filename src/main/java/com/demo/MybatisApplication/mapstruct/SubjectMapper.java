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

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    @Mapping(target = "teacher", expression = "java(convertTeacherIdToEntity(subjectAdditionDto.getTeacherId()))")
//    @Mapping(target = "teacher.id", source = "subjectAdditionDto.teacherId")
    @Mapping(target = "name", source = "subjectAdditionDto.name")
    SubjectEntity mapSubjectAdditionDtoToSubjectEntity(SubjectAdditionDto subjectAdditionDto);

    @Mapping(target = "id", source = "subjectEntity.id")
    @Mapping(target = "name", source = "subjectEntity.name")
    @Mapping(target = "teacherId", source = "subjectEntity.teacher.id")
    SubjectEntityDisplayDto mapSubjectEntityToSubjectDisplayDto(SubjectEntity subjectEntity);

    @Mapping(target = "name", source = "subjectDto.name")
    @Mapping(target = "id", source = "subjectDto.id")
    @Mapping(target = "teacher", expression = "java(convertTeacherIdToEntity(subjectDto.getTeacherId()))")
    SubjectEntity mapSubjectEntityDisplayDtoToSubjectEntity(SubjectEntityDisplayDto subjectDto);

    List<SubjectDisplayDto> mapSubjectEntitiesToDtos(List<SubjectEntity> subjects);

    List<SubjectEntity> mapSubjectAddtionDtosToSubjectEntities(List<SubjectAdditionDto> subjects);

    default TeacherEntity convertTeacherIdToEntity(Long teacherId) {
        if (teacherId == null) {
            return null;
        }
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(teacherId);
        return teacherEntity;
    }

}
