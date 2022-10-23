package com.example.resttemplate.controller;


import com.example.resttemplate.entity.Student;
import com.example.resttemplate.exception.ResourceNotFoundException;
import com.example.resttemplate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //Nguyên danh sách
    @GetMapping("/Student")
    public List<Student> getAllUser(){
        return studentService.getAllStudent();
    }
    // Dang ký mới
    @PostMapping("/Student")
    public Student createStudent(@Valid @RequestBody Student student){
        return studentService.CreatStudent(student);
    }
    //Get 1 Student theo id
    @GetMapping("/Student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") String studentId) throws ResourceNotFoundException {
        return studentService.getStudentById(studentId);
    }
    // update
    @PutMapping("/Student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") String studentId, @RequestBody Student studentDetails ) throws ResourceNotFoundException {
        return studentService.updateStudent(studentId,studentDetails);
    }
    //detele
    @DeleteMapping("/Student/{id}")
    public ResponseEntity<Object> deteleStudent(@PathVariable(value = "id") String studentId) throws ResourceNotFoundException {
        return studentService.deteleStudent(studentId);
    }
}
