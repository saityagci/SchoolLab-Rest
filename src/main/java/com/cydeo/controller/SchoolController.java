package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public List<TeacherDTO> allTeachers(){

        return teacherService.findAll();
    }
//    @GetMapping("/student")
//    public ResponseEntity<ResponseWrapper> readAllStudent(){
//        return ResponseEntity.ok(new ResponseWrapper("Student are successfully retrieve",
//                studentService.findAll()));
//    }
        @GetMapping("/parent")
    public ResponseEntity<ResponseWrapper> readAllParents(){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("Parents","Return")
                .body(new ResponseWrapper("Parents are successfully retrieved",
                        parentService.findAll()));
    }


}
