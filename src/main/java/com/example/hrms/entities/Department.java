package com.example.hrms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "department")
public class Department implements Serializable {
    @Id
    @Column(name = "department_id", nullable = false)
    private Long id;

    @Column(name = "department_name", length = 100)
    private String departmentName;

    @Column(name = "manager_id")
    private Long managerId;

}