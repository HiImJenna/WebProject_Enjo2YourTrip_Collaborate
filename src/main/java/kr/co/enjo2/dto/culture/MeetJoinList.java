package kr.co.enjo2.dto.culture;

public class MeetJoinList {
     /*  select b.MB_TITLE as title , b.MB_CONTENT as content, b.MB_CREATED_AT as time, j.ME_NO
		from Meet_Join j, Meet_Board b
		where j.MB_NO = b.MB_NO and j.MEM_ID = 'MEM_ID1';*/
	
	String title = "";
	String content = "";
	String time = "";
	int meNo = 0; /* 모임 참여 번호 */
	
	public MeetJoinList() {}
 	
	public MeetJoinList(String title, String content, String time, int meNo) {
		super();
		this.title = title;
		this.content = content;
		this.time = time;
		this.meNo = meNo;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getMeNo() {
		return meNo;
	}

	public void setMeNo(int meNo) {
		this.meNo = meNo;
	}

	@Override
	public String toString() {
		return "MeetJoinList [title=" + title + ", content=" + content + ", time=" + time + ", meNo=" + meNo + "]";
	}
	
}
