package com.vinicius.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.projeto.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
	