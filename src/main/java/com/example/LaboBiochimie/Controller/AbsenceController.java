package com.example.LaboBiochimie.Controller;

import com.example.LaboBiochimie.Entities.Absence;
import com.example.LaboBiochimie.Service.AbsenceService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/absence")
public class AbsenceController {
    @Autowired
    AbsenceService absenceService;
    @PostMapping("/newAbsence")
    public void addNewAbsence(@Validated @RequestBody Absence a1){
        absenceService.SaveAbsence(a1);
    }
    @PutMapping("/absence/{id}")
    public void modifyAbsence(@PathVariable Long id, @Validated @RequestBody Absence a1){
        absenceService.UpdateAbsence(id, a1);
    }
    @GetMapping("/all")
    public List<Absence> listAbsence(){return absenceService.ListAbsence();}
    @GetMapping("/absence/{id}")
    public Optional<Absence> getAbsenceById(@PathVariable Long Id){return absenceService.findAbsence(Id);}
    @DeleteMapping("/absence/{id}")
    public void deleteAbsence(@PathVariable Long id){
        absenceService.RemoveAbsence(id);
    }
}
