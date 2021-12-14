package com.CRudJava.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "product")
public class Producto  implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String nombre;
	private String precio_unitario;
	private String idcategoria;
	private String estados;
	public String getEstados() {
		return estados;
	}
	public void setEstados(String estados) {
		this.estados = estados;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrecio_unitario() {
		return precio_unitario;
	}
	public void setPrecio_unitario(String precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	public String getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(String idcategoria) {
		this.idcategoria = idcategoria;
	}

	 
	
	
	
	
	
}
