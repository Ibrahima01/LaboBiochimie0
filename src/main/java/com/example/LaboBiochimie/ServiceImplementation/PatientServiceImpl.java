package com.example.LaboBiochimie.ServiceImplementation;

import com.example.LaboBiochimie.Entities.Patient;
import com.example.LaboBiochimie.Repository.PatientRepository;
import com.example.LaboBiochimie.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("PatientServiceImpl")
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Override
    public void SavePatient(Patient patient){
        patientRepository.save(patient);
    }
    @Override
    public void UpdatePatient (Long Id, Patient patient){
        Optional<Patient> patient1=patientRepository.findById(Id);
        if (patient1.isEmpty())
        {
            System.out.println("Id inexistant");
        }
        else {
            Patient newPatient = patient1.get();
            newPatient.setNom_Patient(patient.getNom_Patient());
            newPatient.setPrenom_Patient(patient.getPrenom_Patient());
            //newPatient.setEmail(patient.getEmail());
            newPatient.setTel(patient.getTel());/*
            newPatient.setPhotoPatient(patient.getPhotoPatient());
            */
            newPatient.setCommentaires(patient.getCommentaires());
            patientRepository.save(newPatient);
        }
    }
    @Override
    public List<Patient> ListPatients(){
        return patientRepository.findAll();
    }
    @Override
    public void RemovePatient(Long Id){
        patientRepository.deleteById(Id);
    }
    @Override
    public Optional<Patient> findPatient(Long Id){
        return patientRepository.findById(Id);
    }
    /*
    @Override
    public void PrendreRDV(Patient patient){
        patient.prendreRDV();
    }
     */
}
