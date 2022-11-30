package kr.co.enjo2.dto.restaurant;

public class JjimDto {
private int j_no;
private String mem_id;
private String j_store_nm;
private String j_addr;
public int getJ_no() {
	return j_no;
}
public void setJ_no(int j_no) {
	this.j_no = j_no;
}
public String getMem_id() {
	return mem_id;
}
public void setMem_id(String mem_id) {
	this.mem_id = mem_id;
}
public String getJ_store_nm() {
	return j_store_nm;
}
public void setJ_store_nm(String j_store_nm) {
	this.j_store_nm = j_store_nm;
}
public String getJ_addr() {
	return j_addr;
}
public void setJ_addr(String j_addr) {
	this.j_addr = j_addr;
}
@Override
public String toString() {
	return "JjimDto [j_no=" + j_no + ", mem_id=" + mem_id + ", j_store_nm=" + j_store_nm + ", j_addr=" + j_addr + "]";
}

}
