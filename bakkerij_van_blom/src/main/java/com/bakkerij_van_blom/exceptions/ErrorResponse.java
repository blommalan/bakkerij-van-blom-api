package com.bakkerij_van_blom.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    public HttpStatus statusCode;
    public String message;
    
    public ErrorResponse(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
