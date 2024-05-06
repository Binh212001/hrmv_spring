package com.example.hrms.repo;

import com.example.hrms.entities.Contract;
import com.example.hrms.entities.Employee;
import com.example.hrms.form.ContractForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository

public interface ContractRepo extends JpaRepository<Contract, Long> {
    Optional<Contract> findByEmployee(Employee employee);
//    @Query(value = "insert into contract (employee_id, start_date , end_date ,salary, contract_type)" +
//            "values (:employeeId ,:startDate ,:endDate ," +
//            ":salary ,:contractType)" , nativeQuery = true)
//    void add(Long employeeId, Date startDate, Date endDate, Double salary, String contractType);
}
