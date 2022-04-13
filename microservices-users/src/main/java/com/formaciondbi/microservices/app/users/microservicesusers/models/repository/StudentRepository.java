package com.formaciondbi.microservices.app.users.microservicesusers.models.repository;

import java.util.List;

import com.formaciondbi.microservices.app.commons.commons.models.entity.Student;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

  @Query("select s from Student s where s.firstName like %?1% or s.lastName like %?1%")
  public List<Student> findByFirstNameOrLastName(String term);

}
