package com.springjwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springjwt.entities.ReclamationTechnique;

@Repository
public interface ReclamationTechniqueRepository extends JpaRepository<ReclamationTechnique,String>{

}
