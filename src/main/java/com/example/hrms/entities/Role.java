package com.example.hrms.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String roleName;

}