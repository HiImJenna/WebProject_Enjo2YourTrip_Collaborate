package kr.co.enjo2.dao.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.enjo2.dto.member.MemberDto;
import kr.co.enjo2.dto.notice.NoticeDto;

public class NoticeDao {
   DataSource ds = null;

   public NoticeDao() throws NamingException {
      Context context = new InitialContext();
      ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
   }

   public int getTotalCount() {
      int count = 0;
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         conn = ds.getConnection();
         String sql = "select count(notice_no) as cnt from notice";
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();

         while (rs.next()) {
            count = rs.getInt("cnt");
         }

      } catch (Exception e) {
         System.out.println(e.getMessage());
      } finally {
         try {
            pstmt.close();
            rs.close();
            conn.close();
         } catch (Exception e2) {
            System.out.println(e2.getMessage());
         }
      }

      return count;
   }

   public List<NoticeDto> findAllByPage(int page) {

      int[] strPage = calculatePage(page);

      List<NoticeDto> noticeList = new ArrayList<>();

      MemberDto member = null;
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         conn = ds.getConnection();
         String sql = "select NUM, notice_no, mem_id, noti_title, noti_content, timeAt " + "from("
               + "        select ROWNUM as NUM, notice_no, mem_id, noti_title, noti_content, TO_CHAR(noti_created_at, 'YYYY-MM-DD HH24:MI') as timeAt "
               + "        from notice " + "        order by notice_no desc" + "       ) "
               + "where NUM BETWEEN ? AND ?";

         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, strPage[0]);
         pstmt.setInt(2, strPage[1]);
         rs = pstmt.executeQuery();
         while (rs.next()) {
            NoticeDto notice = new NoticeDto();
            notice.setNoticeNo(rs.getInt("notice_no"));
            notice.setMemberId("관리자");
            notice.setTitle(rs.getString("noti_title"));
            notice.setContent(rs.getString("noti_content"));
            notice.setCreatedAt(rs.getString("timeAt"));
            noticeList.add(notice);
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      } finally {
         try {
            pstmt.close();
            rs.close();
            conn.close();
         } catch (Exception e2) {
            System.out.println(e2.getMessage());
         }
      }

      return noticeList;
   }

   private int[] calculatePage(int page) {
      int[] arr = { 0, 0 };
      arr[0] = 10 * page - 9;
      arr[1] = arr[0] + 10 - 1;
      return arr;
   }

   public int saveNoticeOne(NoticeDto notice) {

      Connection conn = null;
      PreparedStatement pstmt = null;
      int row = 0;

      try {
         conn = ds.getConnection();
         String sql = "insert into NOTICE(notice_no, mem_id, noti_title, noti_content, noti_created_at) "
               + "values(notice_seq.nextval, 'admin', ?, ?, sysdate)";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, notice.getTitle());
         pstmt.setString(2, notice.getContent());
         row = pstmt.executeUpdate();
      } catch (Exception e) {
         System.out.println(e.getMessage());
      } finally {
         try {
            pstmt.close();
            conn.close();
         } catch (Exception e2) {
            System.out.println(e2.getMessage());
         }
      }

      return row;
   }

   public NoticeDto findOne(int noticeNo) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      NoticeDto notice = null;
      
      try {
         conn = ds.getConnection();
         String sql = "select notice_no, mem_id, noti_title, noti_content, TO_CHAR(noti_created_at, 'YYYY-MM-DD HH24:MI') as timeAt "
               +    "from notice where notice_no=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, noticeNo);

         rs = pstmt.executeQuery();
         if (rs.next()) {
            notice = new NoticeDto();
            notice.setNoticeNo(Integer.parseInt(rs.getString("notice_no")));
            notice.setMemberId(rs.getString("mem_id"));
            notice.setTitle(rs.getString("noti_title"));
            notice.setContent(rs.getString("noti_content"));
            notice.setCreatedAt(rs.getString("timeAt"));
         }
      } catch (Exception e) {
         System.out.println("content " + e.getMessage());
      }finally {
         try {
            pstmt.close();
            rs.close();
            conn.close();
         }catch(Exception e2) {
            System.out.println(e2.getMessage());
         }
      }
      return notice;
   }
   public int updateOne(NoticeDto notice) {
	      int result = 0;
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      try {
	         conn = ds.getConnection();
	         String sql = "update notice " + 
	                    "set noti_title = ?, noti_content = ? " + 
	                    "where notice_no = ?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, notice.getTitle());
	         pstmt.setString(2, notice.getContent());
	         pstmt.setInt(3, notice.getNoticeNo());
	         result = pstmt.executeUpdate();
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      }
	      return result;
	   }
   
   
}

//package kr.co.enjo2.dao.notice;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//
//import kr.co.enjo2.dto.member.MemberDto;
//import kr.co.enjo2.dto.notice.NoticeDto;
//
//public class NoticeDao {
//	DataSource ds = null;
//
//	public NoticeDao() throws NamingException {
//		Context context = new InitialContext();
//		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
//	}
//	
//	public int getTotalCount() {
//		int count = 0;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = ds.getConnection();
//			String sql = "select count(notice_no) as cnt from notice";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
//				count = rs.getInt("cnt");
//			}
//			
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				pstmt.close();
//				rs.close();
//				conn.close();
//			} catch (Exception e2) {
//				System.out.println(e2.getMessage());
//			}
//		}
//		
//		return count;
//	}
//	
//	public List<NoticeDto> findAllByPage(int page) {
//		
//		int[] strPage = calculatePage(page);
//		
//		List<NoticeDto> noticeList = new ArrayList<>();
//		
//		MemberDto member = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = ds.getConnection();
//			String sql = "select NUM, notice_no, mem_id, noti_title, noti_content, timeAt "
//					+    "from("
//					+ "        select ROWNUM as NUM, notice_no, mem_id, noti_title, noti_content, TO_CHAR(noti_created_at, 'YYYY-MM-DD HH24:MI') as timeAt "
//					+ "        from notice "
//					+ "        order by notice_no desc"
//					+ "       ) "
//					+    "where NUM BETWEEN ? AND ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, strPage[0]);
//			pstmt.setInt(2, strPage[1]);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				NoticeDto notice = new NoticeDto();
//				notice.setNoticeNo(rs.getInt("notice_no"));
//				notice.setMemberId("관리자");
//				notice.setTitle(rs.getString("noti_title"));
//				notice.setContent(rs.getString("noti_content"));
//				notice.setCreatedAt(rs.getString("timeAt"));
//				noticeList.add(notice);
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				pstmt.close();
//				rs.close();
//				conn.close();
//			} catch (Exception e2) {
//				System.out.println(e2.getMessage());
//			}
//		}
//		
//		return noticeList;
//	}
//	
//	private int[] calculatePage(int page) {
//		int[] arr = {0, 0};
//		arr[0] = 10 * page - 9;
//		arr[1] = arr[0] + 10 - 1;
//		return arr;
//	}
//	
//	public int saveNoticeOne(NoticeDto notice) {
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		int row = 0;
//		
//		try {
//			conn = ds.getConnection();
//			String sql="insert into NOTICE(notice_no, mem_id, noti_title, noti_content, noti_created_at) "+
//			           "values(notice_seq.nextval, 'admin', ?, ?, sysdate)";
//			pstmt =conn.prepareStatement(sql);
//			pstmt.setString(1, notice.getTitle());
//			pstmt.setString(2, notice.getContent());
//			row = pstmt.executeUpdate();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				pstmt.close();
//				conn.close();
//			} catch (Exception e2) {
//				System.out.println(e2.getMessage());
//			}
//		}
//		
//		return row;
//	}
//}
