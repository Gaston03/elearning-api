package com.vortext.elearning.elearning_api.Admin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@NoArgsConstructor
@Data
public class Admin {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long adminId;

  @Column(nullable = false)
  private String nom;

  @Column(nullable = false)
  private String prenom;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String telephone;

}