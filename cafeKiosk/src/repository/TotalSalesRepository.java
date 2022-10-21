package repository;

import java.util.ArrayList;

import model.TotalSales;

public interface TotalSalesRepository {
	public ArrayList<TotalSales> getAllDays();

	public ArrayList<TotalSales> getOneDay(String day);

	public void insert(TotalSales totalSales);

	public void update(String menuName);

	public void delete(String menuName);
}
