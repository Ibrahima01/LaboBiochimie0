package com.example.LaboBiochimie.Service;

import com.example.LaboBiochimie.Entities.Parametre;

import java.util.List;
import java.util.Optional;

public interface ParametreService {
    void SaveParametre (Parametre parametre);
    void UpdateParametre (Long Id, Parametre parametre);
    List<Parametre> ListParametre();
}
