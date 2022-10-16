package dto;

import java.util.Date;

public class TotalSalesRequestDto {
	private String menuName;
	private int price;
	private Date day;
	private int order_cnt;
	private int totalPrice;
	public String getMenuName() {
		return menuName;
	}
	public int getPrice() {
		return price;
	}
	public Date getDay() {
		return day;
	}
	public int getOrder_cnt() {
		return order_cnt;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
}
