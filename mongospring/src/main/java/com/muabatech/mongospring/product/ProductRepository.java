package com.muabatech.mongospring.product;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String>{
	List<Product> findAllByNameIgnoreCase(String name);
	List<Product> findAllByNameStartingWith(String name);
	List<Product> findAllByNameEndingWith(String name);
	List<Product> findAllByNameContainingIgnoreCase(String name);
	List<Product> findAllByPriceLessThan(BigDecimal price);
	List<Product> findAllByPriceGreaterThan(BigDecimal price);
	List<Product> findAllByPriceBetween(BigDecimal price1,BigDecimal price2);
	List<Product> findAllByNameContainingIgnoreCaseOrderByPriceDesc(String name);
	List<Product> findAllByNameContainingIgnoreCaseOrderByPriceDesc(String name,Pageable page);
}
