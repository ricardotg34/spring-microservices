package com.formaciondbi.microservices.app.users.microservicesusers.services;

import java.util.List;

import com.formaciondbi.microservices.app.commons.commons.models.entity.Student;
import com.formaciondbi.microservices.app.users.microservicesusers.models.repository.StudentRepository;
import com.formaciondbi.microservices.commons.services.CommonServiceImp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImp extends CommonServiceImp<Student, StudentRepository> implements StudentService {

  @Override
  @Transactional(readOnly = true)
  public List<Student> findByFirstNameOrLastName(String term) {
    return repository.findByFirstNameOrLastName(term);
  }

}
