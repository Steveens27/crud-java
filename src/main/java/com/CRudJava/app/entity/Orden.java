package com.CRudJava.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "orders")
public class Orden  implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String estado;
	private String cantidad_impuesto;
	private Integer idcategoria;
	private String estado_logica;
	private Integer nro_pedido;
	private String cliente;
	private String fecha;
	private Double total_impuesto;
	private Double total;
	private Double sub_total;
	private Integer cantidad_total;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCantidad_impuesto() {
		return cantidad_impuesto;
	}
	public void setCantidad_impuesto(String cantidad_impuesto) {
		this.cantidad_impuesto = cantidad_impuesto;
	}
	public Integer getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(Integer idcategoria) {
		this.idcategoria = idcategoria;
	}
	public String getEstado_logica() {
		return estado_logica;
	}
	public void setEstado_logica(String estado_logica) {
		this.estado_logica = estado_logica;
	}
	public Integer getNro_pedido() {
		return nro_pedido;
	}
	public void setNro_pedido(Integer nro_pedido) {
		this.nro_pedido = nro_pedido;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Double getTotal_impuesto() {
		return total_impuesto;
	}
	public void setTotal_impuesto(Double total_impuesto) {
		this.total_impuesto = total_impuesto;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getSub_total() {
		return sub_total;
	}
	public void setSub_total(Double sub_total) {
		this.sub_total = sub_total;
	}
	public Integer getCantidad_total() {
		return cantidad_total;
	}
	public void setCantidad_total(Integer cantidad_total) {
		this.cantidad_total = cantidad_total;
	}
	
	
}
