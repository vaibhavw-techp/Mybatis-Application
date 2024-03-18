package com.demo.MybatisApplication.mapstruct;

import com.demo.MybatisApplication.dto.StudentAdditionDto;
import com.demo.MybatisApplication.dto.StudentSubjectsDisplayDto;
import com.demo.MybatisApplication.dto.StudentDisplayDto;
import com.demo.MybatisApplication.model.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = SubjectMapper.class)
public interface StudentMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "age", target = "age")
    StudentEntity mapStudentAddDtoToEntity(StudentAdditionDto dto);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "subjects", target = "subjects")
    StudentSubjectsDisplayDto mapStudentEntityToStudentSubjectsDisplayDto(StudentEntity studentEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "age", target = "age")
    StudentDisplayDto mapStudentEntityToDisplayByIdDto(StudentEntity entity);

    List<StudentDisplayDto> mapStudentEntitiesToDisplayDtos(List<StudentEntity> entities);
}
