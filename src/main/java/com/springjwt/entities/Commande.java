package com.springjwt.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCommande;
    private Date dateLivraison;
    private String statut;
    private double montant;
    @ManyToOne
    private Depot depot;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="commande")
    private Set<LigneCommande> LigneCommandes;
    public void calculateTotal() {
        double total = 0.0;
        if (LigneCommandes != null) {
            for (LigneCommande ligneCommande : LigneCommandes) {
                total += ligneCommande.getQuantite() * ligneCommande.getPrixUnitaire();
            }
        }
        this.montant = total;
    }
    @ManyToOne
    private Chauffeur  chauffeur;
}
