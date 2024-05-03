package com.example.hrms.entities;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity

@Data
public class Employee implements UserDetails {

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
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @PrePersist
    protected void onCreate() {
        this.fullName= this.firstName+ " "+this.lastName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

