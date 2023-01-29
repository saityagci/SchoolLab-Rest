package com.cydeo.controller;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final AddressService addressService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.addressService = addressService;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> allTeachers(){

        return teacherService.findAll();
    }
    @GetMapping("/student")
    public ResponseEntity<ResponseWrapper> readAllStudent(){
        return ResponseEntity.ok(new ResponseWrapper("Student are successfully retrieve",
                studentService.findAll()));
    }
        @GetMapping("/parent")
    public ResponseEntity<ResponseWrapper> readAllParents(){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("Parents","Return")
                .body(new ResponseWrapper("Parents are successfully retrieved",
                        parentService.findAll()));
    }
//    @GetMapping("/address/{id}")
//    public ResponseEntity<ResponseWrapper> getAddress(@PathVariable("id") Long id) throws Exception {
//        return ResponseEntity.ok(new ResponseWrapper("Address "+id+" is successfully retrieved",
//                addressService.findById(id)));
//
//    }
@GetMapping("/address/{id}")
public ResponseEntity<ResponseWrapper> getAddress(@PathVariable("id") Long id) throws Exception {
    AddressDTO addressToReturn = addressService.findById(id);

    return ResponseEntity.ok(new ResponseWrapper("Address "+id+" is successfully retrieved",addressToReturn));

}


}
