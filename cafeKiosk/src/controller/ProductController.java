package controller;

import dto.ProductRequestDto;
import service.ProductService;

public class ProductController {
	final ProductService productService = new ProductService();
	
	public void addProduct(ProductRequestDto productRequestDto) {
		productService.addProduct(productRequestDto);
		return;
	}
	
}
