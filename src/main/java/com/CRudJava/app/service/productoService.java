package com.CRudJava.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.CRudJava.app.entity.Producto;
import com.CRudJava.app.entity.User;

public interface productoService {

	public Iterable<Producto> findAll();
	
	public Page<Producto> findAll(Pageable pageable);
	
	public Optional<Producto> findbyId(Long id);
	
	public Producto save(Producto product);
	
	public void deleteById(Long id);
	
	 
}
