package com.springjwt.service.Administrateur;

import com.springjwt.entities.Chauffeur;
import com.springjwt.repositories.ChauffeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceChauffeur {
    @Autowired
    ChauffeurRepository chauffeurRepository;


    public Chauffeur ajouterchauffeur(Chauffeur chauffeur)
    {
        return  chauffeurRepository.save(chauffeur);

    }

    public List<Chauffeur> afficherchauffeur()
    {
        return chauffeurRepository.findAll();
    }
    public Chauffeur modifierchauffeur(Chauffeur chauffeur)
    {
        return  chauffeurRepository.save(chauffeur);



    }
    public Chauffeur supprimerchauffeur(Long chauffeurId)
    {
          chauffeurRepository.deleteById(chauffeurId);
        return  null;
    }

}
