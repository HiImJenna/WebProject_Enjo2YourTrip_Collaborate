package kr.co.enjo2.dto.member;

public class MemberDto {
	private String id;
	private String nickName;
	private String password;
	private String email;
	// enum 고려, user or admin
	private String memberType;
	
	public MemberDto() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", nickName=" + nickName + ", password=" + password + ", email=" + email
				+ ", memberType=" + memberType + "]";
	}
}
