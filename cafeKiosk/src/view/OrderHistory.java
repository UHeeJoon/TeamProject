package view;

import java.util.HashMap;
import java.util.Iterator;

import controller.ProductController;

public class OrderHistory{
	final private ProductController productController = new ProductController();
	
	public int print(HashMap<String,Integer> orderHistory) {
		Iterator<String>keys = orderHistory.keySet().iterator();
		int total_price = 0;
		System.out.println("============= 주문 내역 =============");
		System.out.println("메뉴\t\t수량\t\t가격");
		while(keys.hasNext()) {
			String menu = keys.next();
			Integer cnt = orderHistory.get(menu);
			int price = productController.getProductPrice(menu) * (int)cnt;
			total_price += price;
			System.out.println((menu.length()>6?menu + "\t" : menu + "\t\t") + cnt + "\t\t" +  price );
			
		}
		System.out.println("==================================");
		System.out.println("합계 : " + total_price);
		System.out.println();
		return total_price;
	}
	
}	
