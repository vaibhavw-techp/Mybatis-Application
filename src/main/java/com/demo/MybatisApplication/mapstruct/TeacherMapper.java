package com.demo.MybatisApplication.mapstruct;

import com.demo.MybatisApplication.dto.TeacherAdditionDto;
import com.demo.MybatisApplication.dto.TeacherDisplayDto;
import com.demo.MybatisApplication.dto.TeacherDisplayWithIdDto;
import com.demo.MybatisApplication.dto.TeacherSubjectDisplayDto;
import com.demo.MybatisApplication.model.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "email", target = "email")
    TeacherDisplayDto teacherEntityToTeacherDisplayDto(TeacherEntity entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "email", target = "email")
    TeacherDisplayWithIdDto teacherEntityToTeacherDisplayWithIdDto(TeacherEntity teacherEntity);

    List<TeacherDisplayWithIdDto> teacherDiplayIdDtosFromEntities(List<TeacherEntity> teacherEntities);
    @Mapping(source = "teacherAddDto.name", target = "name")
    @Mapping(source = "teacherAddDto.age", target = "age")
    @Mapping(source = "teacherAddDto.email", target = "email")
    TeacherEntity teacherAddDtoToTeacherEntity(TeacherAdditionDto teacherAddDto);

    TeacherSubjectDisplayDto teacherEntityToTeacherSubjectDisplayDto(TeacherEntity teacher);
}
