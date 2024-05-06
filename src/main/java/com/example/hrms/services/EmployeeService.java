package com.example.hrms.services;

import com.example.hrms.dto.EmployeeDto;
import com.example.hrms.form.EmployeeForm;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeDto> getEmployees(Long role_id) throws Exception;
    public  EmployeeDto ObjectToEmployeeDto(Object[] obj);

    List<EmployeeDto> getEmployeeById(Long employeeId) throws Exception;

    List<EmployeeDto> getEmployeeByFullName(String fullName)throws Exception;

    List<EmployeeDto> getEmployeeAtDepartment(Long departmentId) throws Exception;

    boolean create(EmployeeForm employeeForm) throws Exception;

    boolean update(EmployeeForm employeeForm) throws  Exception;
}
