package com.example.hrms.form;

import lombok.Data;

import java.util.Date;
@Data
public class LeaveForm {

    private Long employeeId;
    private String leaveType;
    private Date startDate;
    private Date endDate;
    private Double duration;
    private String reason;
}
