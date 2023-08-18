package com.gl.patient.service;

import com.gl.patient.entity.Patient;
import com.gl.patient.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(String id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient updatePatient(String id, Patient patient) {
        patient.setId(id);
        return patientRepository.save(patient);
    }

    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }
}
