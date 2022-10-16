package model;

import dto.ProductRequestDto;

public class Product {
	private String menuName;
	private String category;
	private int price;

	public Product() {
	}

	public Product(ProductRequestDto productRequestDto) {
		menuName = productRequestDto.getMenuName();
		category = productRequestDto.getCategory();
		price = productRequestDto.getPrice();
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenu_name(String menuName) {
		this.menuName = menuName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
