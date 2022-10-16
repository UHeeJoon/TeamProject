package repository;

import model.TotalSales;

public interface TotalSalesRepository {
	public void insert(TotalSales totalSales);
	public void update(TotalSales totalSales);
	public void delete(TotalSales totalSales);
}
