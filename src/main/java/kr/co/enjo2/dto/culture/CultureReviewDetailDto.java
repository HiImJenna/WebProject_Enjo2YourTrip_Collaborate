package kr.co.enjo2.dto.culture;

public class CultureReviewDetailDto {
	
	private int cmNum = 0;
	private int placeNum = 0;
	private String cm = "";
	private String time = "";
	private String nickName = "";
	private String profile = "";
	
	public CultureReviewDetailDto() {}
	
	public CultureReviewDetailDto(int cmNum, int placeNum, String cm, String time, String nickName, String profile) {
		super();
		this.cmNum = cmNum;
		this.placeNum = placeNum;
		this.cm = cm;
		this.time = time;
		this.nickName = nickName;
		this.profile = profile;
	}

	
	public int getCmNum() {
		return cmNum;
	}

	public void setCmNum(int cmNum) {
		this.cmNum = cmNum;
	}

	public int getPlaceNum() {
		return placeNum;
	}

	public void setPlaceNum(int placeNum) {
		this.placeNum = placeNum;
	}

	public String getCm() {
		return cm;
	}

	public void setCm(String cm) {
		this.cm = cm;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	@Override
	public String toString() {
		return "CultureReviewDetailDto [cmNum=" + cmNum + ", placeNum=" + placeNum + ", cm=" + cm + ", time=" + time
				+ ", nickName=" + nickName + ", profile=" + profile + "]";
	}
    
	

}
