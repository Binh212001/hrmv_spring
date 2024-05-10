package com.example.hrms.form;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ContractForm {
    Long employeeId;
    Long id;

    String contractType;

    LocalDate startDate;

    LocalDate endDate;

    BigDecimal salary;

    Long hoursPerWeek;
}
