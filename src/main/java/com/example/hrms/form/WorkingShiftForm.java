package com.example.hrms.form;

import com.example.hrms.entities.Status;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
@Data
public class WorkingShiftForm {
    private Long employeeId;
    private Date date;
    private Time startTime;
    private Time endTime;
    private String shiftType;
    private Status status;
}
