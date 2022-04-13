package com.formaciondbi.microservices.app.commons.commons.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "course")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(name = "created_at")
  @Temporal(TemporalType.TIMESTAMP) //Indicates both time and date
  private Date createdAt;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "course", cascade = CascadeType.PERSIST)
  private List<Student> students;

  @ManyToMany(fetch = FetchType.LAZY)
  private List<Exam> exams;

  public List<Exam> getExams() {
    return this.exams;
  }

  public void setExams(List<Exam> exams) {
    this.exams = exams;
  }

  public void addExam(Exam exam) {
    this.exams.add(exam);
  }

  public void removeExam(Exam exam) {
    this.exams.remove(exam);
  }

  public Course() {
    this.students = new ArrayList<>();
    this.exams = new ArrayList<>();
  }

  public List<Student> getStudents() {
    return this.students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  public void addStudent(Student student) {
    student.setCourse(this);
    this.students.add(student);
  }

  public void removeStudent(Student student) {
    this.students.remove(student);
  }

  @PrePersist
  public void PrePersist() {
    this.createdAt = new Date();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

}
