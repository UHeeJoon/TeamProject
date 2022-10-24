package dto;

public class ProductRequestDto {
	private String menuName;
	private String category;
	private int price;

	public String getMenuName() {
		return menuName;
	}

	public String getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
