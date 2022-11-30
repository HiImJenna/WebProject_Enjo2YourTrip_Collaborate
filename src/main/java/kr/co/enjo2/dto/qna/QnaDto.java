package kr.co.enjo2.dto.qna;

public class QnaDto {
	private int qnaNo;
	private String memberId;
	private Integer qnaRef;
	private String title;
	private String content;
	private String createdAt;
	private int count;
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Integer getQnaRef() {
		return qnaRef;
	}
	public void setQnaRef(Integer qnaRef) {
		this.qnaRef = qnaRef;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "QnaDto [qnaNo=" + qnaNo + ", memberId=" + memberId + ", qnaRef=" + qnaRef + ", title=" + title
				+ ", content=" + content + ", createdAt=" + createdAt + ", count=" + count + "]";
	}
}
