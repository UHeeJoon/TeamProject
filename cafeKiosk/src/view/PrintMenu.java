package view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import controller.ProductController;
import model.Product;

public class PrintMenu implements PrintView{
	ProductController productController =  new ProductController();
	@Override
	public void print() {
		List<Product> product = productController.getAllProduct();
		
		ArrayList<String> category = new ArrayList<>();
		for(Product p : product) {
			if(!category.contains(p.getCategory())){
				category.add(p.getCategory());
			}
		}
//		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡMENU LISTㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("=============== 메뉴판 ===============");
		for (int c = 0 ; c < category.size();c++) {
	        System.out.println("============= " + category.get(c) + " ==============");

			for (Product p : product) {
//				System.out.println(p.getCategory() + " " + p.getMenuName() + " " + p.getPrice());
				if (category.get(c).equals(p.getCategory())) {
					String price = new DecimalFormat("###,###").format(p.getPrice());
					String menu_name = String.format("%-12s", p.getMenuName());
					String star = (c&1) == 1 ? "|☆☆ " : "|★★ ";
					System.out.println(star + menu_name + " : " +price);
				}
			}
			System.out.println("===================================");
		}
	}
}
