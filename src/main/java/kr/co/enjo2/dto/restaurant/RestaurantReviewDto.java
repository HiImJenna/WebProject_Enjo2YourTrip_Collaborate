package kr.co.enjo2.dto.restaurant;

public class RestaurantReviewDto {
	private int restaurantReviewNo;
	private String memberId;
	private String content;
	private String createdAt;
	//private LocalDateTime createdAt;
	public RestaurantReviewDto(int restaurantReviewNo, String memberId, String content, String createdAt) {
		super();
		this.restaurantReviewNo = restaurantReviewNo;
		this.memberId = memberId;
		this.content = content;
		this.createdAt = createdAt;
	}
	public int getRestaurantReviewNo() {
		return restaurantReviewNo;
	}
	public void setRestaurantReviewNo(int restaurantReviewNo) {
		this.restaurantReviewNo = restaurantReviewNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
		return "RestaurantReviewDto [restaurantReviewNo=" + restaurantReviewNo + ", memberId=" + memberId + ", content="
				+ content + ", createdAt=" + createdAt + "]";
	}
	
}
