package com.CRudJava.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

import com.CRudJava.app.entity.Producto;
import com.CRudJava.app.entity.User;
import com.CRudJava.app.service.ProductoServiceImple;
import com.CRudJava.app.service.UserServiceImple;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
	private ProductoServiceImple productoService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long userId ){
		Optional<Producto> product = productoService.findbyId(userId);
		
		if(!product.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
	 return ResponseEntity.ok(product);
	}
	
	
	//Read all users
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Producto> readAll (){
		List<Producto> products = StreamSupport
				.stream(productoService.findAll().spliterator(),false)
				.collect(Collectors.toList());
		
		return products;
				
	}
	
	//Create a new user
	@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping
		public ResponseEntity<?> create(@RequestBody Producto product){
			return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(product));
			
		}
		
	    @CrossOrigin(origins = "http://localhost:4200")
		@PutMapping("/{id}")
		public  ResponseEntity<?> update(@RequestBody Producto productDetails, @PathVariable(value = "id") Long productId){
			Optional< Producto> product = productoService.findbyId(productId);
			
			if(!product.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			//BeanUtils.copyProperties(userDetails, user.get());
			product.get().setNombre(productDetails.getNombre());
			product.get().setPrecio_unitario(productDetails.getPrecio_unitario());
			product.get().setIdcategoria(productDetails.getIdcategoria());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(product.get()));
		}
	
}
