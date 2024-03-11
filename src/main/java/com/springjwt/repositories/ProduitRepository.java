package com.springjwt.repositories;

import com.springjwt.entities.Category;
import com.springjwt.entities.LigneCommande;
import com.springjwt.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByCategory(Category category);

    @Query("SELECT DISTINCT p.category FROM Produit p")
    List<String> findAllCategories();
    Produit findByNom(String nomE);
}
