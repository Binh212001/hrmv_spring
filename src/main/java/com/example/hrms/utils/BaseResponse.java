package com.example.hrms.utils;

import lombok.Data;

@Data
public class BaseResponse {
    private String message;
    private Integer statusCode;
}
