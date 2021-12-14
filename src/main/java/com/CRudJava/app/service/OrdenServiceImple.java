package com.CRudJava.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CRudJava.app.entity.Orden;
import com.CRudJava.app.entity.Producto;
import com.CRudJava.app.entity.User;
import com.CRudJava.app.repository.OrdenRepository;
import com.CRudJava.app.repository.ProductoRepository;
import com.CRudJava.app.repository.UserRepository;


@Service
public class OrdenServiceImple implements ordenService {

	@Autowired
	private OrdenRepository ordenRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Orden> findAll() {
		
		
		return ordenRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Orden> findAll(Pageable pageable) {
		
		return ordenRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Orden> findbyId(Long id) {
		return ordenRepository.findById(id);
	}

	@Override
	@Transactional
	public Orden save(Orden order) {
		
		return ordenRepository.save(order);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		System.out.println("sddddddddddddddddddddddddddddddddddddddddddd");
		ordenRepository.deleteById(id);
		
	}

}
