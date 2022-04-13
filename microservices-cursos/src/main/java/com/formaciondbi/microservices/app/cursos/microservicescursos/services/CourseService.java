package com.formaciondbi.microservices.app.cursos.microservicescursos.services;

import com.formaciondbi.microservices.app.commons.commons.models.entity.Course;
import com.formaciondbi.microservices.commons.services.CommonService;

public interface CourseService extends CommonService<Course> {
  public Course findCourseByStudentId(Long id);
}
