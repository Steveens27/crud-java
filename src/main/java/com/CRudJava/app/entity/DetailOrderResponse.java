package com.CRudJava.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
@NamedQuery(name="DetailOrderResponse.findOrder", query="select  u.id,  u.id_producto, u.id_orden, u.cantidad, u.costo,p.nombre,p.precio_unitario from  detail_order u inner join product  p on u.id_producto= p.id where u.id_orden =:id")
})
public class DetailOrderResponse {

	private Long id;
	private int id_producto;
	private int id_orden;
	private int cantidad;
	private int costo;
	private String  nombre;
	private double precio_unitario;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public int getId_orden() {
		return id_orden;
	}
	public void setId_orden(int id_orden) {
		this.id_orden = id_orden;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio_unitario() {
		return precio_unitario;
	}
	public void setPrecio_unitario(double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	
	
	
	
}
