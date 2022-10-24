package cafeKioskMain;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import controller.ProductController;
import controller.TotalSalesController;
import model.Product;
import view.OrderHistory;
import view.PrintBill;
import view.PrintMenu;
import view.PrintTotalSales;

public class KioskMain {

	public static void main(String[] args) throws IOException {
		// 변수 선언 부 시작
		Scanner sc = new Scanner(System.in);
		int select = 0;
		int isContinue = 0;
		String menuName = null;
		String menuCnt = null;
		int totalPrice = 0;

		HashMap<String, Integer> orderHistory = new HashMap<>();
		final ProductController productController = new ProductController();
		// 변수 선언부 종료

		// 로고 출력
		LogoPrint();
		// cafe 프로그램 시작

		// start of mainWhile
		mainWhile: while (true) {
			// 주문 내역 초기화
			orderHistory.clear();
			System.out.println();
			System.out.println("==================");
			System.out.println("∥1.주문하기\t ∥");
			System.out.println("∥2.관리자 화면으로 가기∥");
			System.out.println("==================");
			System.out.print("입력 >> ");
			select = check(sc.nextLine());
			// =========================== 주문 화면 시작 ==========================
			// 메뉴화면 선택 1일때의 if문 종료
			if (select == 1) {
				// Menu판 출력
				new PrintMenu().print();
				System.out.print("주문하시겠습니까?(y/n) >> ");
				select = check(sc.nextLine());

				// 주문 여부 y의 if문 시작
				if (select == 1) {

					// start of for-loop
					order: for (;;) {
						// 주문 내역이 비어있지 않으면 주문 내역 출력 및 수정
						if (!orderHistory.isEmpty()) {
							// 주문 내역 출력
							System.out.println("============== 주문 내역 ===============");
							new OrderHistory().print(orderHistory);

							// 추가 주문 여부 확인/ 주문 내역 수정
							System.out.println("============");
							System.out.println("∥ 1. 추가 주문 ∥");
							System.out.println("∥ 2. 주문 수정 ∥");
							System.out.println("∥ 3. 결재 하기 ∥");
							System.out.println("============");
							System.out.print("입력 >> ");
							isContinue = check(sc.nextLine());
							// 추가 주문 ==> if - else문 무시하고 밑으로
							if (isContinue == 1)
								;
							// 주문 수정
							else if (isContinue == 2) {
								System.out.print("수정할 메뉴 >> ");
								String menu = sc.nextLine();
								// 메뉴 입력 오류 처리
								if (!orderHistory.containsKey(menu)) {
									System.out.println("※입력 오류※\n>>> 다시 확인해주세요.");
									continue;
								}
								System.out.print("변경 수량 >> ");
								String cnt = sc.nextLine();
								// 메뉴 수량 변경 메서드 호출
								modifyOrderHistory(orderHistory, menu, Integer.valueOf(cnt));
								continue;
							}
							// 주문 종료 ==> for-loop break;
							else if (isContinue == 3) {
								break order;
							}
							// 입력 오류 예외처리
							else {
								System.out.println("※입력 오류※\n>>> 다시 확인해주세요.");
								continue;
							}
						}
						System.out.println("\n☆★☆★☆★☆★주 문☆★☆★☆★☆★");
						// 메뉴 입력
						System.out.print("메뉴 >> ");
						menuName = sc.nextLine();
						// 입력한 메뉴의 가격이 0 => 해당 메뉴가 없다!!
						// 0 == 존재X , 1 == 존재 O
						if (!isExist(menuName)) {
							System.out.println("※입력 오류※\n>>> 다시 확인해주세요.");
							continue;
						}
						// 수량 입력
						System.out.print("수량 >> ");
						menuCnt = sc.nextLine();
						// 주문 내역 orderHistory 저장
						init(orderHistory, menuName.trim(), Integer.valueOf(menuCnt.trim()));
					}
					// end of for-loop

					// 주문내역이 비었을 때의 오류 처리
					if (orderHistory.isEmpty()) {
						System.out.println("주문내역이 없습니다\n>>> 메인 화면으로 돌아갑니다.");
						continue;
					} // 주문 내역이 비었으면 continue로 메뉴로 복귀

					// 주문 내역에 이상이 없을 때 현재까지 주문 내역 출력
					System.out.println("============== 주문 내역 ===============");
					totalPrice = new OrderHistory().print(orderHistory);
					// 결제 여부 확인
					System.out.print("결제 하시겠습니까?(y/n) >> ");
					select = check(sc.nextLine());
					// 결제 여부가 y일 때의 if문 시작
					if (select == 1) {
						// Controller로 주문 내역 저장 요청
						new TotalSalesController().saveOrderHistory(orderHistory, totalPrice);
						// 영수증 출력 여부 확인
						System.out.print("영수증을 출력하시겠습니까?(y/n) >>");
						if (check(sc.nextLine()) == 1) // 영수증을 출력 하면
							new PrintBill().print(orderHistory);
					} // 결제 여부가 y일 때의 if문 종료
						// 결제 여부가 n일 대의 if문 시작
					else if (select == 2) {
						System.out.println("결제를 취소 하셨습니다. \n>>>  메인 화면으로 돌아갑니다.");
						continue;
					} // 결제 여부가 n일 대의 if문 종료

					// 입력 오류처리 시작
					else {
						System.out.println("※입력 오류※ \n>>> 메인 화면으로 돌아갑니다");
						continue;
					} // 입력 오류처리 if문 종료

				} // 주문 여부 y의 if문 종료

				// 주문 여부가 n일 때
				else if (select == 2) {
					System.out.println("메인 화면으로 돌아갑니다");
					continue;
				}
				// 입력 오류
				else {
					System.out.println("※입력 오류※ \n>>> 메인 화면으로 돌아갑니다");
					continue;
				}
				System.out.println("이용해 주셔서 감사합니다\n좋은 하루 되세요");
			} // 메뉴화면 선택 1일때의 if문 종료
				// ===================== 주문 화면 출력 끝 =========================

			// ================== 관리자 화면 출력 시작 =============================

			else if (select == 2) {
				System.out.print("비밀번호를 입력하세요\n>>> ");
				int chance = 4;
				secure: while (true) {
					String password = sc.nextLine();
					if (password.equals("1234"))
						break secure;
					chance--;
					if (chance == 0) {
						System.out.println("※※허가되지 않은 접근※※");
						System.out.println(">>>프로그램을 종료합니다<<<");
						sc.close();
						System.exit(0);
					}
					System.out.println("틀렸습니다.");
					System.out.println("기회가 " + chance + "번 남았습니다");
				}
				adminWhile: while (true) {
					String menu = null;
					int price = 0;
					System.out.println("=============");
					System.out.println("∥ 1. 메뉴 추가 ∥");
					System.out.println("∥ 2. 가격 수정 ∥");
					System.out.println("∥ 3. 메뉴 삭제 ∥");
					System.out.println("∥ 4. 매출 현황 ∥");
					System.out.println("∥ 5. 메인 가기 ∥");
					System.out.println("∥ 6. 영업 종료 ∥");
					System.out.println("=============");
					System.out.print("입력 >> ");
					select = check(sc.nextLine());
					adminSwitch: switch (select) {
					case 1:
						Product product = new Product();
						System.out.print("추가할 메뉴이름을 입력하세요 >> ");
						product.setMenu_name((sc.nextLine()).trim());
						System.out.print("가격을 입력하세요 >> ");
						product.setPrice(Integer.parseInt((sc.nextLine().trim())));
						System.out.print("카테고리를 입력하세요 >> ");
						product.setCategory((sc.nextLine()).trim());
						productController.addProduct(product);
						System.out.println(product + "가 추가되었습니다.");
						break adminSwitch;
					case 2:
						System.out.print("수정할 메뉴를 입력하세요 >> ");
						menu = sc.nextLine();
						System.out.print("가격을 입력하세요 >> ");
						price = Integer.parseInt((sc.nextLine()).trim());

						System.out.println(menu + "의 가격 : " + productController.getProductPrice(menu) + "원이 ==> "
								+ price + "원으로 변경 되었습니다.");
						
						productController.updateProduct(menu.trim(), price);

						break adminSwitch;
					case 3:
						System.out.print("삭제할 메뉴를 입력하세요 >> ");
						menu = sc.nextLine();

						productController.deleteProduct(menu.trim());
						break adminSwitch;
					case 4:
						System.out.println("================");
						System.out.println("∥ 1. 전체 매출 현황 ∥");
						System.out.println("∥ 2. 일일 매출 현황 ∥");
						System.out.println("================");
						System.out.print("입력 >> ");
						select = check(sc.nextLine());
						if (select == 1) {
							new PrintTotalSales().printAllDaySales();
						} else if (select == 2) {
							String day = null;
							System.out.println("확인 하실 날을 입력해주세요 (ex, yyyy-mm-dd)");
							System.out.print("입력 >> ");
							day = sc.nextLine();
							new PrintTotalSales().printOneDaySales(day);
						} else {
							System.out.println("※※입력 오류※※");
						}
						break adminSwitch;
					case 5:
						break adminWhile;
					case 6:
						break mainWhile;
					}
					System.out.println("=============");
					System.out.println("∥ 1. 계속 하기 ∥");
					System.out.println("∥ 2. 메뉴 가기 ∥");
					System.out.println("=============");
					System.out.print("입력 >> ");
					select = check(sc.nextLine());
					if (select == 1)
						;
					else
						break adminWhile;
				}

			}
			// ===================== 관리자 화면 출력 끝 ==============================
			else {
				System.out.println("다시 입력해주세요");
			}
		}
		// end of mainWhile
		// cafe 프로그램 종료
		System.out.println("종료");

		sc.close();

	}

	// 로고 출력 메서드
	private static void LogoPrint() {
		String[] logo = {
				"\n==============================================================================================================\n"
						+ "==============================================================================================================",
				"\t||    ||     //\\\\   ||||||||||   ||||||			  ||||||     //\\\\     ||||||||  ||||||||",
				"\t||    ||    //  \\\\      ||	 ||                     ||          //  \\\\    ||        ||      ",
				"\t||||||||   ||    ||     ||       ||||||    		||         ///||\\\\\\   ||||||||  ||||||||",
				"\t||    ||    \\\\  //      ||       ||  ||			||        //      \\\\  ||        ||      ",
				"\t||    ||     \\\\//       ||       ||||||			  |||||| //        \\\\ ||        ||||||||",
				"==============================================================================================================\n"
						+ "==============================================================================================================" };
		for (String str : logo) {
			System.out.println(str);
			try { // Thread로 출력 속도 조절
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		return;
	}

	// 주문 내역 저장하는 메서드
	private static void init(HashMap<String, Integer> orderHistory, String menuName, Integer menuCnt) {
		if (orderHistory.containsKey(menuName)) // 중복 입력시 재정의 되는 것을 방지하기 위한 if문
			orderHistory.replace(menuName, orderHistory.get(menuName) + Integer.valueOf(menuCnt));
		else // 중복 입력 아니면 삽입
			orderHistory.put(menuName, Integer.valueOf(menuCnt));
	}

	private static int check(String str) { // 자주 사용되는 선택 메서드로 만듦
		str = str.trim();
		if (str.equals("y") || str.equals("Y") || str.equals("1"))
			return 1;
		else if (str.equals("n") || str.equals("N") || str.equals("2"))
			return 2;
		else if (str.equals("3"))
			return 3;
		else if (str.equals("4"))
			return 4;		
		else if (str.equals("5"))
			return 5;
		
		return 6;
	}

	// 주문 내역 수정 메서드
	private static void modifyOrderHistory(HashMap<String, Integer> orderHistory, String menuName, Integer cnt) {
		menuName = menuName.trim(); // .trim()으로 앞뒤 공백 젝
		orderHistory.replace(menuName, orderHistory.get(menuName) + cnt); // 값 수정
		if (orderHistory.get(menuName) <= 0) { // 0보다 작거나 같다 ? == 없다
			orderHistory.remove(menuName); // 0보다 작은 key 제거
		}
	}

	// 제품 이름 존재 여부 확인
	private static boolean isExist(String MenuName) {
		// price의 default값은 0 ==> return값이 0이면 해당 product는 존재 하지 않는다
		// 0이면 존재 X / 1이면 존재 O
		return new ProductController().getProductPrice(MenuName) != 0;
	}

}
