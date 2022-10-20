package model;

import dto.TotalSalesRequestDto;

public class TotalSales {
	private String menuNcnt;
	private String day;
	private int totalPrice;

	public String getMenuNcnt() {
		return menuNcnt;
	}

	public void setMenuNcnt(String menuNcnt) {
		this.menuNcnt = menuNcnt;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public TotalSales(TotalSalesRequestDto totalSalesRequestDto) {
		this.menuNcnt = totalSalesRequestDto.getMenuNcnt();
		this.day = totalSalesRequestDto.getDay();
		this.totalPrice = totalSalesRequestDto.getTotalPrice();
	}

	public TotalSales() {
	}

}
