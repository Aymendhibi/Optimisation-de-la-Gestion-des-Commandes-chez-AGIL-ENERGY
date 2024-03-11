package com.springjwt.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReclamationCommerciale extends Reclamation {
    private String motif;
    private String observation;
    private String fichierJustificatif;
    @OneToOne
    private BonTravail bonTravail;
}
