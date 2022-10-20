package dto;


public class TotalSalesRequestDto {
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
	public TotalSalesRequestDto(String menuNcnt, String day, int totalPrice) {
		this.menuNcnt = menuNcnt;
		this.day = day;
		this.totalPrice = totalPrice;
	}
}
