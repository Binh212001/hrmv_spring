package com.example.hrms.form;

import com.example.hrms.entities.Employee;
import com.example.hrms.entities.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Getter
@Setter
public class OvertimeForm {
    private Long id;

    private Long employeeId;
    private LocalDate date;

    private BigDecimal hoursWorked;
    private LocalDate startDate;

    private LocalDate endDate;

    private String reason;

    private Status status;
}
