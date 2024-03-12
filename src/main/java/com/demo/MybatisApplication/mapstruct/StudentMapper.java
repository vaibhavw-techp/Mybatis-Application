package com.demo.MybatisApplication.mapstruct;

import com.demo.MybatisApplication.dto.StudentAddDto;
import com.demo.MybatisApplication.dto.StudentDisplayAsSubjects;
import com.demo.MybatisApplication.dto.StudentDisplayByIdDto;
import com.demo.MybatisApplication.dto.StudentsDisplayDto;
import com.demo.MybatisApplication.model.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "studentName", target = "studentName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "age", target = "age")
    StudentEntity studentAddDtoToEntity(StudentAddDto dto);

    @Mapping(source = "studentName", target = "studentName")
    @Mapping(source = "studentSubjects", target = "studentSubjects")
    StudentDisplayAsSubjects studentEntityToDisplayAsSubjects(StudentEntity entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "studentName", target = "studentName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "age", target = "age")
    StudentDisplayByIdDto studentEntityToDisplayByIdDto(StudentEntity entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "studentName", target = "studentName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "age", target = "age")
    List<StudentsDisplayDto> studentEntitiesToDisplayDtos(List<StudentEntity> entities);
}
