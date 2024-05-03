package com.example.hrms.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;
    @OneToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    private Date startDate;
    private Date endDate;
    private String contractType;
    private Double salary;

}
