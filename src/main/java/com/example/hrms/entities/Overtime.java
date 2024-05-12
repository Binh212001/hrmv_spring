package com.example.hrms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "overtime")
public class Overtime {
    @Id
    @Column(name = "overtime_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "hours_worked", precision = 5, scale = 2)
    private BigDecimal hoursWorked;

    @Column(name = "reason", length = Integer.MAX_VALUE)
    private String reason;


    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private  Status status;

    @PrePersist
    protected  void onCreate(){
        this.status = Status.DRAFT;
    }


}