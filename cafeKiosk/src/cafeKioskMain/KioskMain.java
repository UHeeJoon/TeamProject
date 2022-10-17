package cafeKioskMain;

import java.util.Scanner;

import view.PrintMenu;

public class KioskMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("시작");
		while (true) {
			new PrintMenu().print();
			System.out.println("입력");
			String select = sc.next();
			if(select.equals("4"))break;
		}
		System.out.println("종료");
		
		sc.close();
	}

}
