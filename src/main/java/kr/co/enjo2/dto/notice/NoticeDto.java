package kr.co.enjo2.dto.notice;

public class NoticeDto {
	private int noticeNo;
	private String memberId;
	private String title;
	private String content;
	private String createdAt;
	public NoticeDto() {}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	@Override
	public String toString() {
		return "NoticeDto [noticeNo=" + noticeNo + ", memberId=" + memberId + ", title=" + title + ", content="
				+ content + ", createdAt=" + createdAt + "]";
	}
}
