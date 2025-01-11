package com.yakuperenermurat.todolist.exception;

import com.yakuperenermurat.todolist.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Tüm controller sınıfları için global hata yönetimi sağlar.
public class GlobalExceptionHandler {

    // Genel RuntimeException Hataları Yakala
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<String>> handleRuntimeException(RuntimeException e) {
        return new ResponseEntity<>(new ApiResponse<>(false, e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
