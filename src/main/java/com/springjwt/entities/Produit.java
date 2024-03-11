package com.springjwt.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String type;
    private double prix;
    private String unite;
    private int stock;
    @Enumerated(EnumType.STRING)
   Category category;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
    private Set<LigneCommande> LigneCommandes;

}
