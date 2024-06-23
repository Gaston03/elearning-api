package com.vortext.elearning.elearning_api.Admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vortext.elearning.elearning_api.Admin.models.Admin;
import com.vortext.elearning.elearning_api.Admin.repositories.AdminRepository;


@Service
public class AdminService {

  @Autowired
  private AdminRepository repository;

  public List<Admin> findAllAdmins() {
    return repository.findAll();
  }

  public void createAdmin(Admin enseignant) {
    repository.save(enseignant);
  }
  
  public Admin findAdminById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public boolean updateAdmin(Admin enseignant, Long id) {
    Optional<Admin> enseignantOptional = repository.findById(id);

    if (enseignantOptional.isPresent()) {
      final Admin oldAdmin = enseignantOptional.get();

      oldAdmin.setNom(enseignant.getNom());
      oldAdmin.setPrenom(enseignant.getPrenom());
      oldAdmin.setEmail(enseignant.getEmail());
      oldAdmin.setTelephone(enseignant.getTelephone());

      repository.save(oldAdmin);
      return true;
    }

    return false;
  }

  public boolean deleteAdmin(Long id) {
    Optional<Admin> enseignantOptional = repository.findById(id);
    
    if (enseignantOptional.isPresent()) {
      repository.deleteById(id);
      return true;
    }

    return false;
  }
  
}
