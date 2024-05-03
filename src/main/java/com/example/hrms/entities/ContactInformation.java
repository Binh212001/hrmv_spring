package com.example.hrms.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class ContactInformation {

    @Id
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    private Long contactId;

    private Long employeeId;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
