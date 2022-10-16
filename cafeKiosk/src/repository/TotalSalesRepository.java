package repository;

import java.util.List;

import model.TotalSales;

public interface TotalSalesRepository {
	public List<TotalSales> select();
	public void insert(TotalSales totalSales);
	public void update(String menuName);
	public void delete(String menuName);
}
