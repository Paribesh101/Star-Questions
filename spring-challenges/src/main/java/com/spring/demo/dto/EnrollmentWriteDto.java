package com.spring.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

public class EnrollmentWriteDto {

    @JsonProperty("student_id")
    @NotNull
    private Integer studentId;

    @JsonProperty("course_id")
    @NotNull
    private Integer courseId;

    public Integer getStudentId() {
        return studentId;
    }
    
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    
    public Integer getCourseId() {
        return courseId;
    }
    
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}