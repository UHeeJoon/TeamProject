package view;

public class AdminInfo {
   private final String cafeName = "HOT6카페";                     // 점포명
   private final String adminName = "김핫";                     // 대표자명
   private final Long adminId = 123456789L;                     // 사업자ID
   private final String address = "서울특별시 강남구 역삼동 테헤란로";         // 주소
   private final String tell = "010-1234-5678";                  // 전화번호
   private final String wifiName = "HOT6Cafe";
   private final String wifiPassword = "cafe1234";               // WIFI 비밀번호

   @Override
   public String toString() {
      return "점   포 : " + cafeName 
    		  + "\n사업자ID : " + adminId 
    		  + "\n주   소 : "+ address 
    		  + "\n전화번호 : "  + tell
    		  + "\n대표자명 : " + adminName 
    		  + "\nWIFI 이름 : " + wifiName  
    		  + "\nWIFI 비밀번호 : " + wifiPassword;
   }

}