package com.example.LaboBiochimie.Repository;

import com.example.LaboBiochimie.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
