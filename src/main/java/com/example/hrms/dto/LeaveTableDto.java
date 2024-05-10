package com.example.hrms.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.hrms.entities.LeaveTable}
 */
@Data
public class LeaveTableDto implements Serializable {
    Long id;
    String employeeName;
    String leaveType;
    LocalDate startDate;
    LocalDate endDate;
    String reason;
}