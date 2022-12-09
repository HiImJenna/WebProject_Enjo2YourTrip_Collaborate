package kr.co.enjo2.dto.culture;

import java.util.List;

public class MeetBoardDto {
	private int mbNo;
	private String mbTitle;
	private String mbContent;
	private String mbCreatedAt;
	private String memId;
	private int comNum;
	private String memNic;
	private String memPro;
	private List<MeetMemberListDto> meetMemberList;

	public MeetBoardDto() {}
	
	public MeetBoardDto(int mbNo, String mbTitle, String mbContent, String mbCreatedAt, String memId, int comNum,
			String memNic, String memPro, List<MeetMemberListDto> meetMemberList) {
		super();
		this.mbNo = mbNo;
		this.mbTitle = mbTitle;
		this.mbContent = mbContent;
		this.mbCreatedAt = mbCreatedAt;
		this.memId = memId;
		this.comNum = comNum;
		this.memNic = memNic;
		this.memPro = memPro;
		this.meetMemberList = meetMemberList;
	}
//	public MeetBoardDto(int mbNo, String mbTitle, String mbContent, String mbCreatedAt, String memId, int comNum,
//			List<MeetMemberListDto> meetMemberList) {
//		super();
//		this.mbNo = mbNo;
//		this.mbTitle = mbTitle;
//		this.mbContent = mbContent;
//		this.mbCreatedAt = mbCreatedAt;
//		this.memId = memId;
//		this.comNum = comNum;
//		this.meetMemberList = meetMemberList;
//	}

	public List<MeetMemberListDto> getMeetMemberList() {
		return meetMemberList;
	}

	public void setMeetMemberList(List<MeetMemberListDto> meetMemberList) {
		this.meetMemberList = meetMemberList;
	}


	public int getMbNo() {
		return mbNo;
	}

	public void setMbNo(int mbNo) {
		this.mbNo = mbNo;
	}

	public String getMbTitle() {
		return mbTitle;
	}

	public void setMbTitle(String mbTitle) {
		this.mbTitle = mbTitle;
	}

	public String getMbContent() {
		return mbContent;
	}

	public void setMbContent(String mbContent) {
		this.mbContent = mbContent;
	}

	public String getMbCreatedAt() {
		return mbCreatedAt;
	}

	public void setMbCreatedAt(String mbCreatedAt) {
		this.mbCreatedAt = mbCreatedAt;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getComNum() {
		return comNum;
	}

	public void setComNum(int comNum) {
		this.comNum = comNum;
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
		return "MeetBoardDto [mbNo=" + mbNo + ", mbTitle=" + mbTitle + ", mbContent=" + mbContent + ", mbCreatedAt="
				+ mbCreatedAt + ", memId=" + memId + ", comNum=" + comNum + ", memNic=" + memNic + ", memPro=" + memPro
				+ ", meetMemberList=" + meetMemberList + "]";
	}

//	
//	@Override
//	public String toString() {
//		return "MeetBoardDto [mbNo=" + mbNo + ", mbTitle=" + mbTitle + ", mbContent=" + mbContent + ", mbCreatedAt="
//				+ mbCreatedAt + ", memId=" + memId + ", comNum=" + comNum + ", meetMemberList=" + meetMemberList + "]";
//	}
		
}
