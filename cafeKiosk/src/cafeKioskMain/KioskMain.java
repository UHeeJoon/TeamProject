package cafeKioskMain;

import java.util.HashMap;
import java.util.Scanner;

import controller.TotalSalesController;
import view.AdminView;
import view.OrderHistory;
import view.PrintMenu;

public class KioskMain {

	public static void main(String[] args) {
		// 변수 선언 부 시작
		Scanner sc = new Scanner(System.in);
		String select = null;
		String menuName = null;
		String menuCnt = null;
		String isContinue = null;
		int totalPrice = 0;
		HashMap<String, Integer> orderHistory = new HashMap<>();
		// 변수 선언부 종료

		// 로고 출력
		LogoPrint();
		// cafe 프로그램 시작
		while (true) {
			System.out.println("================");
			System.out.println("∥1.주문하기\t\t∥");
			System.out.println("∥2.관리자 화면으로 가기\t∥");
			System.out.println("================");
			select = sc.nextLine();
			if (select.equals("1")) {
				// Menu판 출력
				new PrintMenu().print();
				System.out.println("☆★☆★☆★☆★주 문☆★☆★☆★☆★");

				// start of do-while
				do {
					// 메뉴 저장
					System.out.print("메뉴 >> ");
					menuName = sc.nextLine();
					// 수량 저장
					System.out.print("수량 >> ");
					menuCnt = sc.nextLine();
					// 주문 내역 orderHistory 저장
					orderHistory = init(orderHistory, menuName.trim(), Integer.valueOf(menuCnt));
					// 추가 주문 여부 확인
					// 주문 내역 출력
					new OrderHistory().print(orderHistory);
					System.out.print("추가 주문 하시겠습니까?(y/n) >> ");
					isContinue = sc.nextLine();

				} while (isContinue.equals("y") || isContinue.equals("Y"));
				// end of do-while
				
				totalPrice = new OrderHistory().print(orderHistory);
				
//				System.out.println("결제 하시겠습니까?(y/n) >>");
//				select = sc.nextLine();
				new TotalSalesController().saveOrderHistory(orderHistory, totalPrice);

			} else if (select.equals("2")) {
				new AdminView().print();
			} else
				break;
		}
		// cafe 프로그램 종료
		System.out.println("종료");

		sc.close();
	}

	public static void LogoPrint() {
		String[] logo = {
				"\n==============================================================================================================\n"
						+ "==============================================================================================================",
				"\t||    ||     //\\\\   ||||||||||   ||||||			  ||||||     //\\\\     ||||||||  ||||||||",
				"\t||    ||    //  \\\\      ||	 ||                     ||          //  \\\\    ||        ||      ",
				"\t||||||||   ||    ||     ||       ||||||    		||         ///||\\\\\\   ||||||||  ||||||||",
				"\t||    ||    \\\\  //      ||       ||  ||			||        //      \\\\  ||        ||      ",
				"\t||    ||     \\\\//       ||       ||||||			  |||||| //        \\\\ ||        ||||||||",
				"==============================================================================================================\n"
						+ "==============================================================================================================\n" };
		for (String str : logo) {
			System.out.println(str);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		return;
	}

	public static HashMap<String, Integer> init(HashMap<String, Integer> orderHistory, String menuName,
			Integer menuCnt) {
		if (orderHistory.containsKey(menuName))
			orderHistory.replace(menuName, orderHistory.get(menuName) + Integer.valueOf(menuCnt));
		else
			orderHistory.put(menuName, Integer.valueOf(menuCnt));
		return orderHistory;
	}

}
