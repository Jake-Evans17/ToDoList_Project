package com.qa.individual_project.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private String name;
	//private int userId;
	
	@ManyToOne
	@JoinColumn (name = "userId")
	private User user;
	
	@OneToMany(mappedBy="category", cascade = CascadeType.ALL)
	private Set<Task> tasks;

	public Category() {
	}

	public Category(int id, String name, int userId) {
		this.id = id;
		this.name = name;
		//this.userId = userId;
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

	//public int getUserId() {
	//	return userId;
	//}

	//public void setUserId(int userId) {
	//	this.userId = userId;
	//}
}
