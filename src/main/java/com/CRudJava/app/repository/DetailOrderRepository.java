package com.CRudJava.app.repository;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CRudJava.app.entity.DetailOrder;
import com.CRudJava.app.entity.DetailOrderResponse;
import com.CRudJava.app.entity.Orden;
import com.CRudJava.app.entity.Producto;
import com.CRudJava.app.entity.User;

@Repository
public interface DetailOrderRepository extends JpaRepository<DetailOrder, Long> {

	@Query(value="select detail_order.id,  detail_order.id_producto, detail_order.id_orden, detail_order.cantidad, detail_order.costo from  detail_order   where detail_order.id_orden = :id", nativeQuery = true)
	public Optional<DetailOrder> findbyIdOrder(@PathParam("id") Long id);
	
}
