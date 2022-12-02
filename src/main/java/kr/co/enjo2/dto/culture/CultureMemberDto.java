package kr.co.enjo2.dto.culture;

public class CultureMemberDto {
   private String MEM_ID;
   private String MEM_NIC;
   private String MEM_PWD;
   private String MEM_EMAIL;
   private String MEM_TYPE;
   private String MEM_PRO;
   
   public CultureMemberDto() {}
   
	public CultureMemberDto(String mEM_ID, String mEM_NIC, String mEM_PWD, String mEM_EMAIL, String mEM_TYPE,
			String mEM_PRO) {
		super();
		MEM_ID = mEM_ID;
		MEM_NIC = mEM_NIC;
		MEM_PWD = mEM_PWD;
		MEM_EMAIL = mEM_EMAIL;
		MEM_TYPE = mEM_TYPE;
		MEM_PRO = mEM_PRO;
	}

	public String getMEM_ID() {
		return MEM_ID;
	}

	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}

	public String getMEM_NIC() {
		return MEM_NIC;
	}

	public void setMEM_NIC(String mEM_NIC) {
		MEM_NIC = mEM_NIC;
	}

	public String getMEM_PWD() {
		return MEM_PWD;
	}

	public void setMEM_PWD(String mEM_PWD) {
		MEM_PWD = mEM_PWD;
	}

	public String getMEM_EMAIL() {
		return MEM_EMAIL;
	}

	public void setMEM_EMAIL(String mEM_EMAIL) {
		MEM_EMAIL = mEM_EMAIL;
	}

	public String getMEM_TYPE() {
		return MEM_TYPE;
	}

	public void setMEM_TYPE(String mEM_TYPE) {
		MEM_TYPE = mEM_TYPE;
	}

	public String getMEM_PRO() {
		return MEM_PRO;
	}

	public void setMEM_PRO(String mEM_PRO) {
		MEM_PRO = mEM_PRO;
	}

	@Override
	public String toString() {
		return "CultureMemberDto [MEM_ID=" + MEM_ID + ", MEM_NIC=" + MEM_NIC + ", MEM_PWD=" + MEM_PWD + ", MEM_EMAIL="
				+ MEM_EMAIL + ", MEM_TYPE=" + MEM_TYPE + ", MEM_PRO=" + MEM_PRO + "]";
	}
   
   
   
}
