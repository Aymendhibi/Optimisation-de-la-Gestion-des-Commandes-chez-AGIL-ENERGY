package com.springjwt.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BonTravail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateCreation;
    private Date dateCloture;
    private String statut;
    private String description;
    @OneToOne(mappedBy="bonTravail")
    private  ReclamationTechnique reclamationTechnique;
    @OneToOne(mappedBy="bonTravail")
    private  ReclamationCommerciale reclamationCommerciale ;

}
