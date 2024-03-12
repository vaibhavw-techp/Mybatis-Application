package com.demo.MybatisApplication.mapstruct;

import com.demo.MybatisApplication.dto.TeacherDisplayDto;
import com.demo.MybatisApplication.dto.TeacherDisplayWithIdDto;
import com.demo.MybatisApplication.model.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    @Mapping(source = "teacherName", target = "teacherName")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "email", target = "email")
    TeacherDisplayDto teacherEntityToTeacherDisplayDto(TeacherEntity entity);

    @Mapping(source = "teacherId", target = "teacherId")
    @Mapping(source = "teacherName", target = "teacherName")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "email", target = "email")
    TeacherDisplayWithIdDto teacherEntityToTeacherDisplayWithIdDto(TeacherEntity entity);

    List<TeacherDisplayWithIdDto> getTeacherDiplayIdDtoFromEntity(List<TeacherEntity> teacherEntities);
}
