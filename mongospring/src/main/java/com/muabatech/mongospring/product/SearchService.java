package com.muabatech.mongospring.product;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchService {
	
	private final MongoTemplate template;
	
	public List<Product> searchyName(String name){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		List<Product> products = template.find(query, Product.class);
		return products;
	}
	
	public List<Product> searchByNameStartsWith(String name){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex("^"+name));
		List<Product> products = template.find(query, Product.class);
		return products;
	}
	public List<Product> searchByNameEndingWith(String name){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex(name+"$"));
		List<Product> products = template.find(query, Product.class);
		return products;
	}
	public List<Product> searchByPriceLt(BigDecimal price){
		Query query = new Query();
		query.addCriteria(Criteria.where("price").lt(price));
		List<Product> products = template.find(query, Product.class);
		return products;
	}
	public List<Product> searchByPriceGt(BigDecimal price){
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gt(price));
		List<Product> products = template.find(query, Product.class);
		return products;
	}
	public List<Product> sortAscByField(String fieldName){
		Query query = new Query();
		query.with(Sort.by(Direction.ASC,fieldName));
		List<Product> products = template.find(query, Product.class);
		return products;
	}
	public List<Product> sortAndPageByField(String fieldName){
		Query query = new Query();
		Pageable pageable = PageRequest.of(0, 2,Sort.by(Direction.ASC,fieldName));
		query.with(pageable);
		List<Product> products = template.find(query, Product.class);
		return products;
	}
	
}
