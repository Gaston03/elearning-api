package com.vortext.elearning.elearning_api.Apprenant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vortext.elearning.elearning_api.Apprenant.models.Apprenant;
import com.vortext.elearning.elearning_api.Apprenant.repositories.ApprenantRepository;

@Service
public class ApprenantService {

  @Autowired
  private ApprenantRepository repository;

  public void createApprenant(Apprenant apprenant) {
    repository.save(apprenant);
  }

  public Apprenant findApprenantById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public List<Apprenant> findAllApprenant() {
    return repository.findAll();
  }

  public boolean updateApprenant(Apprenant apprenant, Long id) {
    final Optional<Apprenant> optionalApprenant = repository.findById(id);

    if (optionalApprenant.isPresent()) {
      final Apprenant oldApprenant = optionalApprenant.get();

      oldApprenant.setNom(apprenant.getNom());
      oldApprenant.setPrenom(apprenant.getPrenom());
      oldApprenant.setEmail(apprenant.getEmail());
      oldApprenant.setTelephone(apprenant.getTelephone());
      oldApprenant.setAdresse(apprenant.getAdresse());

      repository.save(oldApprenant);

      return true;
    }

    return false;
  }

  public boolean deleteApprenant(Long id) {
    final Optional<Apprenant> optionalApprenant = repository.findById(id);

    if (optionalApprenant.isPresent()) {
      repository.deleteById(id);

      return true;
    }

    return false;

  }
}
