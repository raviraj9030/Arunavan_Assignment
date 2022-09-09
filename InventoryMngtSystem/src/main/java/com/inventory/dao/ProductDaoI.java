package com.inventory.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.entity.ProductEntity;

public interface ProductDaoI extends JpaRepository<ProductEntity, Integer>{

	public Optional<ProductEntity> findByDescription(String productDesc);

	public void deleteByDescription(String productDesc);

}
