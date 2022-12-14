package controller;

import java.util.List;

import dto.ProductRequestDto;
import model.Product;
import service.ProductService;

public class ProductController {
	final ProductService productService = new ProductService();

	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}

	public int getProductPrice(String menuName) {
		return productService.getProductPrice(menuName);
	}

	public void addProduct(Product product) {
		ProductRequestDto productRequestDto = new ProductRequestDto();
		productRequestDto.setCategory(product.getCategory());
		productRequestDto.setMenuName(product.getMenuName());
		productRequestDto.setPrice(product.getPrice());
		productService.addProduct(productRequestDto);
		return;
	}

	public void deleteProduct(String name) {
		productService.deleteProduct(name);
	}

	public void updateProduct(String name, int price) {
		productService.updateProduct(name, price);
	}
}
