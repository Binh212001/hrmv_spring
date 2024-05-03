package com.example.hrms.repo;

import com.example.hrms.entities.Overtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OvertimeRepo extends JpaRepository<Overtime, Long> {
}
