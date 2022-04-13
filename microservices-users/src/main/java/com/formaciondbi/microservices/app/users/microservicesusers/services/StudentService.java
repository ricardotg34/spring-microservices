package com.formaciondbi.microservices.app.users.microservicesusers.services;

import java.util.List;

import com.formaciondbi.microservices.app.commons.commons.models.entity.Student;
import com.formaciondbi.microservices.commons.services.CommonService;

public interface StudentService extends CommonService<Student> {

  public List<Student> findByFirstNameOrLastName(String term);
}
