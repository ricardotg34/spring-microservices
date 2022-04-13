package com.formaciondbi.microservices.app.users.microservicesusers.controllers;

import java.util.Optional;

import com.formaciondbi.microservices.app.commons.commons.models.entity.Student;
import com.formaciondbi.microservices.app.users.microservicesusers.services.StudentService;
import com.formaciondbi.microservices.commons.controllers.CommonController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("students")
public class StudentController extends CommonController<Student, StudentService> {

  @PutMapping("/{id}")
  public ResponseEntity<?> edit(@RequestBody Student student, @PathVariable Long id) {
    Optional<Student> o = service.findById(id);
    if(o.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Student studentdb = o.get();
    studentdb.setFirstName(student.getFirstName());
    studentdb.setLastName(student.getLastName());
    studentdb.setEmail(student.getEmail());

    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(studentdb));
  }

  @GetMapping("/filter/{term}")
  public ResponseEntity<?> filter(@PathVariable String term){
    return ResponseEntity.ok(service.findByFirstNameOrLastName(term));
  }
}
