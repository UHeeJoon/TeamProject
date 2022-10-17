package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import repository.ProductRepository;

public class ProductRepositoryDao extends ConnectDB implements ProductRepository {

	@Override
	public List<Product> select() {
		connectDB();
		ArrayList<Product> product = new ArrayList<>();
		try {
			sql = "SELECT category_name, menu_name, price FROM product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product product_tmp = new Product();
				product_tmp.setCategory(rs.getString("category_name"));
				product_tmp.setMenu_name(rs.getString("menu_name"));
				product_tmp.setPrice(rs.getInt("price"));
				product.add(product_tmp);
			}
		} catch (SQLException e) {
//			e.printStackTrace();
		} catch(Exception e){
//			e.printStackTrace();
		}
		finally {
			if (conn != null) {
				try {
					// 연결 끊기
					conn.close();
					rs.close();
					pstmt.close();
				} catch (SQLException e) {}
			}
		}
		return product;
	}

	@Override
	public void insert(Product product) {
		connectDB();
	}

	@Override
	public void update(String menuName) {
		connectDB();
	}

	@Override
	public void delete(String menuName) {
		connectDB();
	}

}
