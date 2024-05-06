package com.example.hrms.services;

import com.example.hrms.dto.EmployeeDto;
import com.example.hrms.entities.Department;
import com.example.hrms.entities.Employee;
import com.example.hrms.form.EmployeeForm;
import com.example.hrms.repo.DepartmentRepo;
import com.example.hrms.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements  EmployeeService{
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    DepartmentRepo departmentRepo;

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

    @Override
    public List<EmployeeDto> getEmployeeAtDepartment(Long departmentId)  throws Exception {
        try {
            List<Object[]> results =  employeeRepo.findEmployeeAtDepartment(departmentId);
            List<EmployeeDto> employeeDtos = results.stream()
                    .map(obj -> ObjectToEmployeeDto(obj))
                    .collect(Collectors.toList());
            return  employeeDtos;
        }catch (Exception e) {
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public boolean create(EmployeeForm employeeForm) throws Exception {
       try {
           Employee e  = mapFormToEmployee(employeeForm);
           employeeRepo.save(e);
           return true;
       }catch (Exception e){
           throw  new Exception(e.getMessage());
       }
    }

    @Override
    public boolean update(EmployeeForm employeeForm) throws Exception {
        try {
            Optional<Employee> employee = employeeRepo.findById(employeeForm.getEmployeeId());
            if (employee.isPresent()){
                employee.get().setGender(employeeForm.getGender());
                employee.get().setFirstName(employeeForm.getFirstName());
                employee.get().setLastName(employeeForm.getLastName());
                employee.get().setDateOfBirth(employeeForm.getDateOfBirth());
                employee.get().setHireDate(employeeForm.getHireDate());
                employee.get().setDepartmentId(employeeForm.getDepartmentId());
                employee.get().setPositionId(employeeForm.getPositionId());
                employee.get().setEmail(employeeForm.getEmail());
                employee.get().setPhoneNumber(employeeForm.getPhoneNumber());
                employee.get().setImage(employeeForm.getImage());
                employeeRepo.save(employee.get());
                return  true;
            }
            return  false;
        }catch (Exception e) {throw  new Exception(e.getMessage());
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
                ,(String) obj[12]
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

    public  Employee mapFormToEmployee(EmployeeForm e){
        Employee employee =new Employee();
        employee.setFirstName(e.getFirstName());
        employee.setLastName(e.getLastName());
        employee.setGender(e.getGender());
        employee.setDateOfBirth(e.getDateOfBirth());
        employee.setHireDate(e.getHireDate());
        employee.setDepartmentId(e.getDepartmentId());
        employee.setPositionId(e.getPositionId());
        employee.setEmail(e.getEmail());
        employee.setPhoneNumber(e.getPhoneNumber());
        return  employee;
    }
}
