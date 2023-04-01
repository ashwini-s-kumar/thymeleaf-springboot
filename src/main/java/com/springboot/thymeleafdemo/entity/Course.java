package com.springboot.thymeleafdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="author")
	private String author;
	
	@Column(name="language")
	private String language;
	
		
	// define constructors
	
	public Course() {
		
	}
	
	public Course(int id, String name, String author, String language) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.language = language;
	}


	public Course(String name, String author, String language) {
		this.name = name;
		this.author = author;
		this.language = language;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	// define tostring

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + ", language=" + language + "]";
	}
		
}











