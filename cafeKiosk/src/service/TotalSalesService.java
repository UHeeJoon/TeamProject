package service;

import java.util.ArrayList;

import dao.TotalSalesRepositoryDao;
import dto.TotalSalesRequestDto;
import model.TotalSales;

public class TotalSalesService {
	private final TotalSalesRepositoryDao totalSalesRepositoryDao = new TotalSalesRepositoryDao();

	public void saveOrderHistory(TotalSalesRequestDto totalSalesRequestDto) {
		TotalSales totalSales = new TotalSales(totalSalesRequestDto);
		totalSalesRepositoryDao.insert(totalSales);
		return;
	}

	public ArrayList<TotalSales> showTotalSales() {
		return totalSalesRepositoryDao.getAllDays();
	}

	public ArrayList<TotalSales> showSomeDaySales(String day) {
		return totalSalesRepositoryDao.getOneDay(day);
	}

	public void delete(String menuName) {
		totalSalesRepositoryDao.delete(menuName);
	}

	public void update(String menuName) {
		totalSalesRepositoryDao.update(menuName);
	}
}
