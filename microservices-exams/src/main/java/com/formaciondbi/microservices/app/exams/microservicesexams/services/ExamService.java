package com.formaciondbi.microservices.app.exams.microservicesexams.services;

import java.util.List;

import com.formaciondbi.microservices.app.commons.commons.models.entity.Exam;
import com.formaciondbi.microservices.app.commons.commons.models.entity.Subject;
import com.formaciondbi.microservices.commons.services.CommonService;

public interface ExamService extends CommonService<Exam>{
  public List<Exam> findByName(String term);

  public Iterable<Subject> findAllSubjects();
}
