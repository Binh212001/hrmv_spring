package com.example.hrms.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GetListOutput extends  GetOutput{
    private Long count;


    public GetListOutput(String message, Integer statusCode, Object data , Long count) {
        super(message, statusCode, data);
        this.count = count;
    }
}
