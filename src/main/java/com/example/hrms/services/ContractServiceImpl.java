package com.example.hrms.services;

import com.example.hrms.dto.ContractDto;
import com.example.hrms.entities.Contract;
import com.example.hrms.entities.Employee;
import com.example.hrms.form.ContractForm;
import com.example.hrms.form.EmployeeForm;
import com.example.hrms.repo.ContractRepo;
import com.example.hrms.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepo contractRepo;
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<ContractDto> getListContract() throws Exception {
        try {
            List<Contract> contracts = contractRepo.findAll();
            List<ContractDto> contractDtos = contracts.stream().map(c -> mapToContractDto(c)).collect(Collectors.toList());
            return contractDtos;
        } catch (Exception e) {
            throw new Exception("Get list contract fail:" + e.getMessage());
        }
    }

    @Override
    public ContractDto getContractByEmployee(Long employeeId) throws Exception {
        try {
            Optional<Employee> employee = employeeRepo.findById(employeeId);
            if (employee.isEmpty()) {
                throw new Exception("Employee not found");
            }
            Optional<Contract> contract = contractRepo.findByEmployee(employee.get());
            if (contract.isEmpty()) {
                throw new Exception("Contract not found");
            }
            return mapToContractDto(contract.get());

        } catch (Exception e) {
            throw new Exception("Get contract by employee fail:" + e.getMessage());
        }
    }

    @Override
    public boolean update(ContractForm contractForm) throws Exception {
        try {
            Optional<Contract> contract = contractRepo.findById(contractForm.getContractId());
            if (contract.isEmpty()) {
                throw new Exception("Contract not found");
            }
            Contract contract1 = contract.get();
            Optional<Employee> employee = employeeRepo.findById(contractForm.getEmployeeId());
            if (employee.isEmpty()) {
                throw new Exception("Employee not found");
            }
            contract1.setStartDate(contractForm.getStartDate());
            contract1.setEmployee(employee.get());
            contract1.setEndDate(contractForm.getEndDate());
            contract1.setSalary(contractForm.getSalary());
            contract1.setContractType(contractForm.getContractType());
            contractRepo.save(contract1);
            return true;
        } catch (Exception e) {
            throw new Exception("Update contract fail:" + e.getMessage());
        }
    }

    @Override
    public boolean add(ContractForm contractForm) throws Exception {
        try {
            Optional<Employee> employee = employeeRepo.findById(contractForm.getEmployeeId());
            if (employee.isEmpty()) {
                throw new Exception("Employee not found");
            }
            Contract contract = mapContract(contractForm, employee.get());
            contractRepo.save(contract);
            return true;
        } catch (Exception e) {
            throw new Exception("Add contract fail:" + e.getMessage());
        }
    }


    public ContractDto mapToContractDto(Contract contract) {
        return ContractDto.builder()
                .contractId(contract.getContractId())
                .employee(contract.getEmployee())
                .startDate(contract.getStartDate())
                .endDate(contract.getEndDate())
                .salary(contract.getSalary())
                .contractType(contract.getContractType())
                .build();
    }

    public Contract mapContract(ContractForm contractForm, Employee employee) {
        Contract contract = new Contract();
        contract.setEmployee(employee);
        contract.setStartDate(contractForm.getStartDate());
        contract.setEndDate(contractForm.getEndDate());
        contract.setSalary(contractForm.getSalary());
        contract.setContractType(contractForm.getContractType());
        return contract;
    }

}
