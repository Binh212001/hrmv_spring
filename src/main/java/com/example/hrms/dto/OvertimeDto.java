package com.example.hrms.dto;

import com.example.hrms.entities.Status;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.hrms.entities.Overtime}
 */
@Data
@Builder
public class OvertimeDto implements Serializable {
    Long id;
    Long employeeId;
    String employeeName;
    LocalDate date;
    BigDecimal hoursWorked;
    String reason;
    Status status;
}