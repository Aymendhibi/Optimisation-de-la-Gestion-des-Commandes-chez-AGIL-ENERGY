package com.springjwt.repositories;

import com.springjwt.entities.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChauffeurRepository extends JpaRepository<Chauffeur,Long > {
    Chauffeur findByNom(String nomC);


}
