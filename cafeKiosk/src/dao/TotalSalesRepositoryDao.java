package dao;

import java.sql.SQLException;
import java.util.List;

import model.TotalSales;
import repository.TotalSalesRepository;

public class TotalSalesRepositoryDao extends ConnectDB implements TotalSalesRepository {

	@Override
	public void insert(TotalSales totalSales) {
		String day = totalSales.getDay();
		String menuNcnt = totalSales.getMenuNcnt();
		menuNcnt = menuNcnt.substring(1, menuNcnt.length()-1);
		int totalPrice =  totalSales.getTotalPrice();
		System.out.println(day + " " +menuNcnt + " " + totalPrice );
		connectDB();
		try {
		String sql = "INSERT INTO Total_Sales "
				+ "VALUES(?, ?, ?)";
		
		//PreparedStatement 얻기 및 값 지정
		pstmt = conn.prepareStatement(sql);
		pstmt.setDate(1, java.sql.Date.valueOf(day));
		pstmt.setString(2, menuNcnt);
		pstmt.setInt(3, totalPrice);
		pstmt.executeUpdate();
		}catch(SQLException e) {
//			e.printStackTrace();
		}catch(NullPointerException e) {
//			e.printStackTrace();
		}
		finally {
			terminateDB();
		}
	}

	@Override
	public void update(String menuName) {
		connectDB();
	}

	@Override
	public void delete(String menuName) {
		connectDB();		
	}

	@Override
	public List<TotalSales> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
