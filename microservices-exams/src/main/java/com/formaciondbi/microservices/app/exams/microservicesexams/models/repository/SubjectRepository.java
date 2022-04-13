package com.formaciondbi.microservices.app.exams.microservicesexams.models.repository;

import com.formaciondbi.microservices.app.commons.commons.models.entity.Subject;

import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
  
}
