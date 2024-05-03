package com.example.hrms.repo;

import com.example.hrms.entities.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepo extends JpaRepository<Leave,Long> {
}
