package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import repository.ProductRepository;

public class ProductRepositoryDao extends ConnectDB implements ProductRepository {

	@Override
	public List<Product> select() {
		ArrayList<Product> product = new ArrayList<>();

		connectDB();

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
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			terminateDB();
		}
		return product;
	}

	@Override
	public int select(String menuName) {
		connectDB();
		int price = 0;
		try {
			sql = "SELECT price FROM product WHERE menu_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menuName);
			rs = pstmt.executeQuery();
			rs.next();
			price = rs.getInt("price");
		} catch (SQLException e) {
//			e.printStackTrace();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			terminateDB();
		}
		return price;
	}

	@Override
	public void insert(Product product) {
		connectDB();
		try {
			sql = "INSERT INTO product values(?,?,?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getMenuName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getCategory());
			pstmt.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
		} finally {
			terminateDB();
		}
	}

	@Override
	public void update(String menuName, int price) {
		connectDB();
		try {
			String sql = new StringBuilder() // 문자열을 추가가 가능함, String은 추가 변경이 안됨
					.append("UPDATE total_sales SET ").append("price=?, ").append("WHERE menu_name=?").toString();

			// PreparedStatement 얻기 및 값 지정
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1200);
			pstmt.setString(2, menuName);
		} catch (SQLException e) {
//			e.printStackTrace();
		} finally {
			terminateDB();
		}
	}

	@Override
	public void delete(String menuName) {
		connectDB();
		try {
			String sql = "DELETE FROM product WHERE menu_name=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menuName);
			pstmt.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
		} finally {
			terminateDB();
		}
	}

}
