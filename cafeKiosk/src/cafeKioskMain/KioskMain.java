package cafeKioskMain;

import java.util.Scanner;

import view.PrintBill;
import view.PrintMenu;

public class KioskMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("===================================");
		System.out.println("☆★☆★HOt6 Cafe에 오신걸 환영합니다!!☆★☆★");
		System.out.println("   메인으로 가시려면 화면을 터치해주세요.");
		System.out.println("===================================");
		while (true) {
			System.out.println("1.메뉴판");
			System.out.println("2.주문현황 확인");
			System.out.println("3.결제하기");
			System.out.println("4.영수증 출력하기");
			System.out.println("5.관리자 화면으로");
			System.out.print("입력 >> ");
			String select = sc.next();
			if (select.equals("1")) {
				new PrintMenu().print();
				System.out.println("=====================================");
			}
			else if(select.equals("4")) {
				new PrintBill().print();
				System.out.println("=====================================");
			}
			else {
				break;
			}
		}
		System.out.println("종료");

		sc.close();
	}

}
