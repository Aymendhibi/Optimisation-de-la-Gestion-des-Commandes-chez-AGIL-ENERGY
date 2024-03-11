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
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date datereclamation;
    @Enumerated(EnumType.STRING)
    private TypeDeReclamation typedereclamation;
    private String statut;
    private String description;
    @ManyToOne
    private Station station;


}
