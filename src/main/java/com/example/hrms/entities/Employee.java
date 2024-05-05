package com.example.hrms.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


@Entity
@Data
public class Employee{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @Column(unique = true , nullable = false)
    private  String username ;
    @Column(nullable = false)
    private  String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private String fullName;
    private String gender;
    private Date dateOfBirth;
    private Date hireDate;
    private Long departmentId;
    private Long positionId;
    private String email;
    private String phoneNumber;
    private String image;


   @ManyToMany
   @JoinTable(
            name = "employee_role",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> role;
    @PrePersist
    protected void onCreate() {
        this.fullName= this.firstName+ " "+this.lastName;
        this.password = this.username;
    }


}

