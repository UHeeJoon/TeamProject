package model;

import java.util.Date;

import dto.TotalSalesRequestDto;

public class TotalSales {
	private String menuName;
	private int price;
	private Date day;
	private int order_cnt;
	private int totalPrice;
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public int getOrder_cnt() {
		return order_cnt;
	}
	public void setOrder_cnt(int order_cnt) {
		this.order_cnt = order_cnt;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public TotalSales(TotalSalesRequestDto totalSalesRequestDto) {
		super();
		this.menuName = totalSalesRequestDto.getMenuName();
		this.price = totalSalesRequestDto.getPrice();
		this.day = totalSalesRequestDto.getDay();
		this.order_cnt = totalSalesRequestDto.getOrder_cnt();
		this.totalPrice = totalSalesRequestDto.getTotalPrice();
	}
	
}
