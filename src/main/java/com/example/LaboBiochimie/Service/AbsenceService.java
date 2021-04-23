package com.example.LaboBiochimie.Service;

import com.example.LaboBiochimie.Entities.Absence;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AbsenceService {
    void SaveAbsence(Absence absence);
    void UpdateAbsence(Long Id, Absence absence);
    List <Absence>ListAbsence();
    void RemoveAbsence(Long Id);
    public Optional<Absence> findAbsence(Long id);
}
