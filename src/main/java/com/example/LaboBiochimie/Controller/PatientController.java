package com.example.LaboBiochimie.Controller;

import com.example.LaboBiochimie.Entities.Patient;
import com.example.LaboBiochimie.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Patient")
@CrossOrigin("*")
public class PatientController {
    @Autowired
    PatientService patientService;
    @PostMapping("/newPatient")
    public Patient addNewPatient(@Validated @RequestBody Patient p1){
        patientService.SavePatient(p1);
        return p1;
    }
    @PutMapping("/Patient/{id}")
    public void modifyPatient(@PathVariable Long id, @Validated @RequestBody Patient p1){
        patientService.UpdatePatient(id, p1);
    }
    /*
    @GetMapping(value = "/authentification/{email, password}")
    public boolean authentifier(@PathVariable (value = "email") String email, @PathVariable (value="password") String password){return patientService.authentification(email,password);}
     */
    @GetMapping("/GetAllPatients")
    public List<Patient> listAdmin(){return patientService.ListPatients();}
    @GetMapping(value = "/findPatientById/{id}")
    public Optional<Patient> getPatientById(@PathVariable (value = "id")String id){return patientService.findPatient(Long.parseLong(id));}
    @DeleteMapping(value = "/deletePatient/{id}")
    public void deletePatient(@PathVariable Long id){
        patientService.RemovePatient(id);
    }
}
