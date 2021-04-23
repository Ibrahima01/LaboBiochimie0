package com.example.LaboBiochimie.Controller;

import com.example.LaboBiochimie.Entities.Parametre;
import com.example.LaboBiochimie.Service.ParametreService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("parametre")
public class ParametreController {
    @Autowired
    ParametreService parametreService;
    @PostMapping("/newParametre")
    public void addNewParametre(@Validated @RequestBody Parametre p1){
        parametreService.SaveParametre(p1);
    }
    @PutMapping("/parametre/{id}")
    public void modifyAdmin(@PathVariable Long id, @Validated @RequestBody Parametre p1){
        parametreService.UpdateParametre(id, p1);
    }
    @GetMapping("/all")
    public List<Parametre> listParametre(){return parametreService.ListParametre();}
}
