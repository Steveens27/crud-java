package com.CRudJava.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CRudJava.app.entity.Producto;
import com.CRudJava.app.entity.User;
import com.CRudJava.app.repository.ProductoRepository;
import com.CRudJava.app.repository.UserRepository;


@Service
public class ProductoServiceImple implements productoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Producto> findAll() {
		
		
		return productoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findAll(Pageable pageable) {
		
		return productoRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findbyId(Long id) {
		return productoRepository.findById(id);
	}

	@Override
	@Transactional
	public Producto save(Producto product) {
		
		return productoRepository.save(product);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		productoRepository.deleteById(id);
		
	}

}
