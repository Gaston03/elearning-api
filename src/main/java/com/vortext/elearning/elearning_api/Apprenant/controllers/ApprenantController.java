package com.vortext.elearning.elearning_api.Apprenant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vortext.elearning.elearning_api.Apprenant.models.Apprenant;
import com.vortext.elearning.elearning_api.Apprenant.services.ApprenantService;

@RestController
@RequestMapping("/api/v1/apprenant")
public class ApprenantController {

  @Autowired
  private ApprenantService service;

  @GetMapping("/{id}")
  public ResponseEntity<Apprenant> findApprenantById(@PathVariable Long id) {
    final Apprenant apprenant = service.findApprenantById(id);

    if(apprenant != null) {
      return new ResponseEntity<Apprenant>(apprenant, HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping
  public ResponseEntity<String> createApprenant(@RequestBody Apprenant apprenant) {
    service.createApprenant(apprenant);

    return new ResponseEntity<String>("Apprenant create successfully", HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Apprenant>> findAllApprenants() {
    final List<Apprenant> apprenants = service.findAllApprenant();

    return new ResponseEntity<List<Apprenant>>(apprenants, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateApprenant(@RequestBody Apprenant apprenant, @PathVariable Long id) {
    final Boolean isUpdateOk = service.updateApprenant(apprenant, id);

    if (!isUpdateOk) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<String>("Apprenant updated successfully", HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteApprenant(@PathVariable Long id) {
    final Boolean isDeleteOk = service.deleteApprenant(id);

    if (!isDeleteOk) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<String>("Apprenant deleted successfully", HttpStatus.ACCEPTED);
  }
  
}
