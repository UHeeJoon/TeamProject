package dao;

import model.TotalSales;
import repository.TotalSalesRepository;

public class TotalSalesRepositoryDao extends ConnectDB implements TotalSalesRepository {

	@Override
	public void insert(TotalSales totalSales) {
		connectDB();
	}

	@Override
	public void update(TotalSales totalSales) {
		connectDB();
	}

	@Override
	public void delete(TotalSales totalSales) {
		connectDB();		
	}

}
