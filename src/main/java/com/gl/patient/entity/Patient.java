package com.gl.patient.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "patients")
@Data
public class Patient {
    @Id
    private String id;
    @NotNull(message = "Patient name should not be null")
    private String name;
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",message = "Invalid Email format shoud be in abc@dp.com format")
    private String email;
    private ClinicalInfo clinicalInfo;

    // Getters, setters, constructors
}
