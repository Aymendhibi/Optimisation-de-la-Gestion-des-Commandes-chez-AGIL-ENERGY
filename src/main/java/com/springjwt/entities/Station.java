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
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    private String telephone;
    private String email;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="station")
    private Set<Reclamation> Reclamations;
@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="station")
    private Set<Equipement> equipements;
}
