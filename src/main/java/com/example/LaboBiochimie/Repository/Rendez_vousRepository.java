package com.example.LaboBiochimie.Repository;

import com.example.LaboBiochimie.Entities.Patient;
import com.example.LaboBiochimie.Entities.Rendez_vous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Rendez_vousRepository extends JpaRepository <Rendez_vous, Long> {
    @Query("Select id, nom_Patient, prenom_Patient, email, tel, commentaires from Patient p where p.id=?1")
    List<Patient> getPatientById(Long id);

}
