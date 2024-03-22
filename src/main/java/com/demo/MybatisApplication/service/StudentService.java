package com.demo.MybatisApplication.service;

import com.demo.MybatisApplication.dto.StudentAdditionDto;
import com.demo.MybatisApplication.dto.StudentSubjectsDisplayDto;
import com.demo.MybatisApplication.dto.StudentDisplayDto;
import com.demo.MybatisApplication.exceptions.ResourceNotFoundException;
import com.demo.MybatisApplication.model.StudentEntity;
import com.demo.MybatisApplication.model.SubjectEntity;
import com.demo.MybatisApplication.repository.StudentRepository;
import com.demo.MybatisApplication.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.demo.MybatisApplication.mapstruct.StudentMapper;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private SubjectService subjectService;

    public ResponseEntity<?> getStudentById(Long id){
        StudentEntity studentEntity = studentRepository.findStudentById(id);
        if (studentEntity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student with id " + id + " not found");
        }

        StudentDisplayDto studentDisplayDto = studentMapper.mapStudentEntityToStudentDisplayDto(studentEntity);
        return ResponseEntity.ok().body(studentDisplayDto);
    }

    public ResponseEntity<String> assignSubjectsToStudent(Long studentId, List<Long> subjectIds) {

        StudentEntity studentEntity = studentRepository.findStudentById(studentId);
        if (studentEntity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with id " + studentId + " not found");
        }

        if(subjectService.assignSubjectsToStudentHandling(subjectIds).equals("Done")){
            studentRepository.updateSubjectsToStudent(studentId, subjectIds);
        }
        else{
            return subjectService.assignSubjectsToStudentHandling(subjectIds);
        }

        return ResponseEntity.ok().build();
    }


    public StudentDisplayDto addStudent(StudentAdditionDto student){
        StudentEntity studentEntity = studentMapper.mapStudentAddDtoToStudentEntity(student);
        studentRepository.saveStudent(studentEntity);
        return studentMapper.mapStudentEntityToStudentDisplayDto(studentEntity);
    }

    public List<StudentDisplayDto> getAllStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAllStudents();
        return studentMapper.mapStudentEntitiesToDisplayDtos(studentEntities);
    }

    public ResponseEntity<?> getStudentWithSubjects(Long studentId) {
        StudentEntity studentEntity = studentRepository.findStudentWithSubjects(studentId);
        if (studentEntity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student with id " + studentId + " not found");
        }
        return ResponseEntity.ok().body(studentMapper.mapStudentEntityToStudentSubjectsDisplayDto(studentEntity));
    }
}
