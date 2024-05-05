package com.example.hrms.services;

import com.example.hrms.dto.EmployeeDto;
import com.example.hrms.entities.Employee;
import com.example.hrms.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements  EmployeeService{
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<EmployeeDto> getEmployees(Long roleId) throws Exception {
      try {
         List<Object[]> results =  employeeRepo.findEmployeeByRole(roleId);
         List<EmployeeDto> employeeDtos = results.stream()
                 .map(obj -> ObjectToEmployeeDto(obj))
                 .collect(Collectors.toList());
         return  employeeDtos;
      }catch (Exception e) {
          throw  new Exception("Unable to get employees");
      }
    }

    @Override
    public List<EmployeeDto> getEmployeeById(Long employeeId) throws Exception {
        try {
            List<Object[]> results =  employeeRepo.findEmployeeByEmployeeId(employeeId);
            List<EmployeeDto> employeeDtos = results.stream()
                    .map(obj -> ObjectToEmployeeDto(obj))
                    .collect(Collectors.toList());
            return  employeeDtos;
        }catch (Exception e) {
            throw  new Exception("Unable to get employees");
        }
    }

    @Override
    public List<EmployeeDto> getEmployeeByFullName(String fullName) throws Exception {
        try {
            List<Object[]> results =  employeeRepo.findEmployeeByEmployeeFullName(fullName);
            List<EmployeeDto> employeeDtos = results.stream()
                    .map(obj -> ObjectToEmployeeDto(obj))
                    .collect(Collectors.toList());
            return  employeeDtos;
        }catch (Exception e) {
            throw  new Exception(e.getMessage());
        }
    }


    public  EmployeeDto ObjectToEmployeeDto(Object[] obj){
        return new EmployeeDto(
                (Long) obj[0]
                ,(String) obj[1]
                ,(String) obj[2]
                ,(String) obj[3]
                ,(Date) obj[4]
                ,(Date) obj[5]
                ,(Long) obj[6]
                ,(Long) obj[7]
                ,(String) obj[8]
                ,(String) obj[9]
                ,( Long) obj[10]
                ,( String) obj[11]
        );
    }



    public  EmployeeDto  mapToEmployeeDto(Employee employee){
        return   EmployeeDto
                .builder()
                .email(employee.getEmail())
                .employeeId(employee.getEmployeeId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .gender(employee.getGender())
                .dateOfBirth(employee.getDateOfBirth())
                .hireDate(employee.getHireDate())
                .departmentId(employee.getDepartmentId())
                .positionId(employee.getPositionId())
                .email(employee.getEmail())
                .phoneNumber(employee.getPhoneNumber())
                .build();
    }
}
