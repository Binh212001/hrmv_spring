package com.example.hrms.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.example.hrms.entities.Position}
 */
@Data
public class PositionDto implements Serializable {
    Integer id;
    String positionTitle;
    String description;
    BigDecimal salary;
    Integer gradeLevel;
}