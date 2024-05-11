package com.example.hrms.repo;

import com.example.hrms.entities.Attendance;
import com.example.hrms.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByDate(LocalDate date);
    @Query( value ="SELECT a.attendance_id,a.employee_id,a.date, a.clock_in_time,a.clock_out_time,e.name" +
            " FROM attendance a join employee e on a.employee_id = e.employee_id " +
            " WHERE a.employee_id = :employeeId AND a.date BETWEEN :startDate AND :endDate",nativeQuery = true)
    List<Object[]> findByEmployeeAndDateBetween(LocalDate startDate, LocalDate endDate, Long employeeId);
    @Query( value ="select employee.employee_id as employee_id,employee.name as name,\n" +
            "       EXTRACT(YEAR FROM attendance.date) as year,\n" +
            "       EXTRACT(MONTH FROM attendance.date) as month\n" +
            "from attendance  join employee on employee.employee_id = employee.employee_id\n" +
            "GROUP BY employee.employee_id, name, year , month\n" +
            "order by  year,month desc",nativeQuery = true)
    List<Object[]> findEmploeeAteendance();
}