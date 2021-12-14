package com.CRudJava.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.xml.ws.Response;


import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRudJava.app.entity.DetailOrder;
import com.CRudJava.app.entity.DetailOrderResponse;
import com.CRudJava.app.entity.Producto;
import com.CRudJava.app.entity.User;
import com.CRudJava.app.service.OrdenServiceImple;
import com.CRudJava.app.service.OrdenServiceImple2;
import com.CRudJava.app.service.ProductoServiceImple;
import com.CRudJava.app.service.UserServiceImple;

@RestController
@RequestMapping("/api/detailorder")
public class DetailOrderController {

	@Autowired
	private OrdenServiceImple2 DetailOrderService;
	
	@PersistenceContext
    private EntityManager entityManager;
	   @PersistenceUnit
	    private EntityManagerFactory emf;
		@Autowired
		private OrdenServiceImple ordenService;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public List<?> read(@PathVariable(value="id") Long userId ){
		
		 EntityManager em = emf.createEntityManager(); // Without parameter
		 Query query= em
	                .createNativeQuery("select  u.id,  u.id_producto, u.id_orden, u.cantidad, u.costo,p.nombre,p.precio_unitario from  detail_order u inner join product  p on u.id_producto= p.id where u.id_orden = :id")
	                .setParameter("id",userId)	                
	                ;
		 
		 List<?> list = query.getResultList();

		 
	 return list;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/list/{id}")
	public ResponseEntity<?> readList(@PathVariable(value="id") Long userId ){
	
    Optional<DetailOrder> product = DetailOrderService.findbyId(userId);
		
		if(!product.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
	 return ResponseEntity.ok(product);
	
	}
	
	//Read all users
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<DetailOrder> readAll (){
		List<DetailOrder> orders = StreamSupport
				.stream(DetailOrderService.findAll().spliterator(),false)
				.collect(Collectors.toList());
		
		return orders;
				
	}
	
	//Create a new user
	@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping
		public ResponseEntity<?> create(@RequestBody DetailOrder order){
			return ResponseEntity.status(HttpStatus.CREATED).body(DetailOrderService.save(order));
			
		}
	
	

@CrossOrigin(origins = "http://localhost:4200")
		@PutMapping("/{id}")
		public  ResponseEntity<?> update(@RequestBody DetailOrder orderDetails, @PathVariable(value = "id") Long orderId){
			Optional< DetailOrder> order = DetailOrderService.findbyId(orderId);
			
			if(!order.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			//BeanUtils.copyProperties(userDetails, user.get());
			order.get().setCantidad(orderDetails.getCantidad());
			order.get().setCosto(orderDetails.getCosto());
			order.get().setId(orderDetails.getId());
			order.get().setId_orden(orderDetails.getId_orden());
			order.get().setId_producto(orderDetails.getId_producto());

	
			
			return ResponseEntity.status(HttpStatus.CREATED).body(DetailOrderService.save(order.get()));
		}

@CrossOrigin(origins = "http://localhost:4200")
@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable(value="id") Long userID){
	
	if(!DetailOrderService.findbyId(userID).isPresent()) {
		return ResponseEntity.notFound().build();
	}
	DetailOrderService.deleteById(userID);
	
	return ResponseEntity.ok().build();
}
		
	    
	
}
