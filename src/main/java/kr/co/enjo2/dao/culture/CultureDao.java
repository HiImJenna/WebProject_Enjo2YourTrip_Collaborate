package kr.co.enjo2.dao.culture;

import java.awt.geom.RectangularShape;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.enjo2.dto.culture.CultureMemberDto;
import kr.co.enjo2.dto.culture.CultureReviewDetailDto;
import kr.co.enjo2.dto.culture.CultureReviewDto;
import kr.co.enjo2.dto.culture.MeetBoardDto;
import kr.co.enjo2.dto.culture.MeetJoinDto;
import kr.co.enjo2.dto.culture.MeetJoinList;
import kr.co.enjo2.dto.culture.MeetMemberListDto;
import kr.co.enjo2.dto.culture.MeetReply;
import kr.co.enjo2.dto.member.MemberDto;

/*
	문화 DB 데이터 로직 작성
*/
public class CultureDao {
	
	DataSource ds = null;

	public CultureDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}
	
	
	/* select MEM_ID, MEM_NIC, MEM_PWD, MEM_EMAIL, MEM_TYPE, MEM_PRO
		from Member
		where MEM_ID = 'MEM_ID1'; */
	
	public CultureMemberDto searchMember(String MEM_ID) {
		
		  Connection conn = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  CultureMemberDto member = null;
	      
		try {
		  conn = ds.getConnection();  
		  String sql = "select MEM_ID, MEM_NIC, MEM_PRO " +
				  	   "from Member " +
				       "where MEM_ID = ?";
		  
		  pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, MEM_ID);

	      rs = pstmt.executeQuery();
	      
	      while (rs.next()) {
	    	  member = new CultureMemberDto(); 
	    	  
	    	  member.setMEM_ID(rs.getString("MEM_ID"));
	    	  member.setMEM_NIC(rs.getString("MEM_NIC"));
	    	  member.setMEM_PRO(rs.getString("MEM_PRO"));  
	      }
	      
	      pstmt.close();
	      conn.close();	
	      rs.close();
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		} 
		return member;
   }
	
	/* public List<MeetBoardDto> SearchGathering() {
	     Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     List<MeetBoardDto> list = null;
	      
		try {
		  conn = ds.getConnection();  
		  String sql = "select MB_NO, MB_TITLE, MB_CONTENT, TO_CHAR(MB_CREATED_AT, 'YYYY-MM-DD HH24:MI') as MB_CREATED_AT, MEM_ID " + 
		               "from Meet_Board";
		  
		  pstmt = conn.prepareStatement(sql);      
	      rs = pstmt.executeQuery();
	      list = new ArrayList<MeetBoardDto>();
	      
	      while (rs.next()) {
	    	  MeetBoardDto gathering = new MeetBoardDto();
	    	   
	    	  gathering.setMbNo(rs.getInt("MB_NO"));
	    	  gathering.setMbTitle(rs.getString("MB_TITLE"));
	    	  gathering.setMbContent(rs.getString("MB_CONTENT"));
	    	  gathering.setMbCreatedAt(rs.getString("MB_CREATED_AT"));
	    	  gathering.setMemId(rs.getString("MEM_ID"));
	    	  gathering.setComNum(SearchGatheringCommentNumber(rs.getInt("MB_NO")));
	    	  gathering.setMeetMemberList(findJoinMember(rs.getInt("MB_NO")));
	    	  
	    	  System.out.println("gathering : " + gathering);
	    	  
	    	  list.add(gathering); 
	      }
	      
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		} finally {
		  try { 
			 pstmt.close();
	         rs.close();
	         conn.close();			  
		  } catch(Exception e2) {
			 System.out.println(e2.getMessage());
		  }
		}	
		return list;
  } */
	
	
	
	
	public int insertCulturePlace(int culNo, String cul_gu) {
		 int result = 0;
	     Connection conn = null;
	     PreparedStatement pstmt = null;
	      
		try {
		  conn = ds.getConnection();  
		  String sql = "INSERT INTO Cul_Review " +
				  	   "VALUES(?, ?)";
		  
		  pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, culNo);
	      pstmt.setString(2, cul_gu);

	      result = pstmt.executeUpdate();
	      
	      pstmt.close();
	      conn.close();	
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		}
		
		return result;
    }
	
	public JSONArray SearchCulturePlace(String culGu) {
	     Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     // List<CultureReviewDto> list = null;
	     JSONArray jsonArray = null;
	      
		try {
		  conn = ds.getConnection();  
		  String sql = "select CUL_NO, CUL_GU " +
					   "from Cul_Review " +
					   "where CUL_GU = ?";
		  
		  pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, culGu);	      
	      rs = pstmt.executeQuery();
	      // list = new ArrayList<CultureReviewDto>();
	      jsonArray = new JSONArray();
	      
	      while (rs.next()) {
	    	  
	    	  HashMap<String, Integer> hashMap = new HashMap<>();
	    	  hashMap.put("CUL_NO", rs.getInt("CUL_NO"));
	    	  JSONObject culNo = new JSONObject(hashMap);
	    	  
	    	 // CultureReviewDto culturePlace = new CultureReviewDto(rs.getInt("CUL_NO"), rs.getString("CUL_GU"));
	    	 // list.add(culturePlace);
	    	  jsonArray.add(culNo);	 
	      }
	      
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		} finally {
		  try { 
			 pstmt.close();
	         rs.close();
	         conn.close();			  
		  } catch(Exception e2) {
			 System.out.println(e2.getMessage());
		  }
		}	
		return jsonArray;
   }
	
   public JSONArray SearchCulturePlaceReview(int cul_no) {
	     Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     // List<CultureReviewDto> list = null;
	     JSONArray jsonArray = null;
	     
	     System.out.println("SearchCulturePlaceReview 메서드 입장");
	      
		try {
		  conn = ds.getConnection();  
		  String sql = "select c.CUL_CO as cmNum, c.CUL_COMMENT as cm , TO_CHAR(c.CUL_CREATED_AT, 'YYYY-MM-DD HH24:MI') as time, m.MEM_NIC as nickName, m.MEM_PRO as profile , c.CUL_NO as placeNum " +
					   "from Cul_Re_Cm c, Member m " +
					   "where c.MEM_ID = m.MEM_ID and c.CUL_NO = ?";
		  
		  pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, cul_no);	      
	      rs = pstmt.executeQuery();
	      System.out.println("SearchCulturePlaceReview rs : " + rs);
	      // list = new ArrayList<CultureReviewDto>();
	      jsonArray = new JSONArray();
	      
	      while (rs.next()) {
	    	  
//	    	  HashMap<String, Integer> hashMapInt = new HashMap<>();
//	    	  hashMapInt.put("cmNum", rs.getInt("cmNum"));
//	    	  hashMapInt.put("placeNum", rs.getInt("placeNum"));
	    	  
	    	  HashMap<String, String> hashMapString = new HashMap<>();
	    	  hashMapString.put("cmNum", Integer.toString(rs.getInt("cmNum")));
	    	  hashMapString.put("placeNum", Integer.toString(rs.getInt("placeNum")));
	    	  hashMapString.put("cm", rs.getString("cm"));
	    	  hashMapString.put("time", rs.getString("time"));
	    	  hashMapString.put("nickName", rs.getString("nickName"));
	    	  hashMapString.put("time", rs.getString("time"));
	    	  hashMapString.put("profile", rs.getString("profile"));
	    	  
	    	  
	    	  // Integer.toString(from)
  	  
//	    	  JSONObject intObj = new JSONObject(hashMapInt);
	    	  JSONObject stringObj = new JSONObject(hashMapString);
	    	 
	    	  jsonArray.add(stringObj);
//	    	  jsonArray.add(intObj);
	      } 
	      
	      pstmt.close();
	      rs.close();
	      conn.close();	
	      
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		} 
		System.out.println("jsonArray : " + jsonArray);
		return jsonArray;
   }
   // CultureReviewDetail
   public List<CultureReviewDetailDto> SearchCulturePlaceReviewObj(int cul_no) {
	     Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     List<CultureReviewDetailDto> list = null;
	     
	     System.out.println("SearchCulturePlaceReviewObj 메서드 입장");
	      
		try {
		  conn = ds.getConnection();  
		  String sql = "select c.CUL_CO as cmNum, c.CUL_COMMENT as cm , TO_CHAR(c.CUL_CREATED_AT, 'YYYY-MM-DD HH24:MI') as time, m.MEM_NIC as nickName, m.MEM_PRO as profile , c.CUL_NO as placeNum " +
					   "from Cul_Re_Cm c, Member m " +
					   "where c.MEM_ID = m.MEM_ID and c.CUL_NO = ?";
		  
		  pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, cul_no);	      
	      rs = pstmt.executeQuery();
	      System.out.println("SearchCulturePlaceReview rs : " + rs);
	      
	      list = new ArrayList<CultureReviewDetailDto>();
	      
	      while (rs.next()) {
	    	  CultureReviewDetailDto review = new CultureReviewDetailDto();
	    	  
	    	  review.setCmNum(rs.getInt("cmNum"));
	    	  review.setPlaceNum(rs.getInt("placeNum"));
	    	  review.setCm(rs.getString("cm"));
	    	  review.setTime(rs.getString("time"));
	    	  review.setNickName(rs.getString("nickName"));
	    	  review.setProfile(rs.getString("profile"));
	    	  
	    	  System.out.println("review : " + review);
	    	  
	    	  list.add(review);

	      } 
	      
	      pstmt.close();
	      rs.close();
	      conn.close();	
	      
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		} 
		System.out.println("SearchCulturePlaceReviewObj list : " + list);
		return list;
 }
	
   public boolean exist(int culNo) {
	     Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     boolean result = false;
	      
		try {
		  conn = ds.getConnection();  
		  String sql = "select CUL_NO, CUL_GU " +
					   "from Cul_Review " +
					   "where CUL_NO = ?";
		  
		  pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, culNo);	      
	      rs = pstmt.executeQuery();
	      
	      while(rs.next()) {
	    	  result = true;
	      }

		} catch (Exception e) {
		  System.out.println(e.getMessage());
		} finally {
		  try { 
			 pstmt.close();
	         rs.close();
	         conn.close();			  
		  } catch(Exception e2) {
			 System.out.println(e2.getMessage());
		  }
		}	
		return result;
  }
   
  public int insertMeetBoard(MeetBoardDto board) {
	  
	  int result = 0;
	  Connection conn = null;
	  PreparedStatement pstmt = null;
	  
	  try {
		  conn = ds.getConnection();  
		  String sql = "insert into Meet_Board(MB_NO, MB_TITLE, MB_CONTENT, MB_CREATED_AT, MEM_ID)" +
				  	   "values(MB_NO_seq.nextval, ?, ?, sysdate, ?)";
		
		  
		  pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, board.getMbTitle());   
	      pstmt.setString(2, board.getMbContent());
	      pstmt.setString(3, board.getMemId());

	      result = pstmt.executeUpdate();
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		}
		
		return result;
  }
  
  public int insertReviewComment(String comment, String memId, int culNo) {
	  
	  int result = 0;
	  Connection conn = null;
	  PreparedStatement pstmt = null;
	  
	  try {
		  conn = ds.getConnection();  
		  String sql = "INSERT INTO Cul_Re_Cm (CUL_CO, CUL_COMMENT, CUL_CREATED_AT, MEM_ID, CUL_NO) " +
				  	   "VALUES(CUL_CO_seq.nextval, ?, sysdate, ?, ?)";
		  /*INSERT INTO Cul_Re_Cm
VALUES(CUL_CO_seq.nextval, '후기 댓글 더미 데이터', sysdate, 'MEM_ID2', 2); */
		  
		  pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, comment);   
	      pstmt.setString(2, memId);
	      pstmt.setInt(3, culNo);

	      result = pstmt.executeUpdate();
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		}
		
		return result;
  }
  
//  public List<MeetBoardDto> SearchGathering() {
//	     Connection conn = null;
//	     PreparedStatement pstmt = null;
//	     ResultSet rs = null;
//	     List<MeetBoardDto> list = null;
//	      
//		try {
//		  conn = ds.getConnection();  
//		  String sql = "select MB_NO, MB_TITLE, MB_CONTENT, TO_CHAR(MB_CREATED_AT, 'YYYY-MM-DD HH24:MI') as MB_CREATED_AT, MEM_ID " + 
//		               "from Meet_Board";
//		  
//		  pstmt = conn.prepareStatement(sql);      
//	      rs = pstmt.executeQuery();
//	      list = new ArrayList<MeetBoardDto>();
//	      
//	      while (rs.next()) {
//	    	  MeetBoardDto gathering = new MeetBoardDto();
//	    	   
//	    	  gathering.setMbNo(rs.getInt("MB_NO"));
//	    	  gathering.setMbTitle(rs.getString("MB_TITLE"));
//	    	  gathering.setMbContent(rs.getString("MB_CONTENT"));
//	    	  gathering.setMbCreatedAt(rs.getString("MB_CREATED_AT"));
//	    	  gathering.setMemId(rs.getString("MEM_ID"));
//	    	  gathering.setComNum(SearchGatheringCommentNumber(rs.getInt("MB_NO")));
//	    	  gathering.setMeetMemberList(findJoinMember(rs.getInt("MB_NO")));
//	    	  
//	    	  System.out.println("gathering : " + gathering);
//	    	  
//	    	  list.add(gathering); 
//	      }
//	      
//		} catch (Exception e) {
//		  System.out.println(e.getMessage());
//		} finally {
//		  try { 
//			 pstmt.close();
//	         rs.close();
//	         conn.close();			  
//		  } catch(Exception e2) {
//			 System.out.println(e2.getMessage());
//		  }
//		}	
//		return list;
//  }
  
  public List<MeetBoardDto> SearchGathering() {
	     Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     List<MeetBoardDto> list = null;
	      
		try {
		  conn = ds.getConnection();  
		  String sql = "select b.MB_NO as MB_NO, b.MB_TITLE as MB_TITLE, b.MB_CONTENT, TO_CHAR(MB_CREATED_AT, 'YYYY-MM-DD HH24:MI') as MB_CREATED_AT, b.MEM_ID as MEM_ID, m.MEM_NIC as MEM_NIC, m.MEM_PRO as MEM_PRO " + 
		               "from Meet_Board b, Member m " +
				       "where b.MEM_ID = m.MEM_ID";
		  
		  pstmt = conn.prepareStatement(sql);      
	      rs = pstmt.executeQuery();
	      list = new ArrayList<MeetBoardDto>();
	      
	      while (rs.next()) {
	    	  MeetBoardDto gathering = new MeetBoardDto();
	    	   
	    	  gathering.setMbNo(rs.getInt("MB_NO"));
	    	  gathering.setMbTitle(rs.getString("MB_TITLE"));
	    	  gathering.setMbContent(rs.getString("MB_CONTENT"));
	    	  gathering.setMbCreatedAt(rs.getString("MB_CREATED_AT"));
	    	  gathering.setMemId(rs.getString("MEM_ID"));
	    	  gathering.setMemNic(rs.getString("MEM_NIC"));
	    	  gathering.setMemPro(rs.getString("MEM_PRO"));
	    	  
	    	  gathering.setComNum(SearchGatheringCommentNumber(rs.getInt("MB_NO")));
	    	  gathering.setMeetMemberList(findJoinMember(rs.getInt("MB_NO")));
	    	  
	    	  System.out.println("gathering : " + gathering);
	    	  
	    	  list.add(gathering); 
	      }
	      
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		} finally {
		  try { 
			 pstmt.close();
	         rs.close();
	         conn.close();			  
		  } catch(Exception e2) {
			 System.out.println(e2.getMessage());
		  }
		}	
		return list;
 }
  
  
  /* 수정해야함 */
  public List<MeetJoinList> SearchJoin(String memId) {
	     Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     List<MeetJoinList> list = null;
	      
		try {
		  conn = ds.getConnection();  
		  /* select b.MB_TITLE as title , b.MB_CONTENT as content, b.MB_CREATED_AT as time, j.ME_NO
			from Meet_Join j, Meet_Board b
			where j.MB_NO = b.MB_NO and j.MEM_ID = 'MEM_ID1'; */
		  String sql = "select b.MB_TITLE as title , b.MB_CONTENT as content, b.MB_CREATED_AT as time, j.ME_NO as meNo " + 
		               "from Meet_Join j, Meet_Board b " + 
				       "where j.MB_NO = b.MB_NO and j.MEM_ID = ?";
		  
		  pstmt = conn.prepareStatement(sql);  
		  pstmt.setString(1, memId);
	      rs = pstmt.executeQuery();
	      list = new ArrayList<MeetJoinList>();
	      
	      while (rs.next()) {
	    	  MeetJoinList joinList = new MeetJoinList();
	    	  
	    	  joinList.setTitle(rs.getString("title"));
	    	  joinList.setContent(rs.getString("content"));
	    	  joinList.setTime(rs.getString("time"));
	    	  joinList.setMeNo(rs.getInt("meNo"));  
	    	  
	    	  System.out.println("joinList : " + joinList);
	    	  
	    	  list.add(joinList); 
	      }
	      
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		} finally {
		  try { 
			 pstmt.close();
	         rs.close();
	         conn.close();			  
		  } catch(Exception e2) {
			 System.out.println(e2.getMessage());
		  }
		}	
		return list;
}
  /* 수정해야함 */
  
  public MeetBoardDto SearchOneGathering(int mbNo) {
         System.out.println("SearchOneGathering 입장");
	     Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     MeetBoardDto oneGathering = null;
	      
		try {
		  conn = ds.getConnection();  
		  String sql = "select b.MB_NO as MB_NO, b.MB_TITLE as MB_TITLE, b.MB_CONTENT as MB_CONTENT, TO_CHAR(MB_CREATED_AT, 'YYYY-MM-DD HH24:MI') as MB_CREATED_AT, m.MEM_ID as MEM_ID, m.MEM_NIC as MEM_NIC, m.MEM_PRO as MEM_PRO " + 
		               "from Meet_Board b, Member m " +
				       "where b.MEM_ID = m.MEM_ID and b.MB_NO = ?";
		  
		  pstmt = conn.prepareStatement(sql);  
		  pstmt.setInt(1, mbNo);
	      rs = pstmt.executeQuery();
	      
	      if(rs.next()) { 

//	    	  oneGathering = new MeetBoardDto(rs.getInt("MB_NO"), 
//						                      rs.getString("MB_TITLE"), 
//						                      rs.getString("MB_CONTENT"),
//						                      rs.getString("MB_CREATED_AT"),
//						                      rs.getString("MEM_ID"),
//						                      SearchGatheringCommentNumber(rs.getInt("MB_NO"))
//						                      );
	    	  
	    	  oneGathering = new MeetBoardDto();
	    	  
	    	  oneGathering.setMbNo(rs.getInt("MB_NO"));
	    	  oneGathering.setMbTitle(rs.getString("MB_TITLE"));
	    	  oneGathering.setMbContent(rs.getString("MB_CONTENT"));
	    	  oneGathering.setMbCreatedAt(rs.getString("MB_CREATED_AT"));
	    	  oneGathering.setMemId(rs.getString("MEM_ID"));
	    	  oneGathering.setMemNic(rs.getString("MEM_NIC"));
	    	  oneGathering.setComNum(SearchGatheringCommentNumber(rs.getInt("MB_NO")));
	    	  oneGathering.setMeetMemberList(findJoinMember(rs.getInt("MB_NO")));
	    	  
	    	  
	    	  
	    	  System.out.println("oneGathering : " + oneGathering );
	    	  
	      }
	      
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		} finally {
		  try { 
			 pstmt.close();
	         rs.close();
	         conn.close();			  
		  } catch(Exception e2) {
			 System.out.println(e2.getMessage());
		  }
		}	
		
		System.out.println("oneGathering " + oneGathering);
		return oneGathering;
}
  
  
  public List<MeetReply> SearchGatheringComment(int mbNo) {
	     Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     ResultSet countRs = null;
	     List<MeetReply> commentList = null;
	      
		try {
		  conn = ds.getConnection();  
		  String sql = "select r.MR_NO as mr, r.MR_COMMENT as cm, to_char(MB_CREATED_AT, 'YYYY-MM-DD HH24:MI') as at, b.MB_NO as mb, m.MEM_ID as id, m.MEM_NIC as nic, m.MEM_PRO as pro " + 
		               "from Meet_Reply r, Meet_Board b, Member m " +
				       "where r.MB_NO = b.MB_NO and r.MEM_ID = m.MEM_ID and r.MB_NO = ?";
		  
		  pstmt = conn.prepareStatement(sql);   
		  pstmt.setInt(1, mbNo);
		  
	      rs = pstmt.executeQuery();
	      commentList = new ArrayList<MeetReply>();
	      System.out.println("rs : " + rs);
	   
	      while(rs.next()) {

			  
	    	  MeetReply gatheringComment = new MeetReply();
	    	  
	    	  gatheringComment.setMrNo(rs.getInt("mr"));
	    	  gatheringComment.setMrComment(rs.getString("cm"));
	    	  gatheringComment.setMrCreatedAt(rs.getString("at"));
	    	  gatheringComment.setMbNo(rs.getInt("mb"));
	    	  gatheringComment.setMemid(rs.getString("id"));
	    	  gatheringComment.setMemNic(rs.getString("nic"));
	    	  gatheringComment.setMemPro(rs.getString("pro"));
	    	  

	    	  /* 	    	  gatheringComment.setMrNo(rs.getInt("r.MR_NO"));
	    	  gatheringComment.setMrComment(rs.getString("r.MR_COMMENT"));
	    	  gatheringComment.setMrCreatedAt(rs.getString("MB_CREATED_AT"));
	    	  gatheringComment.setMbNo(rs.getInt("b.MB_NO"));
	    	  gatheringComment.setMemid(rs.getString("m.MEM_ID"));
	    	  gatheringComment.setMemNic(rs.getString("m.MEM_NIC"));
	    	  gatheringComment.setMemPro(rs.getString("m.MEM_PRO")); */
	    	  

	    	  
	    	  System.out.println("gatheringComment : " + gatheringComment);
	    	  commentList.add(gatheringComment);   
	      }

	      
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		} finally {
		  try { 
			 pstmt.close();
	         rs.close();
	         conn.close();			  
		  } catch(Exception e2) {
			 System.out.println(e2.getMessage());
		  }
		}	
		
		System.out.println("commentList : " + commentList);
		return commentList;
}
  
 
 public int SearchGatheringCommentNumber(int mbNo) {
	     Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     int result = 0;
	      
		try {
		  conn = ds.getConnection();  
		  String sql = "select count(*) " + 
		               "from Meet_Reply r, Meet_Board b, Member m " +
				       "where r.MB_NO = b.MB_NO and r.MEM_ID = m.MEM_ID and r.MB_NO = ?";
		  
		  pstmt = conn.prepareStatement(sql);   
		  pstmt.setInt(1, mbNo);
		  
		  rs = pstmt.executeQuery();
		  
		  if(rs.next()) {
			  result = rs.getInt(1);  
	      }
		  
		  
	      
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		} finally {
		  try { 
			 pstmt.close();
	         conn.close();			  
		  } catch(Exception e2) {
			 System.out.println(e2.getMessage());
		  }
		}	
		return result;
}
 
public MeetReply findPersonInformation(String memid) {
     Connection conn = null;
     PreparedStatement pstmt = null;
     ResultSet rs = null;
     MeetReply personInformation = null;
      
     System.out.println("mbNo : " + memid);
     
	try {
	  conn = ds.getConnection();  
	  String sql = "select MEM_ID, MEM_NIC, MEM_PRO " + 
	               "from Member " +
			       "where MEM_ID = ?";
	  
	  pstmt = conn.prepareStatement(sql);   
	  pstmt.setString(1, memid);
	  
	  rs = pstmt.executeQuery();
	  
	  
	  if(rs.next()) {
		  personInformation = new MeetReply();
		  personInformation.setMemid(rs.getString("MEM_ID"));
		  personInformation.setMemNic(rs.getString("MEM_NIC"));
		  personInformation.setMemPro(rs.getString("MEM_PRO"));  
      }
	} catch (Exception e) {
	  System.out.println(e.getMessage());
	} finally {
	  try { 
		 pstmt.close();
         conn.close();			  
	  } catch(Exception e2) {
		 System.out.println(e2.getMessage());
	  }
	}	
    System.out.println("personInformation : " + personInformation);
	return personInformation;
}

public int insertMeetReply(MeetReply reply) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    int result = 0;
      
	try {
	  conn = ds.getConnection();  
	  String sql = "INSERT INTO Meet_Reply(MR_NO, MR_COMMENT, MR_CREATED_AT, MB_NO, MEM_ID) " + 
	               "VALUES(MR_NO_seq.nextval, ?, sysdate, ?, ?)";
	 
	  
	  pstmt = conn.prepareStatement(sql);   
	  pstmt.setString(1, reply.getMrComment()); // 댓글 
	  pstmt.setInt(2, reply.getMbNo()); // 모임 게시글 번호 
	  pstmt.setString(3, reply.getMemid()); // 멤버 아이디 
	  
	  
	  result = pstmt.executeUpdate();

	} catch (Exception e) {
	  System.out.println(e.getMessage());
	} finally {
	  try { 
		 pstmt.close();
        conn.close();			  
	  } catch(Exception e2) {
		 System.out.println(e2.getMessage());
	  }
	}	
	return result;
}

public int insertJoin(MeetJoinDto join) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    int result = 0;
      
	try {
	  conn = ds.getConnection();  
	  String sql = "INSERT INTO Meet_Join " + 
	               "VALUES(ME_NO_seq.nextval, ?, ?)";
	  
	  pstmt = conn.prepareStatement(sql);   
	  pstmt.setString(1, join.getMemId()); // 멤버 아이디 
	  pstmt.setInt(2, join.getMbNo()); // 모임 게시글 번호  
	  
	  result = pstmt.executeUpdate();

	} catch (Exception e) {
	  System.out.println(e.getMessage());
	} finally {
	  try { 
		 pstmt.close();
        conn.close();			  
	  } catch(Exception e2) {
		 System.out.println(e2.getMessage());
	  }
	}	
	return result;
}

public int findJoin(String MEM_ID, int MB_NO) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    int result = 0;
    ResultSet rs = null;
      
	try {
	  conn = ds.getConnection();  
	  
	  String sql = "select ME_NO, MEM_ID, MB_NO " + 
	               "from Meet_Join " +
	               "where MEM_ID = ? and MB_NO = ? ";
	  
	  
//	  select ME_NO, MEM_ID, MB_NO
//	  from Meet_Join
//	  where MEM_ID = 'MEM_ID1' and MB_NO = '12';
	  
	  pstmt = conn.prepareStatement(sql);   
	  pstmt.setString(1, MEM_ID); // 멤버 아이디 
	  pstmt.setInt(2, MB_NO); // 모임 게시글 번호  
	  
	  rs = pstmt.executeQuery();
	  
	  while(rs.next()) {
		  ++result;
	  }

	} catch (Exception e) {
	  System.out.println(e.getMessage());
	} finally {
	  try { 
		 pstmt.close();
         conn.close();			  
	  } catch(Exception e2) {
		 System.out.println(e2.getMessage());
	  }
	}	
	return result;
}

public List<MeetMemberListDto> findJoinMember(int MB_NO) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<MeetMemberListDto> meetMemberList = null;
      
	try {
	  conn = ds.getConnection();  
	  
	  String sql = "select j.MB_NO as NO, m.MEM_NIC as NIC, m.MEM_PRO as PRO " + 
	               "from Meet_Join j, Member m " +
	               "where j.MEM_ID = m.MEM_ID and j.MB_NO = ?";
	  
	  pstmt = conn.prepareStatement(sql);   
	  pstmt.setInt(1, MB_NO); // 모임 게시글 번호  
	  
	  rs = pstmt.executeQuery();
	  meetMemberList = new ArrayList<MeetMemberListDto>();
	  
	  System.out.println("findJoinMember rs : " + rs);
	  
	  while(rs.next()) {
		  
		  MeetMemberListDto meetMember = new MeetMemberListDto();  
		  meetMember.setMbNo(rs.getInt("NO"));
		  System.out.println("rs.getInt(\"NO\") : " + rs.getInt("NO"));
		  
		  meetMember.setMemNic(rs.getString("NIC"));
		  System.out.println("rs.getString(\"NIC\") " + rs.getString("NIC"));
		  
		  meetMember.setMemPro(rs.getString("PRO"));
		  System.out.println("rs.getString(\"PRO\")" + rs.getString("PRO"));
		  
		  System.out.println("meetMember : " + meetMember);
		  meetMemberList.add(meetMember);
		  
	  }

	} catch (Exception e) {
	  System.out.println(e.getMessage());
	} finally {
	  try { 
		 pstmt.close();
         conn.close();			  
	  } catch(Exception e2) {
		 System.out.println(e2.getMessage());
	  }
	}	
	System.out.println("meetMemberList : " + meetMemberList);
	return meetMemberList;
}  

public int meetBoardUpdate(int MB_NO, String title, String String) {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	int row = 0;
	
	try {
	  conn = ds.getConnection();
	  
	  String sql = "update Meet_Board " +
	               "set MB_TITLE = ?, MB_CONTENT = ?, MB_CREATED_AT = sysdate " +
			       "where MB_NO = ? ";
	  
	  pstmt = conn.prepareStatement(sql);
	  
	  pstmt.setString(1, title);
	  pstmt.setString(2, String);
	  pstmt.setInt(3, MB_NO);
	  
	  row = pstmt.executeUpdate();
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	return row;
}

/* 	//댓글 삭제하기
	public int replyDelete(String no , String pwd) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;
			
			try {
				
				String replyselect = "select pwd from reply where no=?";
				String replydelete = "delete from reply where no=?";
				
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(replyselect);
				pstmt.setString(1, no);
				rs =pstmt.executeQuery();
				if(rs.next()) {
					String dbpwd = rs.getString("pwd");
					if(pwd.equals(dbpwd)){
						pstmt.close();
						pstmt = conn.prepareStatement(replydelete);
						pstmt.setString(1, no);
						row = pstmt.executeUpdate();
					}else {
						row = 0;
					}
				}else {
					row =-1;
				}
			}catch(Exception e) {
				
			}finally {
				try {
					pstmt.close();
					rs.close();
					conn.close();//반환
				}catch (Exception e) {
					
				}
			}
			
			return row;
		} */

		public int deleteComment(int mrNo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
		    int result = 0;
			
			
			try {
				
				/* 
				 * delete 
					from Meet_Reply
					where MR_NO = 22; */
				
				String sql = "delete " +
				             "from Meet_Reply " +
						     "where MR_NO = ?";
				
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mrNo);
				
				result = pstmt.executeUpdate();
				
			}catch(Exception e) {
				
			}finally {
				try {
					pstmt.close();
					conn.close();//반환
				}catch (Exception e) {
					
				}
			}
			
			return result;
		}
		
		/* 수정해야함 */
		public int deleteMeetBoard(int mbNo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
		    int result = 0;

			try {
				
//				delete
//			    from Meet_Board
//			    where MEM_ID = 'MEM_ID10';
				
				String sql = "delete " +
				             "from Meet_Board " +
						     "where MB_NO = ?";
				
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mbNo);
				
				result = pstmt.executeUpdate();
				
			}catch(Exception e) {
				
			}finally {
				try {
					pstmt.close();
					conn.close();//반환
				}catch (Exception e) {
					
				}
			}
			
			return result;
		}
		
		
		
		
		public int deleteJoin(int ME_NO) {
			Connection conn = null;
			PreparedStatement pstmt = null;
		    int result = 0;
			
			
			try {		
				String sql = "delete " +
				             "from Meet_Join " +
						     "where ME_NO = ?";
				
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ME_NO);
				
				result = pstmt.executeUpdate();
				
			}catch(Exception e) {
				
			}finally {
				try {
					pstmt.close();
					conn.close();//반환
				}catch (Exception e) {
					
				}
			}
			
			return result;
		}

	
}