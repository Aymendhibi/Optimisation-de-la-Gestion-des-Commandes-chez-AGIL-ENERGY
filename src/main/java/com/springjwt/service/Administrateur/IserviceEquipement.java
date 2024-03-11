package com.springjwt.service.Administrateur;

import com.springjwt.entities.Equipement;
import com.springjwt.entities.Station;

import java.util.List;

public interface IserviceEquipement {
    Equipement ajouterStationetEquipement(Equipement equipement, Long  stationId);
    Equipement modifierEquipement(Equipement equipement);

    public Equipement supprimerEquipement(Long equipementId);
    public List<Equipement> afficher();

}
