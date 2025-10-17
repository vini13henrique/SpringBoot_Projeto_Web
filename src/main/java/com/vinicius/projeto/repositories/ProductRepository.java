package com.vinicius.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.projeto.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
	