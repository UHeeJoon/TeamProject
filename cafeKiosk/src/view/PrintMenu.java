package view;

import java.util.ArrayList;
import java.util.List;

import controller.ProductController;
import model.Product;

public class PrintMenu {
	ProductController productController =  new ProductController();
	public void print() {
		List<Product> product = productController.getAllProduct();
		
		ArrayList<String> category = new ArrayList<>();
		for(Product p : product) {
			if(!category.contains(p.getCategory())){
				category.add(p.getCategory());
			}
		}
		for (String c : category) {
			System.out.println(c);
			for (Product p : product) {
//				System.out.println(p.getCategory() + " " + p.getMenuName() + " " + p.getPrice());
				if (c.equals(p.getCategory())) {
					System.out.println("== " + p.getMenuName() + " : " + p.getPrice());
				}
			}
		}
	}
}
