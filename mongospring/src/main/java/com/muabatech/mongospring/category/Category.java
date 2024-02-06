package com.muabatech.mongospring.category;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.muabatech.mongospring.product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
@Builder
public class Category {
	@Id
	private String id;
	private String name;
	private String description;
}
