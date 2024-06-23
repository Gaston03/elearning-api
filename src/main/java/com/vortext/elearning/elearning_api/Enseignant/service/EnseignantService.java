package com.vortext.elearning.elearning_api.Enseignant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vortext.elearning.elearning_api.Enseignant.models.Enseignant;
import com.vortext.elearning.elearning_api.Enseignant.repositories.EnseignantRepository;

@Service
public class EnseignantService {

  @Autowired
  private EnseignantRepository repository;

  public List<Enseignant> findAllEnseignants() {
    return repository.findAll();
  }

  public void createEnseignant(Enseignant enseignant) {
    repository.save(enseignant);
  }
  
  public Enseignant findEnseignantById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public boolean updateEnseignant(Enseignant enseignant, Long id) {
    Optional<Enseignant> enseignantOptional = repository.findById(id);

    if (enseignantOptional.isPresent()) {
      final Enseignant oldEnseignant = enseignantOptional.get();

      oldEnseignant.setNom(enseignant.getNom());
      oldEnseignant.setPrenom(enseignant.getPrenom());
      oldEnseignant.setEmail(enseignant.getEmail());
      oldEnseignant.setTelephone(enseignant.getTelephone());
      oldEnseignant.setBiographie(enseignant.getBiographie());

      repository.save(oldEnseignant);
      return true;
    }

    return false;
  }

  public boolean deleteEnseignant(Long id) {
    Optional<Enseignant> enseignantOptional = repository.findById(id);
    
    if (enseignantOptional.isPresent()) {
      repository.deleteById(id);
      return true;
    }

    return false;
  }
  
}
