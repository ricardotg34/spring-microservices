package com.formaciondbi.microservices.commons.controllers;

import java.util.Optional;

import com.formaciondbi.microservices.commons.services.CommonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("students")
public class CommonController<E, S extends CommonService<E>> {
  @Autowired
  protected S service;

  @GetMapping
  public ResponseEntity<?> list() {
    return ResponseEntity.ok().body(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> retrieve(@PathVariable Long id) {
    Optional<E> o = service.findById(id);
    if(o.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    // o.get return the Student and not the Optional object
    return ResponseEntity.ok().body(o.get());
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody E entity) {
    E studentdb = service.save(entity);
    return ResponseEntity.status(HttpStatus.CREATED).body(studentdb);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    // Optional<Student> o = service.findById(id);
    // if(o.isEmpty()) {
    //   return ResponseEntity.notFound().build();
    // }
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
