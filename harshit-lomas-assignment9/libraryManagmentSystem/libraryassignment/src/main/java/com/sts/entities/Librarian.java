package com.sts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Librarian {
	
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Id
	private int id;
	
	@Column(name = "username",nullable = false,length = 50)
	private String name;
	
	@Column(name = "password",nullable=false,length= 50)
	private String password;

	
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "Librarian [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	

}
