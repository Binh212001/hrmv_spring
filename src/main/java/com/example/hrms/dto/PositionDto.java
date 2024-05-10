package com.example.hrms.dto;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.example.hrms.entities.Position}
 */
@Value
public class PositionDto implements Serializable {
    Integer id;
    String positionTitle;
    String description;
    BigDecimal salary;
    Integer gradeLevel;
}