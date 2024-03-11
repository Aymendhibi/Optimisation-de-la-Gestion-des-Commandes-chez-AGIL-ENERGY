package com.springjwt.controllers.Administrateur;

import com.springjwt.entities.Category;
import com.springjwt.entities.Produit;

import com.springjwt.service.Administrateur.ServiceProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Produit")
public class ProduitController {

    @Autowired
    ServiceProduit servicproduit;


    @PostMapping
    public Produit ajouterProduit(@RequestBody Produit produit )
    {
        return  servicproduit.ajouterProduit(produit);
    }
    @PutMapping
    public  Produit modifiersation(@RequestBody Produit produit)
    {
        return  servicproduit.modifierProduit(produit);
    }



    @DeleteMapping("/{produitId}")
    public Produit supprimerstation(@PathVariable Long produitId)
    {
        servicproduit.supprimerProduit(produitId);
        return null;

    }
    @GetMapping
    public List<Produit> affichier()
    {
        return servicproduit.afficher();

    }


    @GetMapping("/categories")
    public List<String> getAllCategories() {
        return servicproduit.getAllCategories();
    }

    @GetMapping("/cat/{category}")
    public List<String> getProduitNamesByCategory(@PathVariable Category category) {
        return servicproduit.getProduitNamesByCategory(category);
    }





    @GetMapping("/prix/{nomE}")
    public ResponseEntity<Double> getPrixTotalAndModifyStock(
            @PathVariable String nomE,
            @RequestParam int quantite) {

        double prixTotal = servicproduit.getPrixTotalAndModifyStock(nomE, quantite);
        if (prixTotal > 0) {
            return ResponseEntity.ok(prixTotal);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/prixU/{nomE}")
    public double getPrixByProduit(@PathVariable String nomE) {
        return servicproduit.getPrixTotalAndModifyStock(nomE);
    }

}
