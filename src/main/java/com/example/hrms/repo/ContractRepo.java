package com.example.hrms.repo;

import com.example.hrms.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContractRepo extends JpaRepository<Contract, Long> {
}
