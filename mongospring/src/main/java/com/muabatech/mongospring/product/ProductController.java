package com.muabatech.mongospring.product;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService service;
	private final SearchService searchService;
	@PostMapping
	public ResponseEntity<String>save(@RequestBody Product product){
		return ResponseEntity.ok(service.save(product));
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	@GetMapping("/{productId}")
	public ResponseEntity<Product> findById(@PathVariable("productId") String productId){
		return ResponseEntity.ok(service.findById(productId));
	}
	@DeleteMapping("/productId")
	public ResponseEntity<Void> delete(@PathVariable("productId") String productId){
		service.delete(productId);
		return ResponseEntity.accepted().build();
	}
	@GetMapping("/search/is")
	public ResponseEntity<List<Product>> searchByName(@RequestParam("name") String name){
		return ResponseEntity.ok(searchService.searchyName(name));
	}
	@GetMapping("/search/starts-with")
	public ResponseEntity<List<Product>> searchByNameStartsWith(@RequestParam("name") String name){
		return ResponseEntity.ok(searchService.searchByNameStartsWith(name));
	}
	@GetMapping("/search/ending-with")
	public ResponseEntity<List<Product>> searchByNameEndingWith(@RequestParam("name") String name){
		return ResponseEntity.ok(searchService.searchByNameEndingWith(name));
	}
	@GetMapping("/search/lt")
	public ResponseEntity<List<Product>> searchByPriceLt(@RequestParam("price") BigDecimal price){
		return ResponseEntity.ok(searchService.searchByPriceLt(price));
	}
	@GetMapping("/search/gt")
	public ResponseEntity<List<Product>> searchByPriceGt(@RequestParam("price") BigDecimal price){
		return ResponseEntity.ok(searchService.searchByPriceGt(price));
	}
	@GetMapping("/sort/asc")
	public ResponseEntity<List<Product>> sortByField(@RequestParam("fieldName") String fieldName){
		return ResponseEntity.ok(searchService.sortAscByField(fieldName));
	}
	@GetMapping("/sort-page")
	public ResponseEntity<List<Product>> sortAndPage(@RequestParam("fieldName") String fieldName){
		return ResponseEntity.ok(searchService.sortAndPageByField(fieldName));
	}
}
