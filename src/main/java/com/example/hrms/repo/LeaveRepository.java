package com.example.hrms.repo;

import com.example.hrms.entities.Employee;
import com.example.hrms.entities.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {
    @Query("SELECT e FROM Leave e WHERE e.startDate >= :startDate AND e.endDate <= :endDate")
    List<Leave> findByStartDateAndEndDate(LocalDate startDate, LocalDate endDate);

    List<Leave> findByEmployee(Employee employee);
}