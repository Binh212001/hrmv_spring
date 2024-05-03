package com.example.hrms.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    private String departmentName;
    @OneToMany
    @JoinColumn(name = "employeeId")
    private List<Employee> employees;
}