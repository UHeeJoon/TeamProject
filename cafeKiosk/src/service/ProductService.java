package service;

import java.util.List;

import dao.ProductRepositoryDao;
import dto.ProductRequestDto;
import model.Product;

public class ProductService {
	private final ProductRepositoryDao productRepositoryDao = new ProductRepositoryDao();
	
	public void addProduct(ProductRequestDto productRequestDto) {
		Product product = new Product(productRequestDto);
		productRepositoryDao.insert(product);
		return;
	}
	public void deleteProduct(String menuName) {
		
	}
	public void updateProduct(String menuName) {
		
	}
	public List<Product> getAllProduct(){
		return productRepositoryDao.select();
	}
}
