package com.example.hrms.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveId;

    private Long employeeId;
    private String leaveType;
    private Date startDate;
    private Date endDate;
    private Double duration;
    private String reason;
}

