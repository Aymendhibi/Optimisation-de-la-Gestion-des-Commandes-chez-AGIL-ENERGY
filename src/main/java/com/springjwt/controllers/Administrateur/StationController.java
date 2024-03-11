package com.springjwt.controllers.Administrateur;

import com.springjwt.entities.Station;
import com.springjwt.service.Administrateur.ServiceStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Station")
public class StationController {

    @Autowired
    ServiceStation serviceStation;
    @PostMapping
    public Station ajouterstation(@RequestBody Station station)
    {
        return  serviceStation.ajouterStation(station);
    }
    @PutMapping
    public  Station modifiersation(@RequestBody Station station)
    {
        return  serviceStation.modifierStation(station);
    }
    @DeleteMapping("/{stationId}")
            public Station supprimerstation(@PathVariable Long stationId)
    {
        serviceStation.supprimerStation(stationId);
        return null;

    }
    @GetMapping
    public List<Station> affichier()
    {
        return serviceStation.afficher();

    }
    @PostMapping("/{nom}")
    public Station ajouterstationetequipement(@RequestBody Station station, @PathVariable String nom) {
        return serviceStation.ajouterStationetEquipement(station,nom);
    }
}
