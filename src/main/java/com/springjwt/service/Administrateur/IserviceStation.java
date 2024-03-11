package com.springjwt.service.Administrateur;

import com.springjwt.entities.Station;

import java.util.List;

public interface IserviceStation {
    public Station ajouterStation(Station station);
    public Station supprimerStation(Long stationId);
    public Station modifierStation(Station station);
    public List<Station> afficher();
    Station ajouterStationetEquipement(Station station, String  nom);
}
