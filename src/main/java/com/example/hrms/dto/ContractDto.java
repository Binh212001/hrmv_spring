package com.example.hrms.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.hrms.entities.Contract}
 */
@Builder
@Data

public class ContractDto implements Serializable {
    Long id;
    String employeeName;
    String contractType;
    LocalDate startDate;
    LocalDate endDate;
    BigDecimal salary;
    Long hoursPerWeek;

}