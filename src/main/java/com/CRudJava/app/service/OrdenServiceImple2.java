package com.CRudJava.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CRudJava.app.entity.DetailOrder;
import com.CRudJava.app.entity.DetailOrderResponse;
import com.CRudJava.app.entity.Orden;
import com.CRudJava.app.entity.Producto;
import com.CRudJava.app.entity.User;
import com.CRudJava.app.repository.DetailOrderRepository;
import com.CRudJava.app.repository.OrdenRepository;
import com.CRudJava.app.repository.ProductoRepository;
import com.CRudJava.app.repository.UserRepository;


@Service
public class OrdenServiceImple2  implements detailorderService {

	@Autowired
	private DetailOrderRepository detailOrderRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<DetailOrder> findAll() {

		return detailOrderRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<DetailOrder> findAll(Pageable pageable) {
		
		return detailOrderRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DetailOrder> findbyId(Long id) {
		return detailOrderRepository.findById(id);
	}
	 

	

	
	@Override
	@Transactional
	public DetailOrder save(DetailOrder order) {
		
		return detailOrderRepository.save(order);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		detailOrderRepository.deleteById(id);
		
	}

	@Override
	public Optional<DetailOrder> findbyIdOrder(Long id) {
		// TODO Auto-generated method stub
		return detailOrderRepository.findbyIdOrder(id);
	}
}
