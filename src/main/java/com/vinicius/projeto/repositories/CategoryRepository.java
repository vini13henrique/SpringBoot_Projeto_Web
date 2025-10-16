package com.vinicius.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.projeto.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
	