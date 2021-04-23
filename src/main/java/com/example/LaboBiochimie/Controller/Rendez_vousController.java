package com.example.LaboBiochimie.Controller;

import com.example.LaboBiochimie.Entities.Patient;
import com.example.LaboBiochimie.Entities.Rendez_vous;
import com.example.LaboBiochimie.Service.Rendez_vousService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@CrossOrigin("*")
@RequestMapping("RDV")
public class Rendez_vousController {
    @Autowired
    Rendez_vousService rendez_vousService;
    @PostMapping("/creerRDV")
    public Rendez_vous addNewRendez_vous(@Validated @RequestBody Rendez_vous rdv1){
        rendez_vousService.SaveRDV(rdv1);
        return rdv1;
    }
    @PostMapping("/patientPrendRDV")
    public Rendez_vous patientPrendRDV(@Validated @RequestBody Patient patient){
        return rendez_vousService.PatientPrendRDV(patient);
    }
    @PostMapping("/patientPrendRDVById/{id}")
    public Rendez_vous patientPrendRDVById(@PathVariable Long id){
        return rendez_vousService.PatientPrendRDVById(id);
    }
    @PutMapping("/RDV/{id}")
    public void modifyRDV(@PathVariable Long id, @Validated @RequestBody Rendez_vous rdv1){
        rendez_vousService.UpdateRDV(id, rdv1);
    }
    @GetMapping("/all")
    public List<Rendez_vous> listRDV(){return rendez_vousService.ListRDV();}
    @GetMapping("/RDV/{id}")
    public Optional<Rendez_vous> getRDVById(@PathVariable Long Id){return rendez_vousService.findRDV(Id);}
    @GetMapping(value = "/findRDVByIdPatient/{id}")
    public List<LocalDateTime> getRDVByIdPatient(@PathVariable (value="id") String id){return rendez_vousService.findRDVByIdPatient(Long.parseLong(id));}
    @DeleteMapping("/RDV/{id}")
    public void deleteRDV(@PathVariable Long id){
        rendez_vousService.RemoveRDV(id);
    }
}
