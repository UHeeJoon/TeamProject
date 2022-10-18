package view;

public class PrintBill implements PrintView {
	private AdminInfo adminInfo = new AdminInfo();
	@Override
	public void print() {
		System.out.println(adminInfo);
	};
	
}
