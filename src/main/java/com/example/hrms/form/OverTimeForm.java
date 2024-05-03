package com.example.hrms.form;

import lombok.Data;

import java.sql.Time;
import java.util.Date;
@Data
public class OverTimeForm {

    private Long employeeId;
    private Date date;
    private Time startTime;
    private Time endTime;
    private Double hours;
}
