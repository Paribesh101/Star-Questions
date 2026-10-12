package com.spring.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.spring.demo.exceptions.StudentErrorResponse;



import com.spring.demo.domain.Student;
import com.spring.demo.service.StudentService;

import jakarta.validation.Valid;




@Tag(name = "Students", description = "Operations for retrieving and managing students")
@RestController
@RequestMapping("/api/students")

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /*
            ANTI-PATTERNS - DON'T DO STUFF LIKE THIS
            http://localhost:8080/students/getstudent
            http://localhost:8080/students/deletestudent
            http://localhost:8080/students/updatestudent
    */

    // GET localhost:8080/api/students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

   @PostMapping
   public ResponseEntity<Student> insertStudent(@Valid @RequestBody Student student) {
       
        Student savedStudent = studentService.insertStudent(student);

        // localhost:8080/api/students/{id}
        return ResponseEntity
            .created(
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedStudent.getId())
                    .toUri()    
            )
            .body(savedStudent);
   }
   
   // route paramter - typically used for resource location
   // GET http://localhost:8080/api/students/3

   // query parameter - typically used for filtering/searching
   // GET http://localhost:8080/api/students?lastName=wilson&grade=b
   @Operation(
       summary = "Get a student by ID",
       description = "Returns a single student matching the given ID. "
                   + "Throws RecordNotFoundException if no student exists with that ID."
   )
   @ApiResponses({
       @ApiResponse(
           responseCode = "200",
           description = "Student found",
           content = @Content(
               mediaType = "application/json",
               schema = @Schema(implementation = Student.class)
           )
       ),
       @ApiResponse(
           responseCode = "404",
           description = "No student exists with that ID",
           content = @Content(
               mediaType = "application/json",
               schema = @Schema(implementation = StudentErrorResponse.class)
           )
       )
   })
   @GetMapping("/{id}")
   public Student getStudentById(
       @Parameter(description = "ID of the student to retrieve", example = "1", required = true)
       @PathVariable int id
   ) {
        return studentService.getStudentById(id);
   }

   // GET http://localhost:8080/api/students?lastName=wilson
   @GetMapping(params = "lastName")
   public List<Student> getStudentsByLastName(@RequestParam String lastName) {
    return studentService.getStudentsByLastName(lastName);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
    studentService.deleteStudent(id);
    return ResponseEntity.noContent().build();
   }

   @PutMapping("/{id}")
   public Student updateStudent(@PathVariable int id, @Valid @RequestBody Student student) {
       return studentService.updateStudent(id, student);
   }
    
   @GetMapping(params = "domain")
   public List<Student> findByEmailDomain(@RequestParam String domain){
        return studentService.findByEmailDomain(domain);
   }
   

}
