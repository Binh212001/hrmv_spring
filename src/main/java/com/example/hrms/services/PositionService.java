package com.example.hrms.services;

import com.example.hrms.form.PositionForm;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetOutput;

public interface PositionService {
    GetOutput getPosition() throws Exception;

    AddOutPut addEdit(PositionForm positionForm) throws Exception;
}
