package com.springjwt.service.Administrateur;

import com.springjwt.entities.Depot;
import com.springjwt.repositories.DepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceDepot implements IserviceDopet {
    @Autowired
    DepotRepository depotRepository;
    @Override
    public Depot ajouterDepot(Depot depot) {
        return depotRepository.save(depot);
    }

    @Override
    public Depot modifierDepot(Depot depot) {
        return depotRepository.save(depot);
    }

    @Override
    public Depot supprimerDepot(Long depotId) {
         depotRepository.deleteById(depotId);
        return null;
    }

    @Override
    public List<Depot> afficher() {
        return depotRepository.findAll();
    }
}
