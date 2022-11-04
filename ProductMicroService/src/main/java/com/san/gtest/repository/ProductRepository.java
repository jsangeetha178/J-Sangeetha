package com.san.gtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.san.gtest.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>,ProductCustomRepository{

}
