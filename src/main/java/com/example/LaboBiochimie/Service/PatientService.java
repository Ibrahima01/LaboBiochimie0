package com.example.LaboBiochimie.Service;

import com.example.LaboBiochimie.Entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    void SavePatient(Patient patient);
    void UpdatePatient(Long Id, Patient patient);
    List<Patient>ListPatients();
    void RemovePatient(Long Id);
    public Optional<Patient> findPatient(Long Id);
    //boolean authentification(String email, String motDePasse);
    //void PrendreRDV(Patient patient);
}
