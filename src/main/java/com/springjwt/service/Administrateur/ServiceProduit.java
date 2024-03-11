package com.springjwt.service.Administrateur;

import com.springjwt.entities.Category;
import com.springjwt.entities.LigneCommande;
import com.springjwt.entities.Produit;
import com.springjwt.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceProduit implements IserviceProduit {
    @Autowired
    ProduitRepository produitRepository;
    @Override
    public Produit ajouterProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit modifierProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit supprimerProduit(Long produitId) {
        produitRepository.deleteById(produitId);
        return null;
    }

    @Override
    public List<Produit> afficher() {
        return produitRepository.findAll();
    }

    public List<Produit> afficherparcategory(Category category) {
        return produitRepository.findByCategory(category);
    }




    public List<String> getAllCategories() {
        return produitRepository.findAllCategories();
    }

    public List<String> getProduitNamesByCategory(Category category) {
        return produitRepository.findByCategory(category)
                .stream()
                .map(Produit::getNom)
                .collect(Collectors.toList());
    }

    public double getPrixTotalAndModifyStock(String nomE) {
        Produit produit = produitRepository.findByNom(nomE);

        return produit != null ? produit.getPrix() : 0.0f;





        }



    public double getPrixTotalAndModifyStock(String nomE, int quantite) {
        Produit produit = produitRepository.findByNom(nomE);
        LigneCommande ligneCommande = new LigneCommande();

        if (produit != null && produit.getStock() >= quantite) {
            double prixUnitaire = produit.getPrix();
            double prixTotal = prixUnitaire * quantite;
            int nouveauStock = produit.getStock() - quantite;
            produit.setStock(nouveauStock);

            produitRepository.save(produit);
            return prixTotal;
        }
        return 0.0;
    }
    public double getPrixByProduit(String nomE) {
        Produit produit = produitRepository.findByNom(nomE);
        return produit != null ? produit.getPrix() : 0.0;
    }

        }

