package com.springjwt.service.Gerant;

import org.springframework.beans.factory.annotation.Autowired;

import com.springjwt.entities.LigneCommande;
import com.springjwt.repositories.LigneCommandeRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceLingeCommande implements IserviceLingeCommande {

    @Autowired
    LigneCommandeRepository ligneCommandeRepository;


    public LigneCommande saveLigneCommande(LigneCommande ligneCommande) {
        return ligneCommandeRepository.save(ligneCommande);
    }


}
