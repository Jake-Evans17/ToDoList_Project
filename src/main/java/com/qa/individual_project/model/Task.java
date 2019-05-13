package com.qa.individual_project.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private String name;
	private String description;
	private String dateSet;
	private String dateTarget;
	private String priority;
	private boolean complete;
	private int userId;
	private int categoryId;
	
	public Task() {
	}
	
	public Task(int id, String name) {
		this.id = id;
		this.name = name;
        LocalDate localDate = LocalDate.now();
        this.dateSet = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);
        this.complete = false;
	}
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateSet() {
		return dateSet;
	}
	public void setDateSet(String dateSet) {
		this.dateSet = dateSet;
	}
	public String getDateTarget() {
		return dateTarget;
	}
	public void setDateTarget(String dateTarget) {
		this.dateTarget = dateTarget;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public boolean getComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
