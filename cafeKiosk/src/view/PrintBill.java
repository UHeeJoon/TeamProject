package view;

import java.util.HashMap;

public class PrintBill {
   private AdminInfo adminInfo = new AdminInfo();
   
   
   public void print(HashMap<String, Integer> orderHistory) {
      System.out.println("=============== 영수증 ===============");
      System.out.println(adminInfo.getCafeName()); 
      System.out.println(adminInfo.getAdminName()); 
      System.out.println(adminInfo.getAdminID()); 
      System.out.println(adminInfo.getAddress()); 
      System.out.println(adminInfo.getTell()); 
      System.out.println(adminInfo.getWifiPassword()); 
      System.out.println("====================================");
      new OrderHistory().print(orderHistory);      
   };
   
}