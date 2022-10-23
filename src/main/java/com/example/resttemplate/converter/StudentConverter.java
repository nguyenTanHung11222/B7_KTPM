package com.example.resttemplate.converter;

import com.example.resttemplate.dto.StudentDto;
import com.example.resttemplate.entity.Student;

public class StudentConverter {
    public Student ToStudent(StudentDto dto) {
        Student student = new Student();
        student.setTenSV(dto.getTenSV());
        student.setTuoiSV(dto.getTuoiSV());
        return student;
    }
    public Student ToStudent(StudentDto dto,Student student) {
        student.setTenSV(dto.getTenSV());
        student.setTuoiSV(dto.getTuoiSV());
        return student;
    }
    public StudentDto toDTO(Student entity) {
        StudentDto dto = new StudentDto();
        if (entity.getMaSV() != null) {
            dto.setMaSV(entity.getMaSV());
        }
        dto.setTenSV(entity.getTenSV());
        dto.setTuoiSV(entity.getTuoiSV());
        return dto;
    }
}
