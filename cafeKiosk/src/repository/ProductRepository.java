package repository;

import java.util.List;

import model.Product;

public interface ProductRepository {
	public List<Product> select();
	public void insert(Product product);
	public void update(String menuName, int price);
	public void delete(String menuName);
}
