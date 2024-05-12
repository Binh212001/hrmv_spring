package com.example.hrms.form;

import com.example.hrms.entities.Employee;
import com.example.hrms.entities.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
public class LeaveForm {
    private Long id;

    private Long employeeId;

    private String leaveType;

    private LocalDate startDate;

    private LocalDate endDate;

    private String reason;

    private Status status;
}
