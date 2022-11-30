package kr.co.enjo2.dto.restaurant;

// 즐겨찾기 맛집-회원 
public class Rest_ReviewDto {
private int rriview_no;
private String mem_id;
private String rreview_content;
private String rrieview_created_at;
public int getRriview_no() {
	return rriview_no;
}
public void setRriview_no(int rriview_no) {
	this.rriview_no = rriview_no;
}
public String getMem_id() {
	return mem_id;
}
public void setMem_id(String mem_id) {
	this.mem_id = mem_id;
}
public String getRreview_content() {
	return rreview_content;
}
public void setRreview_content(String rreview_content) {
	this.rreview_content = rreview_content;
}
public String getRrieview_created_at() {
	return rrieview_created_at;
}
public void setRrieview_created_at(String rrieview_created_at) {
	this.rrieview_created_at = rrieview_created_at;
}
@Override
public String toString() {
	return "Rest_ReviewDto [rriview_no=" + rriview_no + ", mem_id=" + mem_id + ", rreview_content=" + rreview_content
			+ ", rrieview_created_at=" + rrieview_created_at + "]";
}



}
