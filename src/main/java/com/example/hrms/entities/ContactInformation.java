package com.example.hrms.entities;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class ContactInformation {

    @Id
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    private Long contactId;
    @OneToOne
    private Employee employeeId;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
