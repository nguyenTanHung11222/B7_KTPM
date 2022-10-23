package com.example.resttemplate.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private String maSV;

    @Column(name = "student_name")
    private String tenSV;

    @Column(name = "student_age")
    private Integer tuoiSV;
}
