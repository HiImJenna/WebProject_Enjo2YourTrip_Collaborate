package kr.co.enjo2.dto.culture;

public class MeetJoinDto {
	private int meNo;
	private String memId;
	private int mbNo;
	
	public MeetJoinDto() {}
	
	public MeetJoinDto(int meNo, String memId, int mbNo) {
		super();
		this.meNo = meNo;
		this.memId = memId;
		this.mbNo = mbNo;
	}

	public int getMeNo() {
		return meNo;
	}

	public void setMeNo(int meNo) {
		this.meNo = meNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getMbNo() {
		return mbNo;
	}

	public void setMbNo(int mbNo) {
		this.mbNo = mbNo;
	}

	@Override
	public String toString() {
		return "MeetJoinDto [meNo=" + meNo + ", memId=" + memId + ", mbNo=" + mbNo + "]";
	}
	
}
