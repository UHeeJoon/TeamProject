package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import dto.TotalSalesRequestDto;
import model.TotalSales;
import service.TotalSalesService;

public class TotalSalesController {
	final TotalSalesService totalSalesService = new TotalSalesService();

	public void saveOrderHistory(HashMap<String, Integer> orderHistory, int totalPrice) {
		LocalDate now = LocalDate.now();
		String day = now.getYear() + "-" + now.getMonthValue() + "-" + now.getDayOfMonth();
		TotalSalesRequestDto totalSalesRequestDto = new TotalSalesRequestDto(orderHistory.toString(), day, totalPrice);
		totalSalesService.saveOrderHistory(totalSalesRequestDto);
		return;
	}

	public ArrayList<TotalSales> showTotalSales() {
		return totalSalesService.showTotalSales();
	}

	public void delete(String menuName) {
		totalSalesService.delete(menuName);
	}

	public void update(String menuName) {
		totalSalesService.update(menuName);
	}
}
