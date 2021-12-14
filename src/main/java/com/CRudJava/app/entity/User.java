package com.CRudJava.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "order")
public class User  implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String name;
	private String estado;
	private String fecha;
	

	 
	
	private String surnmae;
	
	@Column(name="mail", nullable=false, length=50, unique = true)
	private String email;
	private Boolean enbable;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurnmae() {
		return surnmae;
	}
	public void setSurnmae(String surnmae) {
		this.surnmae = surnmae;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getEnbable() {
		return enbable;
	}
	public void setEnbable(Boolean enbable) {
		this.enbable = enbable;
	}
	
	
	
}
