package view;

import java.util.HashMap;

public class PrintBill {

	public void print(HashMap<String, Integer> orderHistory) {
		System.out.println();
		System.out.println("================ 영수증 ================");
		System.out.println(new AdminInfo());
		System.out.println("======================================");
		new OrderHistory().print(orderHistory);
		System.out.println();
	};

}