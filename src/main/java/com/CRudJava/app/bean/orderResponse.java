package com.CRudJava.app.bean;

import java.util.List;

import com.CRudJava.app.entity.Producto;

public class orderResponse {
	private String nombre_producto;
	private String cantidad_producto;
	private double precio_producto;
	private double sub_total;
	private double impuesto_municipal;
	private double impuesto_condado;
	private double impuesto_estatal;
	private double impuesto_federal;
	
	List<Producto> listProducto;

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(String cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public double getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(double precio_producto) {
		this.precio_producto = precio_producto;
	}

	public double getSub_total() {
		return sub_total;
	}

	public void setSub_total(double sub_total) {
		this.sub_total = sub_total;
	}

	public double getImpuesto_municipal() {
		return impuesto_municipal;
	}

	public void setImpuesto_municipal(double impuesto_municipal) {
		this.impuesto_municipal = impuesto_municipal;
	}

	public double getImpuesto_condado() {
		return impuesto_condado;
	}

	public void setImpuesto_condado(double impuesto_condado) {
		this.impuesto_condado = impuesto_condado;
	}

	public double getImpuesto_estatal() {
		return impuesto_estatal;
	}

	public void setImpuesto_estatal(double impuesto_estatal) {
		this.impuesto_estatal = impuesto_estatal;
	}

	public double getImpuesto_federal() {
		return impuesto_federal;
	}

	public void setImpuesto_federal(double impuesto_federal) {
		this.impuesto_federal = impuesto_federal;
	}

	public List<Producto> getListProducto() {
		return listProducto;
	}

	public void setListProducto(List<Producto> listProducto) {
		this.listProducto = listProducto;
	}

}
