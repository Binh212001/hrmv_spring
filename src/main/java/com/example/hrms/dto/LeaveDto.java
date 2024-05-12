package com.example.hrms.dto;

import com.example.hrms.entities.Leave;
import com.example.hrms.entities.Status;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Leave}
 */
@Data
@Builder
public class LeaveDto implements Serializable {
    Long id;
    String employeeName;
    String leaveType;
    LocalDate startDate;
    LocalDate endDate;
    String reason;
    Status status;
}