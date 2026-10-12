package com.spring.demo.rest;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import com.spring.demo.domain.Student;
import com.spring.demo.service.StudentService;

@Controller
public class StudentGraphQLController {

    private final StudentService studentService;


    public StudentGraphQLController(StudentService studentService){
        this.studentService = studentService;
    }

    @QueryMapping 
    public Student studentById(@Argument int id){
        return studentService.getStudentById(id);
    }

    @MutationMapping
    public Student createStudent(@Argument String firstName, @Argument String lastName, @Argument String email){
        return studentService.insertStudent(new Student(firstName, lastName, email));
    } 

}






