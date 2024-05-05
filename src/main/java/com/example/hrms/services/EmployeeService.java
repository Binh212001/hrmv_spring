package com.example.hrms.services;

import com.example.hrms.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeDto> getEmployees(Long role_id) throws Exception;
    public  EmployeeDto ObjectToEmployeeDto(Object[] obj);

    List<EmployeeDto> getEmployeeById(Long employeeId) throws Exception;

    List<EmployeeDto> getEmployeeByFullName(String fullName)throws Exception;
}
