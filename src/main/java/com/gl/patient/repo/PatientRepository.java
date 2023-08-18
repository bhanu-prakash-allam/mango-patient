package com.gl.patient.repo;

import com.gl.patient.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    Patient findByEmail(String email);
    Patient findByName(String name);
}
