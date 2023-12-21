package com.sts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Books {
	
	@Id
	private int id;
	
	@Column(name = "book_name",nullable = false,length = 50)
	private String name;
	
	@Column(name = "date",nullable = false,length = 50)
	private String dateadded;
	
	@Column(name = "author_name")
	private String author;
	
	public Books() {
		
	}
	
	public Books(int id, String name, String dateadded, String author) {
		super();
		this.id = id;
		this.name = name;
		this.dateadded = dateadded;
		this.author = author;
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
	
	public String getDateadded() {
		return dateadded;
	}
	public void setDateadded(String dateadded) {
		this.dateadded = dateadded;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", dateadded=" + dateadded + ", author=" + author + "]";
	}
	
}
