package kr.co.enjo2.dto.restaurant;

// 즐겨찾기 맛집-회원 
public class FavoriteDto {
	private int memberNo;
	private int restaurantNo;
	
	public FavoriteDto() {}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(int restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	@Override
	public String toString() {
		return "FavoriteDto [memberNo=" + memberNo + ", restaurantNo=" + restaurantNo + "]";
	}
}
