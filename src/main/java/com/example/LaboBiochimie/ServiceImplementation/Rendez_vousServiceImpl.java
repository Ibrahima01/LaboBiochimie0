package com.example.LaboBiochimie.ServiceImplementation;

import com.example.LaboBiochimie.Entities.Admin;
import com.example.LaboBiochimie.Entities.Patient;
import com.example.LaboBiochimie.Entities.Personnel;
import com.example.LaboBiochimie.Entities.Rendez_vous;
import com.example.LaboBiochimie.Repository.PatientRepository;
import com.example.LaboBiochimie.Repository.Rendez_vousRepository;
import com.example.LaboBiochimie.Service.Rendez_vousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.sql.*;
import java.util.Date;
import java.util.stream.Collectors;

@Service("Rendez_vousServiceImpl")
public class Rendez_vousServiceImpl implements Rendez_vousService {
    @Autowired
    Rendez_vousRepository rendez_vousRepository;
    @Autowired
    PatientRepository patientRepository;
    @Override
    public void SaveRDV(Rendez_vous rendez_vous){
        rendez_vousRepository.save(rendez_vous);
    }
    @Override
    public void UpdateRDV(Long Id, Rendez_vous rendez_vous){
        Optional<Rendez_vous> rendez_vous1=rendez_vousRepository.findById(Id);
        if (rendez_vous1.isEmpty())
        {
            System.out.println("Id inexistant");
        }
        else {
            Rendez_vous newRDV = rendez_vous1.get();
            newRDV.setDate_heure_RDV(rendez_vous.getDate_heure_RDV());
            newRDV.setNumero_box(rendez_vous.getNumero_box());
            rendez_vousRepository.save(newRDV);
        }
    }
    @Override
    public List<Rendez_vous> ListRDV (){
        return rendez_vousRepository.findAll();
    }
    @Override
    public void RemoveRDV(Long Id){
        rendez_vousRepository.deleteById(Id);
    }
    @Override
    public Optional<Rendez_vous> findRDV(Long Id){
        return rendez_vousRepository.findById(Id);
    }
    @Override
    public List<Rendez_vous> findByDate(LocalDateTime date){
        return rendez_vousRepository.findAll().stream().filter(x->x.getDate_heure_RDV().toLocalDate().isEqual(date.toLocalDate())).collect(Collectors.toList());
    }
    @Override
    public Rendez_vous PatientPrendRDV(Patient patient){
        Rendez_vous rdv=new Rendez_vous();
        int numBox=(rendez_vousRepository.findAll().get(rendez_vousRepository.findAll().size()-1).getNumero_box()+1)%4;
        if (numBox==0){
            numBox=4;
        }
        rdv.setNumero_box(numBox);
        rdv.setDate_heure_RDV(LocalDateTime.now().plusDays(5));
        GregorianCalendar calendar=new GregorianCalendar();
        calendar.setTime(java.util.Date.from(rdv.getDate_heure_RDV().atZone(ZoneId.systemDefault()).toInstant()));
        int today = calendar.get(calendar.DAY_OF_WEEK);
        int indexOfToday = 0;
        switch (today) {
            case GregorianCalendar.MONDAY:
                indexOfToday = 1;
                break;
            case GregorianCalendar.TUESDAY:
                indexOfToday = 2;
                break;
            case GregorianCalendar.WEDNESDAY:
                indexOfToday = 3;
                break;
            case GregorianCalendar.THURSDAY:
                indexOfToday = 4;
                break;
            case GregorianCalendar.FRIDAY:
                indexOfToday = 5;
                break;
            case GregorianCalendar.SATURDAY:
                indexOfToday = 6;
                break;
            case GregorianCalendar.SUNDAY:
                indexOfToday = 7;
                break;
        }
        if (indexOfToday==6)
        {
            rdv.setDate_heure_RDV(rdv.getDate_heure_RDV().plusDays(2));
        }
        else if (indexOfToday==7){
            rdv.setDate_heure_RDV(rdv.getDate_heure_RDV().plusDays(1));
        }
        rdv.setRDVPatient(patient);
        if (patientRepository.findById(patient.getId()).isEmpty()){
            patientRepository.save(patient);
        }
        rendez_vousRepository.save(rdv);
        return rdv;
    }
    @Override
    public void PersonnelPrendRDV(Personnel personnel){

    }
    @Override
    public void AdminPrendRDV(Admin admin){

    }
    @Override
    public List<LocalDateTime> findRDVByIdPatient(Long Id){
        List<Rendez_vous> list=rendez_vousRepository.findAll();
        List<LocalDateTime> list2=new ArrayList<LocalDateTime>();
        for (Rendez_vous rdv: list){
            if(rdv.getRDVPatient().getId()==Id){
                list2.add(rdv.getDate_heure_RDV());
            }
        }
        return list2;
    }
    public Rendez_vous PatientPrendRDVById(Long id){
        Rendez_vous rdv = new Rendez_vous();
        if (patientRepository.findById(id).isEmpty()){
            //System.out.println("Patient inexistant");
            return rdv;
        }
        else {
            int numBox=(rendez_vousRepository.findAll().get(rendez_vousRepository.findAll().size()-1).getNumero_box()+1)%4;
            if (numBox == 0) {
                numBox = 4;
            }
            rdv.setNumero_box(numBox);
            rdv.setDate_heure_RDV(LocalDateTime.now().plusDays(5));
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(java.util.Date.from(rdv.getDate_heure_RDV().atZone(ZoneId.systemDefault()).toInstant()));
            Patient p = patientRepository.findById(id).get();//.get(0);;
            rdv.setRDVPatient(p);
        }
        rendez_vousRepository.save(rdv);
        return rdv;
    }
}
