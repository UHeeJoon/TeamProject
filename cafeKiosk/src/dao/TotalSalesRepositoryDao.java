package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.TotalSalesRequestDto;
import model.TotalSales;
import repository.TotalSalesRepository;

public class TotalSalesRepositoryDao extends ConnectDB implements TotalSalesRepository {

	@Override
	public void insert(TotalSales totalSales) {
		// 변수 선언
		String day = totalSales.getDay();
		String menuNcnt = totalSales.getMenuNcnt();
		menuNcnt = menuNcnt.substring(1, menuNcnt.length() - 1);
		int totalPrice = totalSales.getTotalPrice();
		// 변수 선언 끝
		System.out.println(day + " " + menuNcnt + " " + totalPrice);
		// db 연결
		connectDB();

		try {
			String sql = "INSERT INTO Total_Sales " + "VALUES(?, ?, ?)";

			// PreparedStatement 얻기 및 값 지정
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, java.sql.Date.valueOf(day));
			pstmt.setString(2, menuNcnt);
			pstmt.setInt(3, totalPrice);
			pstmt.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
		} catch (NullPointerException e) {
//			e.printStackTrace();
		} finally {
			// db연결 해제
			terminateDB();
		}
	}

	// 사용 안함 ===========================================
	@Override
	public void update(String menuName) {
	}

	@Override
	public void delete(String menuName) {
	}
	// ==================================================

	@Override
	public ArrayList<TotalSales> getAllDays() {
		ArrayList<TotalSales> allDay = new ArrayList<>();

		connectDB();

		try {
			sql = "SELECT day, menuNcnt, Total_price FROM total_sales ORDER BY day";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TotalSalesRequestDto totalSalesRequestDto = new TotalSalesRequestDto();
				totalSalesRequestDto.setDay(rs.getString("day"));
				totalSalesRequestDto.setMenuNcnt(rs.getString("menuNcnt"));
				totalSalesRequestDto.setTotalPrice(rs.getInt("total_price"));
				allDay.add(new TotalSales(totalSalesRequestDto));
			}
		} catch (SQLException e) {
//			e.printStackTrace();
		} finally {
			terminateDB();
		}
		return allDay;
	}

	@Override
	public ArrayList<TotalSales> getOneDay(String day) {
		ArrayList<TotalSales> oneDay = new ArrayList<>();

		connectDB();

		try {
			sql = "SELECT day, menuNcnt, Total_price FROM total_sales WHERE day = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, day);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TotalSalesRequestDto totalSalesRequestDto = new TotalSalesRequestDto();
				totalSalesRequestDto.setDay(rs.getString("day"));
				totalSalesRequestDto.setMenuNcnt(rs.getString("menuNcnt"));
				totalSalesRequestDto.setTotalPrice(rs.getInt("total_price"));
				oneDay.add(new TotalSales(totalSalesRequestDto));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			terminateDB();
		}
		return oneDay;
	}

}
