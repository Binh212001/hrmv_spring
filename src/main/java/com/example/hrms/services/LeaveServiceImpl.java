package com.example.hrms.services;

import com.example.hrms.dto.LeaveDto;
import com.example.hrms.entities.Employee;
import com.example.hrms.entities.Leave;
import com.example.hrms.form.LeaveForm;
import com.example.hrms.repo.EmployeeRepository;
import com.example.hrms.repo.LeaveRepository;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetListOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    LeaveRepository leaveRepository;

    @Override
    public AddOutPut addEdit(LeaveForm leaveForm) throws Exception {
        try {
            if (leaveForm.getEmployeeId() == null) {
                return new AddOutPut("Không tìm thấy nhân viên.", false);
            }
            Optional<Employee> employee = employeeRepository.findById(leaveForm.getEmployeeId());
            if (employee.isEmpty()) {
                return new AddOutPut("Không tìm thấy nhân viên.", false);
            }
            if (leaveForm.getId() == null) {
                //add
                List<Leave> leaveInDb = leaveRepository.findByStartDateAndEndDate(leaveForm.getStartDate(), leaveForm.getEndDate());
                if (leaveInDb.isEmpty()) {
                    Leave leave = mapLeave(leaveForm, employee.get());
                    leaveRepository.save(leave);
                    return new AddOutPut("Thêm thành công.", true);
                }
                String message = "Nhân viên đã có ca nghỉ \n";
                for (Leave l : leaveInDb) {
                    message += "Từ ngày " + l.getStartDate() + " đến ngày " + l.getEndDate() + "\n";
                }
                return new AddOutPut(message, false);
            } else {
                //update
                Optional<Leave> leave = leaveRepository.findById(leaveForm.getId());
                if (leave.isEmpty()) {
                    return new AddOutPut("Không tìm thấy ca nghi.", false);
                }
                leave.get().setLeaveType(leaveForm.getLeaveType());
                leave.get().setStartDate(leaveForm.getStartDate());
                leave.get().setEndDate(leaveForm.getEndDate());
                leave.get().setReason(leaveForm.getReason());
                leave.get().setStatus(leaveForm.getStatus());
                leave.get().setEmployee(employee.get());
                leaveRepository.save(leave.get());
                return new AddOutPut("Cập nhật thành công.", true);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public GetListOutput getAll(LocalDate startDate, LocalDate endDate) throws Exception {
        try {
            List<Leave> leaveInDb = leaveRepository.findByStartDateAndEndDate(startDate, endDate);
            List<LeaveDto> leaveDto = leaveInDb.stream().map(
                    leave -> mapLeaveDto(leave)).collect(java.util.stream.Collectors.toList());
            return new GetListOutput("Thành công", 200, leaveDto, (long) leaveInDb.size());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public GetListOutput getLeaveOfUser(Long employeeId) throws Exception {
        try {
            Optional<Employee> employee = employeeRepository.findById(employeeId);
            if (employee.isEmpty()) {
                return new GetListOutput("Không tìm thấy nhân viên.", 404, null, 0L);
            }
            List<Leave> leaveInDb = leaveRepository.findByEmployee(employee.get());
            List<LeaveDto> leaveDto = leaveInDb.stream().map(
                    leave -> mapLeaveDto(leave)).collect(java.util.stream.Collectors.toList());
            return new GetListOutput("Thành công", 200, leaveDto, (long) leaveInDb.size());

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Leave mapLeave(LeaveForm leaveForm, Employee employee) {
        Leave leave = new Leave();
        leave.setLeaveType(leaveForm.getLeaveType());
        leave.setStartDate(leaveForm.getStartDate());
        leave.setEndDate(leaveForm.getEndDate());
        leave.setReason(leaveForm.getReason());
        leave.setStatus(leaveForm.getStatus());
        leave.setEmployee(employee);
        return leave;
    }

    public LeaveDto mapLeaveDto(Leave leave){
        return  LeaveDto.builder()
                .id(leave.getId())
                .leaveType(leave.getLeaveType())
                .startDate(leave.getStartDate())
                .endDate(leave.getEndDate())
                .reason(leave.getReason())
                .status(leave.getStatus())
                .employeeName(leave.getEmployee().getName())
                .build();
    }

}
