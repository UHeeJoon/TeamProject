package dao;

import java.util.List;

import model.Product;
import repository.ProductRepository;

public class ProductRepositoryDao extends ConnectDB implements ProductRepository {

	@Override
	public List<Product> select() {
		connectDB();
		List<Product> product = null;
		return product;
	}

	@Override
	public void insert(Product product) {
		connectDB();
	}

	@Override
	public void update(Product product) {
		connectDB();
	}

	@Override
	public void delete(Product product) {
		connectDB();
	}

}
