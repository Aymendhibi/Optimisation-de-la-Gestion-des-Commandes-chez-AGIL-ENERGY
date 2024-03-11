package com.springjwt.controllers.Gerant;

import com.springjwt.service.Gerant.ServiceCommande;
import com.springjwt.service.Administrateur.ServiceProduit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springjwt.entities.Commande;
import com.springjwt.entities.LigneCommande;

import java.util.List;
@RestController
@RequestMapping("/Commande")
public class CommandeController {
    @Autowired
    ServiceCommande serviceCommande;
    @Autowired
    ServiceProduit serviceProduit;



    @PostMapping("/ajouterProduitAuPanier/{produitId}/{quantite}")
    public ResponseEntity<String> ajouterProduitAuPanier(@PathVariable Long produitId, @PathVariable int quantite) {
        serviceCommande.ajouterProduitAuPanier(produitId, quantite);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produit ajouté au panier avec succès");
    }

    @PutMapping("/modifierQuantiteEtCalculerPrixTotal/{ligneCommandeId}/{nouvelleQuantite}")
    public ResponseEntity<String> modifierQuantiteEtCalculerPrixTotal(@PathVariable Long ligneCommandeId, @PathVariable int nouvelleQuantite) {
        serviceCommande.modifierQuantiteEtCalculerPrixTotal(ligneCommandeId, nouvelleQuantite);
        return ResponseEntity.status(HttpStatus.OK).body("Quantité modifiée avec succès");
    }

    @PutMapping("/enregistrerCommande/{commandeId}")
    public ResponseEntity<String> enregistrerCommande(@PathVariable Long commandeId) {
        serviceCommande.enregistrerCommande(commandeId);
        return ResponseEntity.status(HttpStatus.OK).body("Commande enregistrée avec succès");
    }






        @PostMapping("/valider")
        public ResponseEntity<String> validerCommande(@RequestBody List<LigneCommande> lignesCommande) {
            Commande commande = serviceCommande.validerCommande(lignesCommande);
            return ResponseEntity.ok("Commande validée avec succès. ID de commande : " + commande.getId());
        }

    @GetMapping("/prix/{nomE}")
    public ResponseEntity<Double> getPrixTotalAndModifyStock1(
            @PathVariable String nomE,
            @RequestParam int quantite) {

        double prixTotal = serviceCommande.getPrixTotalAndModifyStockt1(nomE, quantite);
        if (prixTotal > 0) {
            return ResponseEntity.ok(prixTotal);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PatchMapping
    public  Commande modiffiercommandeavecchauffeur(@RequestBody Commande commande)
    {
        return serviceCommande.modifiercommandeavecchauffeur(commande);

    }
    @GetMapping
    public  List<Commande> afficherCommande()
    {
        return  serviceCommande.affichercommande();
    }
}



