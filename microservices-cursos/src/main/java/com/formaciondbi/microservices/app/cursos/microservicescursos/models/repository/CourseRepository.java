package com.formaciondbi.microservices.app.cursos.microservicescursos.models.repository;

import com.formaciondbi.microservices.app.commons.commons.models.entity.Course;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
  @Query("select c from Course c join fetch c.students s where s.id=?1")
  public Course findCourseByStudentId(Long id);
}
