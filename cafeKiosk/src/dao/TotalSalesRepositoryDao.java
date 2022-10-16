package dao;

import java.util.List;

import model.TotalSales;
import repository.TotalSalesRepository;

public class TotalSalesRepositoryDao extends ConnectDB implements TotalSalesRepository {

	@Override
	public void insert(TotalSales totalSales) {
		connectDB();
	}

	@Override
	public void update(String menuName) {
		connectDB();
	}

	@Override
	public void delete(String menuName) {
		connectDB();		
	}

	@Override
	public List<TotalSales> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
