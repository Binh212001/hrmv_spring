package com.example.hrms.repo;

import com.example.hrms.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Optional<Employee> findByUsername(String username);
    @Query(value = "select      e.employee_id,\n" +
            "            e.first_name,\n" +
            "            e.last_name,\n" +
            "            e.gender,\n" +
            "            e.date_of_birth,\n" +
            "            e.hire_date,\n" +
            "           e.department_id,\n" +
            "            e.position_id,\n" +
            "            e.email,\n" +
            "            e.phone_number,\n" +
            "            er.role_id,\n" +
            "           e.image   , r.role_name     " +
            "from employee e  join employee_role er on er.employee_id = e.employee_id " +
            "join role r on er.role_id = r.id where er.role_id >=:role" , nativeQuery = true)
    List<Object[]> findEmployeeByRole(Long role);


    @Query(value = "select      e.employee_id,\n" +
            "            e.first_name,\n" +
            "            e.last_name,\n" +
            "            e.gender,\n" +
            "            e.date_of_birth,\n" +
            "            e.hire_date,\n" +
            "           e.department_id,\n" +
            "            e.position_id,\n" +
            "            e.email,\n" +
            "            e.phone_number,\n" +
            "            er.role_id,\n" +
            "      e.image   , r.role_name     " +
            "from employee e  join employee_role er on er.employee_id = e.employee_id " +
            "join role r on er.role_id = r.id where e.employee_id = :employee_id", nativeQuery = true)
    List<Object[]> findEmployeeByEmployeeId(Long employee_id);

    @Query(value = "select      e.employee_id,\n" +
            "            e.first_name,\n" +
            "            e.last_name,\n" +
            "            e.gender,\n" +
            "            e.date_of_birth,\n" +
            "            e.hire_date,\n" +
            "           e.department_id,\n" +
            "            e.position_id,\n" +
            "            e.email,\n" +
            "            e.phone_number,\n" +
            "            er.role_id,\n" +
            "           e.image    , r.role_name " +
            "from employee e  join employee_role er on er.employee_id = e.employee_id " +
            "join role r on er.role_id = r.id where e.full_name like %:fullName%", nativeQuery = true)
    List<Object[]> findEmployeeByEmployeeFullName(String fullName);
    @Query(value = "select      e.employee_id,\n" +
            "            e.first_name,\n" +
            "            e.last_name,\n" +
            "            e.gender,\n" +
            "            e.date_of_birth,\n" +
            "            e.hire_date,\n" +
            "           e.department_id,\n" +
            "            e.position_id,\n" +
            "            e.email,\n" +
            "            e.phone_number,\n" +
            "            er.role_id,\n" +
            "           e.image    , r.role_name " +
            "from employee e  join employee_role er on er.employee_id = e.employee_id " +
            "join role r on er.role_id = r.id where e.department_id =:departmentId", nativeQuery = true)
    List<Object[]> findEmployeeAtDepartment(Long departmentId);
}
