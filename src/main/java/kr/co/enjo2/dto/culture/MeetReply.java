package kr.co.enjo2.dto.culture;

public class MeetReply {
	private int mrNo;
	private String mrComment;
	private String mrCreatedAt;
	private int mbNo;
	private String memid;
	private String memNic;
	private String memPro;
	
	public MeetReply() {}

	public MeetReply(int mrNo, String mrComment, String mrCreatedAt, int mbNo, String memid, String memNic,
			String memPro) {
		super();
		this.mrNo = mrNo;
		this.mrComment = mrComment;
		this.mrCreatedAt = mrCreatedAt;
		this.mbNo = mbNo;
		this.memid = memid;
		this.memNic = memNic;
		this.memPro = memPro;
	}

	public int getMrNo() {
		return mrNo;
	}

	public void setMrNo(int mrNo) {
		this.mrNo = mrNo;
	}

	public String getMrComment() {
		return mrComment;
	}

	public void setMrComment(String mrComment) {
		this.mrComment = mrComment;
	}

	public String getMrCreatedAt() {
		return mrCreatedAt;
	}

	public void setMrCreatedAt(String mrCreatedAt) {
		this.mrCreatedAt = mrCreatedAt;
	}

	public int getMbNo() {
		return mbNo;
	}

	public void setMbNo(int mbNo) {
		this.mbNo = mbNo;
	}

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
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
		return "MeetReply [mrNo=" + mrNo + ", mrComment=" + mrComment + ", mrCreatedAt=" + mrCreatedAt + ", mbNo="
				+ mbNo + ", memid=" + memid + ", memNic=" + memNic + ", memPro=" + memPro + "]";
	}
	
}
