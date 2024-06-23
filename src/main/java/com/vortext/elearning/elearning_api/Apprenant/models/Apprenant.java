package com.vortext.elearning.elearning_api.Apprenant.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "apprenants")
@Data // Geère automatiquement les getters et les setters
@NoArgsConstructor
public class Apprenant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long apprenantId;

  @Column(nullable = false)
  private String nom;

  @Column(nullable = false)
  private String prenom;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String telephone;

  @Column(nullable = false)
  private String adresse;

  private String dateNaissance;

  private String profession;

  // private LocalDate dateInscription;
  
}