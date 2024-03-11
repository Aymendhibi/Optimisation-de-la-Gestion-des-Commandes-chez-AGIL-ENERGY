package com.springjwt.service.Administrateur;

import java.util.List;
import java.util.Set;

import com.springjwt.entities.Equipement;
import com.springjwt.entities.Station;
import com.springjwt.repositories.EquipementRepository;
import com.springjwt.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceStation implements IserviceStation {
    @Autowired
    StationRepository stationRepository;
    @Autowired
    EquipementRepository equipementRepository;
    @Override
    public Station ajouterStation(Station station) {
        return stationRepository.save(station);
    }

    @Override
    public Station supprimerStation(Long stationId) {
         stationRepository.deleteById(stationId);
        return null;
    }

    @Override
    public Station modifierStation(Station station) {
        return stationRepository.save(station);
    }

    @Override
    public List<Station> afficher() {
        return stationRepository.findAll();
    }

    @Override
    public Station ajouterStationetEquipement(Station station, String nom) {
        Set<Equipement> equipement=equipementRepository.findByNom(nom);
       station.setEquipements(equipement);
        return stationRepository.save(station);

    }
}
