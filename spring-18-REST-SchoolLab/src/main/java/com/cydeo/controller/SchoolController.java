package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> readAllTeacher(){
        List<TeacherDTO> teachers = teacherService.findAll();
        return teachers;
    }
    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){
        return ResponseEntity.ok(new ResponseWrapper("students are successfully retrieved", studentService.findAll()));

    }
    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents(){
        ResponseWrapper responseWrapper= new ResponseWrapper(true,
                "students are successfully retrieved" , HttpStatus.OK.value(),parentService.findAll() );
        return ResponseEntity.status(HttpStatus.OK).body(responseWrapper);
    }



}
