package view;

import java.util.ArrayList;
import java.util.HashMap;

import controller.TotalSalesController;
import model.TotalSales;

public class PrintTotalSales {
	private HashMap<String, Integer> orderHistory = new HashMap<>();
	private ArrayList<TotalSales> total = new ArrayList<>();
	final TotalSalesController totalSalesController= new TotalSalesController();

	public void printOneDaySales(String day) {
		total = totalSalesController.showSomeDaySales(day);
		int sum = 0;
		System.out.println("== " + day + " 판매 내역 ==");
		for(TotalSales t : total) {
			String order = t.getMenuNcnt();
			for(String str : order.split(",")) {
				int idx = str.indexOf("=");
				String menu = str.substring(0,idx).trim();
				Integer price = Integer.valueOf(str.substring(idx + 1).trim());
				
				orderHistory = init(orderHistory, menu, price);
			}
			
			sum +=t.getTotalPrice();
		}
		
		System.out.println(orderHistory);
		System.out.println("총 판매 금액 : " + sum);
	}

	public void printAllDaySales() {
		total = totalSalesController.showTotalSales();
		
		orderHistory.clear();
	}
	
	
	public static HashMap<String, Integer> init(HashMap<String, Integer> orderHistory, String menuName,
			Integer menuCnt) {
		if (orderHistory.containsKey(menuName))
			orderHistory.replace(menuName, orderHistory.get(menuName) + Integer.valueOf(menuCnt));
		else
			orderHistory.put(menuName, Integer.valueOf(menuCnt));
		return orderHistory;
	}
}
