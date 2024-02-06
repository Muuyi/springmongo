package com.muabatech.mongospring.product;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/method-queries")
@RequiredArgsConstructor
public class QueryMethodController {
	private final QueryMethodService service;
	@GetMapping("/search/is")
	public ResponseEntity<List<Product>> searchByName(@RequestParam("name") String name){
		return ResponseEntity.ok(service.searchyName(name));
	}
	@GetMapping("/search/starts-with")
	public ResponseEntity<List<Product>> searchByNameStartsWith(@RequestParam("name") String name){
		return ResponseEntity.ok(service.searchByNameStartsWith(name));
	}
	@GetMapping("/search/ending-with")
	public ResponseEntity<List<Product>> searchByNameEndingWith(@RequestParam("name") String name){
		return ResponseEntity.ok(service.searchByNameEndingWith(name));
	}
	@GetMapping("/search/containing")
	public ResponseEntity<List<Product>> searchByNameContaining(@RequestParam("name") String name){
		return ResponseEntity.ok(service.searchByNameContaining(name));
	}
	@GetMapping("/search/lt")
	public ResponseEntity<List<Product>> searchByPriceLt(@RequestParam("price") BigDecimal price){
		return ResponseEntity.ok(service.searchByPriceLt(price));
	}
	@GetMapping("/search/gt")
	public ResponseEntity<List<Product>> searchByPriceGt(@RequestParam("price") BigDecimal price){
		return ResponseEntity.ok(service.searchByPriceGt(price));
	}
	@GetMapping("/search/between")
	public ResponseEntity<List<Product>> searchByPriceBetween(@RequestParam("price1") BigDecimal price1,@RequestParam("price2") BigDecimal price2){
		return ResponseEntity.ok(service.searchByPriceBetween(price1,price2));
	}
	@GetMapping("/sort/asc")
	public ResponseEntity<List<Product>> searchAndSortAsc(String name){
		return ResponseEntity.ok(service.searchAndSortAsc(name));
	}
	@GetMapping("/sort-page")
	public ResponseEntity<List<Product>>SortAndPageByField(@RequestParam("field") String field,@RequestParam(value="pageNumber",required=false,defaultValue="0") int pageNumber,@RequestParam(value="size",required=false,defaultValue="0") int size){
		return ResponseEntity.ok(service.searchAndPageByField(field,pageNumber,size));
	}
}
