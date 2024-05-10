package com.example.hrms.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetOutput {
    private String message;
    private Integer statusCode;
    private Object data;
    private Long count;

    public GetOutput(String message, Integer statusCode, Object data) {
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }
}
