package com.gl.patient.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionModel {
    String message;
    String field;
    String rejectedValue;
}
