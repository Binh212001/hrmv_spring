package com.example.hrms.services;

import com.example.hrms.dto.EmployeeDto;
import com.example.hrms.form.EmployeeForm;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetListOutput;
import com.example.hrms.utils.GetOutput;

import java.util.List;

public interface EmployeeService {
    AddOutPut add(EmployeeForm employeeForm) throws Exception;

    GetListOutput getAll() throws Exception;

    GetListOutput getEmployeeByDepartment(Long departmentId)throws Exception;

    EmployeeDto getEmployeeById(Long employeeId) throws Exception;

    GetListOutput getByName(String name) throws Exception;

    AddOutPut update(EmployeeForm employeeForm) throws  Exception;
}
