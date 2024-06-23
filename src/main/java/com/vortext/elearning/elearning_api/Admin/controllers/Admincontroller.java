package com.vortext.elearning.elearning_api.Admin.controllers;

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

import com.vortext.elearning.elearning_api.Admin.models.Admin;
import com.vortext.elearning.elearning_api.Admin.service.AdminService;

@RestController
@RequestMapping("/api/v1/admin")
public class Admincontroller {
  
  @Autowired
  private AdminService service;

  @PostMapping
  public ResponseEntity<String> createAdmin(@RequestBody Admin admin) {
    service.createAdmin(admin);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Admin>> findAllAdmins() {
    List<Admin> admins = service.findAllAdmins();
    return new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Admin> findAdminById(@PathVariable Long id) {
    final Admin admin = service.findAdminById(id);

    if (admin == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<Admin>(admin, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
    final boolean isDeleteOk = service.deleteAdmin(id);

    if (!isDeleteOk) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<String>("Admin deleted sucessfully", HttpStatus.ACCEPTED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateAdmin(@RequestBody Admin admin, @PathVariable Long id) {
    final boolean isUpdateOk = service.updateAdmin(admin, id);

    if (!isUpdateOk) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<String>("Admin updated sucessfully", HttpStatus.ACCEPTED);
  }
}
