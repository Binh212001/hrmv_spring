package com.example.hrms.repo;

import com.example.hrms.entities.ContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInformationRepo extends JpaRepository<ContactInformation, Long> {
}
