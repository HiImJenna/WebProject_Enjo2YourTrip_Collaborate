package kr.co.enjo2.dto.flight;

public class ChartDto {
	private String infoBoaringDate;
	private String rsvGender;
	private String infoAirNm;
	private int noticeNo;
	private String notiTitle;
	private int notiCount;
	
	private int count;
	
	public ChartDto() {
	}

	public String getInfoBoaringDate() {
		return infoBoaringDate;
	}

	public void setInfoBoaringDate(String infoBoaringDate) {
		this.infoBoaringDate = infoBoaringDate;
	}

	public String getRsvGender() {
		return rsvGender;
	}

	public void setRsvGender(String rsvGender) {
		this.rsvGender = rsvGender;
	}

	public String getInfoAirNm() {
		return infoAirNm;
	}

	public void setInfoAirNm(String infoAirNm) {
		this.infoAirNm = infoAirNm;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNotiTitle() {
		return notiTitle;
	}

	public void setNotiTitle(String notiTitle) {
		this.notiTitle = notiTitle;
	}

	public int getNotiCount() {
		return notiCount;
	}

	public void setNotiCount(int notiCount) {
		this.notiCount = notiCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ChartDto [infoBoaringDate=" + infoBoaringDate + ", rsvGender=" + rsvGender + ", infoAirNm=" + infoAirNm
				+ ", noticeNo=" + noticeNo + ", notiTitle=" + notiTitle + ", notiCount=" + notiCount + ", count="
				+ count + "]";
	}

	

	
}
