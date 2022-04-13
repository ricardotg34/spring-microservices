package com.formaciondbi.microservices.app.exams.microservicesexams.services;

import java.util.List;

import com.formaciondbi.microservices.app.commons.commons.models.entity.Exam;
import com.formaciondbi.microservices.app.commons.commons.models.entity.Subject;
import com.formaciondbi.microservices.app.exams.microservicesexams.models.repository.ExamRepository;
import com.formaciondbi.microservices.app.exams.microservicesexams.models.repository.SubjectRepository;
import com.formaciondbi.microservices.commons.services.CommonServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExamServiceImp extends CommonServiceImp<Exam, ExamRepository> implements ExamService {

  @Autowired
  private SubjectRepository subjectRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Exam> findByName(String term) {
    return repository.findByName(term);
  }

  @Override
  @Transactional(readOnly = true)
  public Iterable<Subject> findAllSubjects() {
    return subjectRepository.findAll();
  }
}
