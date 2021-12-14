package com.CRudJava.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.CRudJava.app.entity.DetailOrder;
import com.CRudJava.app.entity.DetailOrderResponse;

public interface detailorderService {

	public Iterable<DetailOrder> findAll();
	
	public Page<DetailOrder> findAll(Pageable pageable);
	
	public Optional<DetailOrder> findbyId(Long id);
	
	public Optional<DetailOrder> findbyIdOrder(Long id);
	
	public DetailOrder save(DetailOrder order);
	
	public void deleteById(Long id);
	
	 
}
