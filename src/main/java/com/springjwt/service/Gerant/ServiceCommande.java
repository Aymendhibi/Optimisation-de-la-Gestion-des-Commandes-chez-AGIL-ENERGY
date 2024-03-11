package com.springjwt.service.Gerant;

import com.springjwt.entities.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.springjwt.repositories.CommandeRepository;
import com.springjwt.repositories.LigneCommandeRepository;

import com.springjwt.repositories.ProduitRepository;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
@Service
public class ServiceCommande implements IsrviceCommande {



    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

@Autowired
ServiceLingeCommande serviceLingeCommande;
    public Commande ajoutercommand( Commande commande) {

        return commandeRepository.save(commande);
    }


    @Transactional
    public void ajouterProduitAuPanier(Long produitId, int quantite) {
        Produit produit = produitRepository.findById(produitId).orElseThrow(() -> new IllegalArgumentException("Produit non trouvé"));
        if (produit.getStock() < quantite) {
            throw new IllegalArgumentException("Stock insuffisant");
        }

        // Réduire le stock du produit
        produit.setStock(produit.getStock() - quantite);
        produitRepository.save(produit);

        // Créer une nouvelle ligne de commande
        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setQuantite(quantite);
        ligneCommande.setPrixUnitaire(produit.getPrix());
        ligneCommande.setProduit(produit);

        // Enregistrer la ligne de commande
        ligneCommandeRepository.save(ligneCommande);
    }

    @Transactional
    public void modifierQuantiteEtCalculerPrixTotal(Long ligneCommandeId, int nouvelleQuantite) {
        // Récupérer la ligne de commande
        LigneCommande ligneCommande = ligneCommandeRepository.findById(ligneCommandeId)
                .orElseThrow(() -> new IllegalArgumentException("Ligne de commande non trouvée"));

        // Mettre à jour la quantité et recalculer le prix unitaire
        ligneCommande.setQuantite(nouvelleQuantite);
        ligneCommande.setPrixUnitaire(ligneCommande.getProduit().getPrix());
        ligneCommandeRepository.save(ligneCommande);

        // Vérifier si la référence à la commande depuis la ligne de commande n'est pas nulle
        Commande commande = ligneCommande.getCommande();
        if (commande != null) {
            // Calculer le montant total de la commande
            commande.calculateTotal();
            commandeRepository.save(commande);
        }
    }


    @Transactional
    public void enregistrerCommande(Long commandeId) {


        Commande commande = commandeRepository.findById(commandeId).orElseThrow(() -> new IllegalArgumentException("Commande non trouvée"));

        // Mettre à jour la date de la commande
        commande.setDateCommande(new Date());


        if (commande != null) {
            // Calculer le montant total de la commande
            commande.calculateTotal();
            commandeRepository.save(commande);
        }
}

    public Commande validerCommande(List<LigneCommande> lignesCommande) {
        Commande commande = new Commande();
        commande.setDateCommande(new Date()); // Définir la date de la commande
        commande.setStatut("En cours"); // Définir le statut de la commande

        // Associer les lignes de commande à la commande
        for (LigneCommande ligneCommande : lignesCommande) {
            ligneCommande.setCommande(commande);
        }
        commande.setLigneCommandes(new HashSet<>(lignesCommande));

        // Calculer le montant total de la commande
        commande.calculateTotal();

        // Enregistrer la commande dans la base de données
        Commande savedCommande = commandeRepository.save(commande);

        // Mettre à jour les références de commande dans les lignes de commande
        for (LigneCommande ligneCommande : lignesCommande) {
            ligneCommande.setCommande(savedCommande);
        }

        // Enregistrer les lignes de commande dans la base de données
        ligneCommandeRepository.saveAll(lignesCommande);

        return savedCommande;
    }
    public double getPrixTotalAndModifyStockt1(String nomE, int quantite) {
        Produit produit = produitRepository.findByNom(nomE);
        if (produit != null && produit.getStock() >= quantite) {
            double prixUnitaire = produit.getPrix();
            double prixTotal = prixUnitaire * quantite;
            int nouveauStock = produit.getStock() - quantite;
            produit.setStock(nouveauStock);
            produitRepository.save(produit);
            Commande commande = new Commande();
            // Créer une nouvelle ligne de commande
            LigneCommande ligneCommande = new LigneCommande();
            ligneCommande.setProduit(produit);
            ligneCommande.setQuantite(quantite);
            ligneCommande.setPrixUnitaire(prixUnitaire);
            ligneCommande.setCommande(commande);

            commande.setMontant(prixTotal);
            commande.setStatut("En cours");
            commande.setDateCommande(new Date());


           ajoutercommand(commande);

            // Enregistrer la ligne de commande
            serviceLingeCommande.saveLigneCommande(ligneCommande);

            return prixTotal;
        }
        return 0.0;
    }

    public Commande modifiercommandeavecchauffeur(Commande commande ) {

        commande.setChauffeur(commande.getChauffeur());
        commande.setStatut(commande.getStatut());


        ajoutercommand(commande);
        return null;
    }

    public List<Commande> affichercommande()
    {
        return  commandeRepository.findAll();
    }


}


