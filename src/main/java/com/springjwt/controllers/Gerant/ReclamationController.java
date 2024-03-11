package com.springjwt.controllers.Gerant;

import com.springjwt.entities.Reclamation;
import com.springjwt.service.Gerant.ServiceReclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Reclamation")
public class ReclamationController  {


    @Autowired
    ServiceReclamation  serviceReclamation;

    @PostMapping
    public Reclamation ajouterreclamtion(@RequestBody Reclamation reclamation)
    {
        return serviceReclamation.ajouterreclamation(reclamation);
    }
    @GetMapping
    public List<Reclamation> getAllReclamations() {
        List<Reclamation> reclamations = serviceReclamation.getAllReclamations();
        for (Reclamation reclamation : reclamations) {
            System.out.println(reclamation.toString());
        }
        return reclamations;
    }
}
