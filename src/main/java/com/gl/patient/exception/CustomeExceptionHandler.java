package com.gl.patient.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class CustomeExceptionHandler extends ResponseEntityExceptionHandler {
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ExceptionModel> errorList = ex.getFieldErrors().stream().map(value ->
        {
            ExceptionModel model = new ExceptionModel(value.getDefaultMessage(), value.getField(), value.getRejectedValue()!=null?value.getRejectedValue().toString():null);
            return model;
        }).collect(Collectors.toList());

        return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
    }
}
