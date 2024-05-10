package com.example.hrms.dto;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.hrms.entities.Contract}
 */
@Value
public class ContractDto implements Serializable {
    Integer id;
    String contractType;
    LocalDate startDate;
    LocalDate endDate;
    BigDecimal salary;
    Integer hoursPerWeek;
}