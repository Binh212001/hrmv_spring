package com.example.hrms.repo;

import com.example.hrms.entities.Department;
import com.example.hrms.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
     List<Employee> getEmployeesByDepartment(Department department);

    Optional<Employee> findByEmail(String email);

    @Query(value = "SELECT Count(*) FROM employee WHERE  employee.department_id =:departmentId " , nativeQuery = true)
    Object[] findEmployeeByDepartment( Long departmentId);
}