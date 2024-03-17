package com.demo.MybatisApplication.mapstruct;

import com.demo.MybatisApplication.dto.TeacherAdditionDto;
import com.demo.MybatisApplication.dto.TeacherDisplayDto;
import com.demo.MybatisApplication.dto.TeacherDisplayInfoDto;
import com.demo.MybatisApplication.dto.TeacherSubjectDisplayDto;
import com.demo.MybatisApplication.model.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = SubjectMapper.class)
public interface TeacherMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "email", target = "email")
    TeacherDisplayDto teacherEntityToTeacherDisplayDto(TeacherEntity entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "email", target = "email")
    TeacherDisplayInfoDto teacherEntityToTeacherDisplayInfoDto(TeacherEntity teacherEntity);

    @Mapping(source = "teacherAddDto.name", target = "name")
    @Mapping(source = "teacherAddDto.age", target = "age")
    @Mapping(source = "teacherAddDto.email", target = "email")
    TeacherEntity teacherAddDtoToTeacherEntity(TeacherAdditionDto teacherAddDto);

    List<TeacherDisplayInfoDto> teacherDisplayInfoDtosFromEntities(List<TeacherEntity> teacherEntities);

    TeacherSubjectDisplayDto teacherEntityToTeacherSubjectDisplayDto(TeacherEntity teacher);
}
