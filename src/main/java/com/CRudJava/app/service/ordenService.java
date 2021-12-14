package com.CRudJava.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.CRudJava.app.entity.Orden;
import com.CRudJava.app.entity.Producto;
import com.CRudJava.app.entity.User;

public interface ordenService {

	public Iterable<Orden> findAll();
	
	public Page<Orden> findAll(Pageable pageable);
	
	public Optional<Orden> findbyId(Long id);
	
	public Orden save(Orden order);
	
	public void deleteById(Long id);
	
	 
}
