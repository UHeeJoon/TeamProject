package service;

import java.util.List;

import dao.TotalSalesRepositoryDao;
import dto.TotalSalesRequestDto;
import model.TotalSales;

public class TotalSalesService {
	private final TotalSalesRepositoryDao totalSalesRepositoryDao = new TotalSalesRepositoryDao();
	
	public void saveOrderHistory( TotalSalesRequestDto totalSalesRequestDto) {
		TotalSales totalSales= new TotalSales(totalSalesRequestDto);
		totalSalesRepositoryDao.insert(totalSales);
		return;
	}
	public List<TotalSales> showTotalSales(){
		return totalSalesRepositoryDao.select();
	}
	public void deleteProduct(String menuName) {
		totalSalesRepositoryDao.delete(menuName);
	}
	public void updateProduct(String menuName) {
		totalSalesRepositoryDao.delete(menuName);
	}
}
