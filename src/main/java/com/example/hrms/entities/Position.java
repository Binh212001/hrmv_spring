package com.example.hrms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "\"position\"")
public class Position {
    @Id
    @Column(name = "position_id", nullable = false)
    private Long id;

    @Column(name = "position_title", length = 100)
    private String positionTitle;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "salary", precision = 10, scale = 2)
    private BigDecimal salary;

    @Column(name = "grade_level")
    private Long gradeLevel;

}