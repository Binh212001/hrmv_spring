package com.example.hrms.services;

import com.example.hrms.entities.Department;
import com.example.hrms.entities.Position;
import com.example.hrms.form.PositionForm;
import com.example.hrms.repo.PositionRepository;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    PositionRepository positionRepository;
    @Override
    public GetOutput getPosition() throws Exception {
        try {

            return new GetOutput("Thành công", 200, positionRepository.findAll());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public AddOutPut addEdit(PositionForm positionForm) throws Exception {
        try {
            if(positionForm.getId() instanceof  Long){
                Optional<Position> position= positionRepository.findById(positionForm.getId());
                if(position.isEmpty()){
                    return  new AddOutPut("Không tìm thấy phòng ban.", false);
                }
                position.get().setPositionTitle(positionForm.getPositionTitle());
                position.get().setDescription(positionForm.getDescription());
                position.get().setSalary(positionForm.getSalary());
                position.get().setGradeLevel(positionForm.getGradeLevel());
                positionRepository.save(position.get());
                return new AddOutPut("Cập nhật thành công.", true);
            }
            Position position = mapPosition(positionForm);
            positionRepository.save(position);
            return new AddOutPut("Thêm thành công", true);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Position mapPosition(PositionForm positionForm) {
        Position position = new Position();
        position.setPositionTitle(positionForm.getPositionTitle());
        position.setDescription(positionForm.getDescription());
        position.setSalary(positionForm.getSalary());
        position.setGradeLevel(positionForm.getGradeLevel());
        return position;
    }
}
