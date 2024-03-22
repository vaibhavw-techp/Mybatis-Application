package com.demo.MybatisApplication.mapstruct;

import com.demo.MybatisApplication.dto.TeacherAdditionDto;
import com.demo.MybatisApplication.dto.TeacherDisplayDto;
import com.demo.MybatisApplication.dto.TeacherEntityDisplayDto;
import com.demo.MybatisApplication.model.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = SubjectMapper.class)
public interface TeacherMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "email", target = "email")
    TeacherDisplayDto mapTeacherEntityToTeacherDisplayDto(TeacherEntity entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "email", target = "email")
    TeacherEntityDisplayDto mapTeacherEntityToTeacherEntityDisplayDto(TeacherEntity entity);

    @Mapping(source = "teacherAddDto.name", target = "name")
    @Mapping(source = "teacherAddDto.age", target = "age")
    @Mapping(source = "teacherAddDto.email", target = "email")
    TeacherEntity mapTeacherAddDtoToTeacherEntity(TeacherAdditionDto teacherAddDto);

    List<TeacherEntityDisplayDto> mapTeacherEntitiesToTeacherEntityDisplayDto(List<TeacherEntity> teacherEntities);
}
