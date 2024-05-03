package com.example.hrms.repo;

import com.example.hrms.entities.Workshift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingShiftRepo extends JpaRepository<Workshift, Long> {
}
