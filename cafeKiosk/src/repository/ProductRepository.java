package repository;

import java.util.List;

import model.Product;

public interface ProductRepository {
	public List<Product> select();
	public void insert(Product product);
	public void update(Product product);
	public void delete(Product product);
}
