package com.formaciondbi.microservices.app.cursos.microservicescursos.controllers;

import java.util.List;
import java.util.Optional;

import com.formaciondbi.microservices.app.commons.commons.models.entity.Course;
import com.formaciondbi.microservices.app.commons.commons.models.entity.Exam;
import com.formaciondbi.microservices.app.commons.commons.models.entity.Student;
import com.formaciondbi.microservices.app.cursos.microservicescursos.services.CourseService;
import com.formaciondbi.microservices.commons.controllers.CommonController;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CourseController extends CommonController<Course, CourseService> {

  @PutMapping(value="/{id}")
  public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody Course course) {
      Optional<Course> o = this.service.findById(id);
      if (!o.isPresent()) {
        return ResponseEntity.notFound().build();
      }
      Course dbCourse = o.get();
      dbCourse.setName(course.getName());
      return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCourse));
  }

  @PutMapping("/{id}/assign-students")
  public ResponseEntity<?> assignStudents(@RequestBody List<Student> students, @PathVariable Long id){
    Optional<Course> o = this.service.findById(id);
      if (!o.isPresent()) {
        return ResponseEntity.notFound().build();
      }
      Course dbCourse = o.get();

      for (Student s : students) {
        dbCourse.addStudent(s);
      }
      return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCourse));
  }

  @PutMapping("/{id}/assign-student")
  public ResponseEntity<?> assignStudent(@RequestBody Student student, @PathVariable Long id){
    Optional<Course> o = this.service.findById(id);
      if (!o.isPresent()) {
        return ResponseEntity.notFound().build();
      }
      Course dbCourse = o.get();

      dbCourse.addStudent(student);
      return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCourse));
  }

  @PutMapping("/{id}/delete-student")
  public ResponseEntity<?> deleteStudents(@RequestBody Student student, @PathVariable Long id){
    Optional<Course> o = this.service.findById(id);
      if (!o.isPresent()) {
        return ResponseEntity.notFound().build();
      }
      Course dbCourse = o.get();

      dbCourse.removeStudent(student);

      return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCourse));
  }

  @PutMapping("/{id}/assign-exams")
  public ResponseEntity<?> assignExams(@RequestBody List<Exam> exams, @PathVariable Long id){
    Optional<Course> o = this.service.findById(id);
      if (!o.isPresent()) {
        return ResponseEntity.notFound().build();
      }
      Course dbCourse = o.get();

      exams.forEach(dbCourse::addExam);

      return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCourse));
  }

  @PutMapping("/{id}/delete-exam")
  public ResponseEntity<?> deleteExam(@RequestBody Exam exam, @PathVariable Long id){
    Optional<Course> o = this.service.findById(id);
      if (!o.isPresent()) {
        return ResponseEntity.notFound().build();
      }
      Course dbCourse = o.get();

      dbCourse.removeExam(exam);

      return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCourse));
  }

  @GetMapping("/student/{id}")
  public ResponseEntity<?> findByStudentId(@PathVariable Long id){
    Course course = service.findCourseByStudentId(id);
    return ResponseEntity.ok(course);
  }
}
