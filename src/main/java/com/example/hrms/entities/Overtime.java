package com.example.hrms.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Time;
import java.util.Date;


@Entity
@Data
public class Overtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long overtimeId;

    private Long employeeId;
    private Date date;
    private Time startTime;
    private Time endTime;
    private Double hours;
}

