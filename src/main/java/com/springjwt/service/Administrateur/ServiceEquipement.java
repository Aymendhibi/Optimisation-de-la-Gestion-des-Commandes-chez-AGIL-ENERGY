package com.springjwt.service.Administrateur;

import com.springjwt.entities.Equipement;
import com.springjwt.entities.Station;
import com.springjwt.repositories.EquipementRepository;
import com.springjwt.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEquipement implements IserviceEquipement {



    @Autowired
    EquipementRepository equipementRepository;
    @Autowired
    StationRepository stationRepository;

    @Override
    public Equipement ajouterStationetEquipement(Equipement equipement, Long stationId) {
        Station station=stationRepository.findById(stationId).get();
        equipement.setStation(station);
         equipementRepository.save(equipement);
        return equipement;
    }

    @Override
    public Equipement modifierEquipement(Equipement equipement) {

        equipement.setStation(equipement.getStation());
        equipementRepository.save(equipement);
        return equipement;
    }

    @Override
    public Equipement supprimerEquipement(Long equipementId) {
          equipementRepository.deleteById(equipementId);
        return null;
    }



    @Override
    public List<Equipement> afficher() {
        return equipementRepository.findAll();
    }


}
