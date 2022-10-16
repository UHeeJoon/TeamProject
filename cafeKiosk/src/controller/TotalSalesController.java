package controller;

import java.util.List;

import dto.TotalSalesRequestDto;
import model.TotalSales;
import service.TotalSalesService;

public class TotalSalesController {
	final TotalSalesService totalSalesService = new TotalSalesService();
	
	public void saveOrderHistory( TotalSalesRequestDto totalSalesRequestDto) {
		totalSalesService.saveOrderHistory(totalSalesRequestDto);
		return;
	}
	public List<TotalSales> showTotalSales(){
		return totalSalesService.showTotalSales();
	}
	public void delete(String menuName) {
		totalSalesService.delete(menuName);
	}
	public void update(String menuName) {
		totalSalesService.update(menuName);
	}
}
