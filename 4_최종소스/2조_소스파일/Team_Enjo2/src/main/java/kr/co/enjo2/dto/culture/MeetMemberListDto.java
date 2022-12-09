package kr.co.enjo2.dto.culture;

public class MeetMemberListDto {
   private int mbNo;
   private String memNic;
   private String memPro;

   public MeetMemberListDto() {};
   
	public MeetMemberListDto(int mbNo, String memNic, String memPro) {
		super();
		this.mbNo = mbNo;
		this.memNic = memNic;
		this.memPro = memPro;
	}
   
    public int getMbNo() {
		return mbNo;
	}

	public void setMbNo(int mbNo) {
		this.mbNo = mbNo;
	}

	public String getMemNic() {
		return memNic;
	}

	public void setMemNic(String memNic) {
		this.memNic = memNic;
	}

	public String getMemPro() {
		return memPro;
	}

	public void setMemPro(String memPro) {
		this.memPro = memPro;
	}

	@Override
	public String toString() {
		return "[mbNo=" + mbNo + ", memNic=" + memNic + ", memPro=" + memPro + "]";
	}
   
}
