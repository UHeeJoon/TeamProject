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
		productRepositoryDao.delete(menuName);
	}

	public void updateProduct(String menuName, int price) {
		productRepositoryDao.update(menuName, price);
	}

	public List<Product> getAllProduct() {
		return productRepositoryDao.select();
	}

	public int getProductPrice(String menuName) {
		return productRepositoryDao.select(menuName);
	}
}
