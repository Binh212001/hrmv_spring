package com.example.hrms.form;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class PositionForm {
    private Long id;
    private String positionTitle;
    private String description;
    private BigDecimal salary;
    private Long gradeLevel;
}
