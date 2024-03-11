package com.springjwt.repositories;

import com.springjwt.entities.Equipement;
import com.springjwt.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
    Station findByNom(String nom);
}
