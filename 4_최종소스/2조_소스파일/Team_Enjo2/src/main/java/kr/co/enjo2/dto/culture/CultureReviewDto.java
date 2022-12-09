package kr.co.enjo2.dto.culture;

public class CultureReviewDto {
  private int culNo;
  private String culGu;
  
	public CultureReviewDto(int culNo, String culGu) {
		super();
		this.culNo = culNo;
		this.culGu = culGu;
	}
	
	public CultureReviewDto() {
		
	}

	public int getCulNo() {
		return culNo;
	}

	public void setCulNo(int culNo) {
		this.culNo = culNo;
	}

	public String getCulGu() {
		return culGu;
	}

	public void setCulGu(String culGu) {
		this.culGu = culGu;
	}

	@Override
	public String toString() {
		return "CultureReviewDto [culNo=" + culNo + ", culGu=" + culGu + "]";
	}

		
}
