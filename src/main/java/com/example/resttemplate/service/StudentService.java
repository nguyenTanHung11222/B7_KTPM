package com.example.resttemplate.service;


import com.example.resttemplate.entity.Student;
import com.example.resttemplate.exception.ResourceNotFoundException;
import com.example.resttemplate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentrepository;

    public Student CreatStudent(Student theStudent){
        return studentrepository.save(theStudent);
    }

    public List<Student> getAllStudent(){
        return studentrepository.findAll();
    }

   public ResponseEntity<Student> getStudentById(String Id) throws ResourceNotFoundException {
       Student student =  studentrepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("User not found for this id :"+Id));
        return ResponseEntity.ok().body(student);
    }
    public ResponseEntity<Student> updateStudent(String Id,Student studentDetails ) throws ResourceNotFoundException {
        Student student =  studentrepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("User not found for this id :"+Id));
        student.setTenSV(studentDetails.getTenSV());
        student.setTuoiSV(studentDetails.getTuoiSV());
        studentrepository.save(student);
        return ResponseEntity.ok().body(student);
    }
    public ResponseEntity<Object> deteleStudent(String Id) throws ResourceNotFoundException {
        Student student =  studentrepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("User not found for this id :"+Id));
        studentrepository.deleteById(Id);
        return ResponseEntity.ok().build();
    }
}