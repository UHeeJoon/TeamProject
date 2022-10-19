package cafeKioskMain;

import java.util.HashMap;
import java.util.Scanner;

import view.AdminView;
import view.PrintMenu;

public class KioskMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 변수 선언 부 시작
		String select = null;
		String menuName = null;
		String menuCnt = null;
		String isContinue = null;
		HashMap<String, Integer> orderHistory = new HashMap<>();
		// 변수 선언부 끝

		LogoPrint();

		while (true) {
			System.out.println(
						""
						+ "1.주문하기\n" 
						+ "2.관리자 화면으로 가기");
			
			if ((sc.nextLine()).equals("1")) {
				new PrintMenu().print();
				System.out.println(">> 주문하시겠습니까?(y/n)");
				select = sc.nextLine();

				if (select.equals("n") || select.equals("N"))
					break;
				else if (select.equals("y") || select.equals("Y")) {
					System.out.println("☆★☆★☆★☆★주 문☆★☆★☆★☆★");
					do {
						System.out.println("메뉴 명 : ");
						menuName = sc.nextLine();
						System.out.println("수  량 : ");
						menuCnt = sc.nextLine();
						orderHistory.put(menuName, Integer.valueOf(menuCnt));
						System.out.println("추가 주문 하시겠습니까?(y/n)");
						isContinue = sc.nextLine();

					} while (isContinue.equals("y") || isContinue.equals("Y"));
				} else {
					System.out.println("※※※※입력 오류※※※※※");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
					}
				}
			}
			else {
				new AdminView().print();
			}
		}
		System.out.println("종료");

		sc.close();
	}

	public static void LogoPrint() {
		String[] logo = {
				"\n==============================================================================================================\n"
						+ "==============================================================================================================",
				"\t||    ||     //\\\\   ||||||||||   ||||||			||||||||     //\\\\     ||||||||  ||||||||",
				"\t||    ||    //  \\\\      ||	 ||                     ||          //  \\\\    ||        ||      ",
				"\t||||||||   ||    ||     ||       ||||||    		||         ///||\\\\\\   ||||||||  ||||||||",
				"\t||    ||    \\\\  //      ||       ||  ||			||        //      \\\\  ||        ||      ",
				"\t||    ||     \\\\//       ||       ||||||			|||||||| //        \\\\ ||        ||||||||",
				"==============================================================================================================\n"
						+ "==============================================================================================================\n" };
		for (String str : logo) {
			System.out.println(str);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}

}
