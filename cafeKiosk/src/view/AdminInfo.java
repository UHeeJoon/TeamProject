package view;

public class AdminInfo {
   private String cafeName = "HOT6카페";                     // 점포명
   private String adminName = "김핫";                     // 대표자명
   private Long adminId = 123456789L;                     // 사업자ID
   private String address = "서울특별시 강남구 역삼동 테헤란로";         // 주소
   private String tell = "010-1234-5678";                  // 전화번호
   private String wifiPassword = "cafe1234";               // WIFI 비밀번호

   public String getCafeName() {
      return "점포명 : " + cafeName;
   }

   public String getAdminName() {
      return "대표자명 : " + adminName;
   }
   
   public String getAdminID() {
      return "사업자ID : " + adminId;
   }

   public String getAddress() {
      return "주소 : " + address;
   }

   public String getTell() {
      return "전화번호 : " + tell;
   }

   public String getWifiPassword() {
      return "WIFI 비밀번호 : " + wifiPassword;
   }

   @Override
   public String toString() {
      return "AdminInfo [cafeName=" + cafeName + ", adminID=" + adminId + ", adress=" + address + ", tell=" + tell
            + ", adminName=" + adminName + ", wifiPassword=" + wifiPassword + "]";
   }

}