package view;

public class AdminInfo {
	private String cafeName = "카페";
	private Long adminID = 123456789L;
	private String adress = "서울특별시 강남구 역삼동 테헤란로";
	private String tell = "010-1234-5678";

	private String adminName = "홍길동";

	private String wifiPassword = "cafe1234";

	public String getCafeName() {
		return cafeName;
	}

	public Long getAdminID() {
		return adminID;
	}

	public String getAdress() {
		return adress;
	}

	public String getTell() {
		return tell;
	}

	public String getAdminName() {
		return adminName;
	}

	public String getWifiPassword() {
		return wifiPassword;
	}

	@Override
	public String toString() {
		return "AdminInfo [cafeName=" + cafeName + ", adminID=" + adminID + ", adress=" + adress + ", tell=" + tell
				+ ", adminName=" + adminName + ", wifiPassword=" + wifiPassword + "]";
	}

}
