package com.formaciondbi.microservices.app.exams.microservicesexams.models.repository;

import com.formaciondbi.microservices.app.commons.commons.models.entity.Question;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
  
}
