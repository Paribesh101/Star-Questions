package com.spring.demo.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.domain.Enrollment;
import com.spring.demo.dto.EnrollmentWriteDto;
import com.spring.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final StudentService studentService;

    public EnrollmentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Enrollment enrollStudent(@RequestBody @Valid EnrollmentWriteDto dto) { 
        return studentService.enrollStudent(dto);
    }
}