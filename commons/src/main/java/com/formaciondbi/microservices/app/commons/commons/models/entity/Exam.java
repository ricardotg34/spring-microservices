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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "exam")
public class Exam {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="created_ad")
  private Date createdAt;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "exam")
  private List<Question> questions;

  @ManyToOne(fetch = FetchType.LAZY)
  private Subject subject;

  public Exam() {
    this.questions = new ArrayList<>();
  }


  public List<Question> getQuestions() {
    return this.questions;
  }

  public void setQuestions(List<Question> questions) {
    this.questions.clear();
    questions.forEach(this::addQuestion);
  }

  public void addQuestion(Question question) {
    this.questions.add(question);
    question.setExam(this);
  }

  public void removeQuestion(Question question) {
    this.questions.remove(question);
    question.setExam(null);
  }

  @PrePersist
  public void PrePersist() {
    this.createdAt = new Date();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(!(o instanceof Student)) {
      return false;
    }
    Exam e = (Exam) o;

    return this.id != null && this.id.equals(e.getId());
  }


  public Subject getSubject() {
    return this.subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

}
