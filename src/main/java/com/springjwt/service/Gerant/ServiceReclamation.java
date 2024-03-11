package com.springjwt.service.Gerant;

import com.springjwt.entities.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springjwt.repositories.ReclamationRepository;

import java.util.List;

@Service
public class ServiceReclamation implements IserviceReclamation {


    @Autowired
    ReclamationRepository reclamationRepository;

    public Reclamation ajouterreclamation(Reclamation reclamation)
    {
        return reclamationRepository.save(reclamation);

    }

    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }
}
