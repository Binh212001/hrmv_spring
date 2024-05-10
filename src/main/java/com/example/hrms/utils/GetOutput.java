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
}
