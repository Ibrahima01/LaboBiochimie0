package com.example.LaboBiochimie.Service;

import com.example.LaboBiochimie.Entities.Admin;
import com.example.LaboBiochimie.Entities.Patient;
import com.example.LaboBiochimie.Entities.Personnel;
import com.example.LaboBiochimie.Entities.Rendez_vous;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface Rendez_vousService {
    void SaveRDV(Rendez_vous rendez_vous);
    Rendez_vous PatientPrendRDV(Patient patient);
    Rendez_vous PatientPrendRDVById(Long id);
    void PersonnelPrendRDV(Personnel personnel);
    void AdminPrendRDV(Admin admin);
    void UpdateRDV (Long Id, Rendez_vous rendez_vous);
    List<Rendez_vous>ListRDV();
    void RemoveRDV (Long id);
    public Optional<Rendez_vous> findRDV(Long Id);
    List<Rendez_vous>findByDate(LocalDateTime date);
    List<LocalDateTime> findRDVByIdPatient(Long Id);
}
