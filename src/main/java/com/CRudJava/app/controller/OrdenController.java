package com.CRudJava.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.xml.ws.Response;

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

import com.CRudJava.app.entity.Orden;
import com.CRudJava.app.entity.Producto;
import com.CRudJava.app.entity.User;
import com.CRudJava.app.service.OrdenServiceImple;
import com.CRudJava.app.service.ProductoServiceImple;
import com.CRudJava.app.service.UserServiceImple;
import com.CRudJava.app.service.ordenService;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

	
	@PersistenceContext
    private EntityManager entityManager;
	   @PersistenceUnit
	    private EntityManagerFactory emf;
	@Autowired
	private OrdenServiceImple ordenService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long userId ){
		Optional<Orden> product = ordenService.findbyId(userId);
		
		if(!product.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
	 return ResponseEntity.ok(product);
	}
	
	
	//Read all users
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Orden> readAll (){
		List<Orden> orders = StreamSupport
				.stream(ordenService.findAll().spliterator(),false)
				.collect(Collectors.toList());
		
		return orders;
				
	}
	
	//Create a new user
	@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping
		public ResponseEntity<?> create(@RequestBody Orden order){
			return ResponseEntity.status(HttpStatus.CREATED).body(ordenService.save(order));
			
		}
	
	

@CrossOrigin(origins = "http://localhost:4200")
		@PutMapping("/{id}")
		public  ResponseEntity<?> update(@RequestBody Orden orderDetails, @PathVariable(value = "id") Long orderId){
			Optional< Orden> order = ordenService.findbyId(orderId);
			
			if(!order.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			//BeanUtils.copyProperties(userDetails, user.get());
			order.get().setEstado(orderDetails.getEstado());
			order.get().setCantidad_impuesto(orderDetails.getCantidad_impuesto());
			order.get().setIdcategoria(orderDetails.getIdcategoria());
			order.get().setEstado_logica(orderDetails.getEstado_logica());
			order.get().setNro_pedido(orderDetails.getNro_pedido());
			order.get().setCliente(orderDetails.getCliente());
			order.get().setFecha(orderDetails.getFecha());
			order.get().setTotal_impuesto(orderDetails.getTotal_impuesto());
			order.get().setTotal(orderDetails.getTotal());
			order.get().setSub_total(orderDetails.getSub_total());
			order.get().setCantidad_total(orderDetails.getCantidad_total());
			
		      
			return ResponseEntity.status(HttpStatus.CREATED).body(ordenService.save(order.get()));
		}

		
	    
	
}
