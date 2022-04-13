package com.formaciondbi.microservices.app.exams.microservicesexams.models.repository;
import java.util.List;

import com.formaciondbi.microservices.app.commons.commons.models.entity.Exam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ExamRepository extends CrudRepository<Exam, Long> {
  @Query("select e from Exam e where e.name like %?1%")
  public List<Exam> findByName(String term);
}
