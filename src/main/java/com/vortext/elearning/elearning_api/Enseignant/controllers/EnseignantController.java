package com.vortext.elearning.elearning_api.Enseignant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vortext.elearning.elearning_api.Enseignant.models.Enseignant;
import com.vortext.elearning.elearning_api.Enseignant.service.EnseignantService;

@RestController
@RequestMapping("/api/v1/enseignant")
public class EnseignantController {
  
  @Autowired
  private EnseignantService service;

  @PostMapping
  public ResponseEntity<String> createEnseignant(@RequestBody Enseignant enseignant) {
    service.createEnseignant(enseignant);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Enseignant>> findAllEnseignants() {
    List<Enseignant> enseignants = service.findAllEnseignants();
    return new ResponseEntity<List<Enseignant>>(enseignants, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Enseignant> findEnseignantById(@PathVariable Long id) {
    final Enseignant enseignant = service.findEnseignantById(id);

    if (enseignant == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<Enseignant>(enseignant, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteEnseignant(@PathVariable Long id) {
    final boolean isDeleteOk = service.deleteEnseignant(id);

    if (!isDeleteOk) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<String>("Enseignant deleted sucessfully", HttpStatus.ACCEPTED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateEnseignant(@RequestBody Enseignant enseignant, @PathVariable Long id) {
    final boolean isUpdateOk = service.updateEnseignant(enseignant, id);

    if (!isUpdateOk) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<String>("Enseignant updated sucessfully", HttpStatus.ACCEPTED);
  }
}
