package com.example.hrms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "leave")
public class Leave {
    @Id
    @Column(name = "leave_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "leave_type", length = 50)
    private String leaveType;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

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