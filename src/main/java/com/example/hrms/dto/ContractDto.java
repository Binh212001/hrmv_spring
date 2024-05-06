package com.example.hrms.dto;

import com.example.hrms.entities.Employee;
import com.example.hrms.utils.BaseResponse;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class ContractDto   {
    private Long contractId;
    private Employee employee;
    private Date startDate;
    private Date endDate;
    private String contractType;
    private Double salary;
}
