package com.formaciondbi.microservices.app.cursos.microservicescursos.services;

import com.formaciondbi.microservices.app.commons.commons.models.entity.Course;
import com.formaciondbi.microservices.app.cursos.microservicescursos.models.repository.CourseRepository;
import com.formaciondbi.microservices.commons.services.CommonServiceImp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseServiceImpl extends CommonServiceImp<Course, CourseRepository> implements CourseService {

  @Override
  @Transactional(readOnly = true)
  public Course findCourseByStudentId(Long id) {
    return repository.findCourseByStudentId(id);
  }
}
