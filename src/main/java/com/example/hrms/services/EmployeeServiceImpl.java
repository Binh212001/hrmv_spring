package com.example.hrms.services;

import com.example.hrms.dto.EmployeeDto;
import com.example.hrms.entities.Department;
import com.example.hrms.entities.Employee;
import com.example.hrms.entities.Position;
import com.example.hrms.entities.Skill;
import com.example.hrms.form.EmployeeForm;
import com.example.hrms.repo.ContractRepository;
import com.example.hrms.repo.DepartmentRepository;
import com.example.hrms.repo.EmployeeRepository;
import com.example.hrms.repo.PositionRepository;
import com.example.hrms.repo.SkillRepository;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetListOutput;
import com.example.hrms.utils.GetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    ContractRepository contractRepository;
    @Autowired
    SkillRepository skillRepository;

    @Override
    public AddOutPut add(EmployeeForm employeeForm)  throws Exception{
        try {
            Optional<Employee> employeeInDB = employeeRepository.findByEmail(employeeForm.getEmail());
            if(employeeInDB.isPresent()){
                return  new  AddOutPut("Email [" + employeeForm.getEmail()+"] đã được sử dụng rồi",false);
            }
            Employee employee = new Employee();
            employee.setName(employeeForm.getName());
            employee.setGender(employeeForm.getGender());
            employee.setDateOfBirth(employeeForm.getDateOfBirth());
            employee.setHireDate(employeeForm.getHireDate());
            employee.setEmail(employeeForm.getEmail());
            employee.setContactNumber(employeeForm.getContactNumber());
            if(employeeForm.getDepartmentId() instanceof  Long){
                Optional<Department> department = departmentRepository.findById(employeeForm.getDepartmentId());
                employee.setDepartment(department.get());
            }
            if(employeeForm.getDepartmentId() instanceof  Long){
                Optional<Position> position = positionRepository.findById(employeeForm.getPositionId());
                employee.setPosition(position.get());
            }

            employeeRepository.save(employee);
            return  new  AddOutPut("Thêm thành công",true);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public GetListOutput getAll() throws Exception {
        try {
            Long count =employeeRepository.count();
            List <Employee> employees = employeeRepository.findAll();
            List<EmployeeDto> employeeDto = employees.stream().map(
                    employee -> mapToEmployeeDto(employee)).collect(java.util.stream.Collectors.toList());
            return  new GetListOutput("Thành công",200,employeeDto,count);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public GetListOutput getEmployeeByDepartment(Long id) throws Exception {
        try {
            Optional<Department> department = departmentRepository.findById(id);
            if(department.isPresent()) {
                List<Employee> employees = employeeRepository.getEmployeesByDepartment(department.get());
                List<EmployeeDto> employeeDto = employees.stream().map(
                        employee -> mapToEmployeeDto(employee)).collect(java.util.stream.Collectors.toList());
                Object count = employeeRepository.findEmployeeByDepartment(id)[0];
            return  new  GetListOutput("Thành công",200,employeeDto ,(Long) count);
            }
            return  new  GetListOutput("Bộ phận phòng ban không tồn tại",200,null,null);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) throws Exception {
        try {
            Optional<Employee> employee = employeeRepository.findById(employeeId);
            if(employee.isPresent()){
                return  mapToEmployeeDto(employee.get());
            }
            return  null;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public GetListOutput getByName(String name) throws Exception {
        try {
            Object count = employeeRepository.countByName(name)[0];
            List <Employee> employees = employeeRepository.findByNameLike("%"+name+"%");
            List<EmployeeDto> employeeDto = employees.stream().map(
                    employee -> mapToEmployeeDto(employee)).collect(java.util.stream.Collectors.toList());
            return  new GetListOutput("Thành công",200,employeeDto,(Long)count);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public AddOutPut update(EmployeeForm employeeForm) throws Exception {
        try {
            Optional<Employee> employeeInDB = employeeRepository.findByEmail(employeeForm.getEmail());
            if(employeeInDB.isEmpty()){
                return  new  AddOutPut("Không tìm thấy nhân viên : "+employeeForm.getName(),false);
            }
            employeeInDB.get().setName(employeeForm.getName());
            employeeInDB.get().setGender(employeeForm.getGender());
            employeeInDB.get().setDateOfBirth(employeeForm.getDateOfBirth());
            employeeInDB.get().setHireDate(employeeForm.getHireDate());
            employeeInDB.get().setEmail(employeeForm.getEmail());
            employeeInDB.get().setContactNumber(employeeForm.getContactNumber());
            if(employeeForm.getDepartmentId() instanceof  Long){
                Optional<Department> department = departmentRepository.findById(employeeForm.getDepartmentId());
                employeeInDB.get().setDepartment(department.get());
            }
            if(employeeForm.getDepartmentId() instanceof  Long){
                Optional<Position> position = positionRepository.findById(employeeForm.getPositionId());
                employeeInDB.get().setPosition(position.get());
            }

            employeeRepository.save(employeeInDB.get());
            return  new  AddOutPut("Cập nhật thành công",true);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    public EmployeeDto mapToEmployeeDto(Employee employee){

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setGender(employee.getGender());
        employeeDto.setDateOfBirth(employee.getDateOfBirth());
        employeeDto.setHireDate(employee.getHireDate());
        employeeDto.setContactNumber(employee.getContactNumber());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setContactNumber(employee.getContactNumber());
       if(employee.getDepartment() instanceof Department){
           employeeDto.setDepartmentId(employee.getDepartment().getId());
           employeeDto.setDepartmentName(employee.getDepartment().getDepartmentName());
       }
       if(employee.getPosition() instanceof Position){
           employeeDto.setPositionId(employee.getPosition().getId());
           employeeDto.setPositionName(employee.getPosition().getPositionTitle());
       }

       return  employeeDto;
    }
}
