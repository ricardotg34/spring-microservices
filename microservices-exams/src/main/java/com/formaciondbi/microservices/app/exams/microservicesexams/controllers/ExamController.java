package com.formaciondbi.microservices.app.exams.microservicesexams.controllers;
import java.util.Optional;

import javax.ws.rs.core.Response;

import com.formaciondbi.microservices.app.commons.commons.models.entity.Exam;
import com.formaciondbi.microservices.app.exams.microservicesexams.services.ExamService;
import com.formaciondbi.microservices.commons.controllers.CommonController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamController extends CommonController<Exam, ExamService> {

  @PutMapping("/{id}")
  public ResponseEntity<?> edit(@RequestBody Exam exam, @PathVariable long id) {
    Optional<Exam> o = service.findById(id);
    if(!o.isPresent()){
      return ResponseEntity.notFound().build();
    }
    Exam examDB = o.get();
    examDB.setName(exam.getName());

    // List<Question> deleted = new ArrayList<>();

    // examDB.getQuestions().forEach(pdb -> {
    //   if(!exam.getQuestions().contains(pdb)){
    //     deleted.add(pdb);
    //   }
    // });

    // deleted.forEach(examDB::removeQuestion);

    examDB.getQuestions().stream()
    .filter(pdb -> !exam.getQuestions().contains(pdb))
    .forEach(examDB::removeQuestion);

    examDB.setQuestions(exam.getQuestions());

    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examDB));
  }

  @GetMapping("/filter/{term}")
  public ResponseEntity<?> filter(@PathVariable String term) {
    return ResponseEntity.ok(service.findByName(term));
  }

  @GetMapping("/subjects")
  public ResponseEntity<?> listSubjects() {
    return ResponseEntity.ok(service.findAllSubjects());
  }
}
