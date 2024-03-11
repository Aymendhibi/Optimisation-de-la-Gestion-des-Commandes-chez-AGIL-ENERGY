package com.springjwt.repositories;

import com.springjwt.entities.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {
    Set<Equipement> findByNom(String nom);
}
