package com.example.LaboBiochimie.ServiceImplementation;

import com.example.LaboBiochimie.Entities.Absence;
import com.example.LaboBiochimie.Repository.AbsenceRepository;
import com.example.LaboBiochimie.Service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.script.AbstractScriptEngine;
import java.util.List;
import java.util.Optional;

@Service("AbsenceServiceImpl")
public class AbsenceServiceImpl implements AbsenceService {
    @Autowired
    AbsenceRepository absenceRepository;
    @Override
    public void SaveAbsence(Absence absence){
        absenceRepository.save(absence);
    }
    @Override
    public void UpdateAbsence(Long Id, Absence absence){
        Optional<Absence> absence1=absenceRepository.findById(Id);
        if (absence1.isEmpty())
        {
            System.out.println("Id inexistant");
        }
        else {
            Absence newAbsence=absence1.get();
            newAbsence.setDate_absence(absence.getDate_absence());
            //newAbsence.setJustificatif(absence.getJustificatif());
            newAbsence.setMotif(absence.getMotif());
            newAbsence.setStatut(absence.isStatut());
            absenceRepository.save(newAbsence);
        }
    }
    @Override
    public List<Absence> ListAbsence(){
        return absenceRepository.findAll();
    }
    @Override
    public void RemoveAbsence (Long Id){
        absenceRepository.deleteById(Id);
    }
    @Override
    public Optional<Absence> findAbsence(Long Id){
        return absenceRepository.findById(Id);
    }

}
