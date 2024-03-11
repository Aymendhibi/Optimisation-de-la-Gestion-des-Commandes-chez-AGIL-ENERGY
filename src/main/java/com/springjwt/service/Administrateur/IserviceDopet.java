package com.springjwt.service.Administrateur;

import com.springjwt.entities.Depot;
import com.springjwt.entities.Produit;

import java.util.List;

public interface IserviceDopet {
    Depot ajouterDepot(Depot depot);
    Depot modifierDepot(Depot depot );

    public Depot supprimerDepot(Long depotId);
    public List<Depot> afficher();
}
