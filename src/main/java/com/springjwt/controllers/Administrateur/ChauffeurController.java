package com.springjwt.controllers.Administrateur;

import com.springjwt.entities.Chauffeur;
import com.springjwt.service.Administrateur.ServiceChauffeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/Chauffeur")
@RestController
public class ChauffeurController {


    @Autowired
    ServiceChauffeur serviceChauffeur;


    @PostMapping
    public Chauffeur ajouterchauffeur (@RequestBody Chauffeur chauffeur)
    {
        return  serviceChauffeur.ajouterchauffeur(chauffeur);
    }
    @GetMapping
    public List<Chauffeur> affichierchauffeur ()
    {
        return serviceChauffeur.afficherchauffeur();

    }
    @PutMapping
    public Chauffeur modiffierchauffeur (@RequestBody Chauffeur chauffeur)
    {
        return  serviceChauffeur.modifierchauffeur(chauffeur);
    }
    @DeleteMapping("/{chaufeurId}")
    public  Chauffeur supprimerchaiffeur(@PathVariable Long chaufeurId)
    {
        return  serviceChauffeur.supprimerchauffeur(chaufeurId);
    }
}
