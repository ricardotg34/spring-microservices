package com.formaciondbi.microservices.app.commons.commons.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="subject")
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  @JsonIgnoreProperties(value = {"children"})
  @ManyToOne(fetch = FetchType.LAZY)
  private Subject parent;

  @JsonIgnoreProperties(value = {"parent"}, allowSetters = true)
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.ALL)
  private List<Subject> children;


  public Subject() {
    this.children = new ArrayList<>();
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Subject getParent() {
    return this.parent;
  }

  public void setParent(Subject parent) {
    this.parent = parent;
  }

  public List<Subject> getChildren() {
    return this.children;
  }

  public void setChildren(List<Subject> children) {
    this.children = children;
  }

}
