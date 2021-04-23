package com.example.LaboBiochimie.ServiceImplementation;

import com.example.LaboBiochimie.Entities.Admin;
import com.example.LaboBiochimie.Entities.Parametre;
import com.example.LaboBiochimie.Repository.ParametreRepository;
import com.example.LaboBiochimie.Service.ParametreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service("ParametreServiceImpl")
public class ParametreServiceImpl implements ParametreService {
    @Autowired
    ParametreRepository parametreRepository;
    @Override
    public void SaveParametre (Parametre parametre){
        parametreRepository.save(parametre);
    }
    @Override
    public void UpdateParametre(Long Id, Parametre parametre){
        Optional<Parametre> parametre1=parametreRepository.findById(Id);
        if (parametre1.isEmpty())
        {
            System.out.println("Id inexistant");
        }
        else {
            Parametre newParametre = parametre1.get();
            newParametre.setDuree_prelevement(parametre.getDuree_prelevement());
            newParametre.setNombre_box(parametre.getNombre_box());
            newParametre.setNombre_chaises(parametre.getNombre_chaises());
            parametreRepository.save(newParametre);
        }
    }
    @Override
    public List<Parametre> ListParametre(){
        return parametreRepository.findAll();
    }
}
