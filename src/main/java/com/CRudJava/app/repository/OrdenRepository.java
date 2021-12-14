package com.CRudJava.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRudJava.app.entity.Orden;
import com.CRudJava.app.entity.Producto;
import com.CRudJava.app.entity.User;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

	
	
}
