package com.example.hrms.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.hrms.entities.Overtime}
 */
@Data
public class OvertimeDto implements Serializable {
    Long id;
    String employeeName;
    LocalDate date;
    BigDecimal hoursWorked;
    String reason;
}