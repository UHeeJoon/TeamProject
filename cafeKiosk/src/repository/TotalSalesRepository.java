package repository;

import java.util.ArrayList;

import dto.TotalSalesRequestDto;
import model.TotalSales;

public interface TotalSalesRepository {
	public ArrayList<TotalSales> getAllDays();

	public TotalSalesRequestDto getOneDay(String day);

	public void insert(TotalSales totalSales);

	public void update(String menuName);

	public void delete(String menuName);
}
