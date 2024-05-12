package com.example.hrms.repo;

import com.example.hrms.entities.Employee;
import com.example.hrms.entities.Overtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OvertimeRepository extends JpaRepository<Overtime, Long> {
    List<Overtime> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<Overtime> findByDate(LocalDate date);

    List<Overtime> findByEmployee(Employee employee);
}