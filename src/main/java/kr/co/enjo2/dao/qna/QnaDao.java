package kr.co.enjo2.dao.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.enjo2.dto.notice.NoticeDto;
import kr.co.enjo2.dto.qna.QnaDto;

public class QnaDao {
	DataSource ds = null;

	public QnaDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}
	
	public List<QnaDto> findMainInfo() {
		List<QnaDto> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			String sql = "select title, timeAt " +
					                     "from(" +
					                     "        select ROWNUM as NUM, q_title as title, TO_CHAR(q_created_at, 'YYYY-MM-DD') as timeAt " +
					                     "        from qna " +
					                     "        where q_no = q_ref " +
					                     "        order by q_no desc " +
					                     "     ) " +
					                     "where NUM <= 5 ";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnaDto qna = new QnaDto();
				qna.setTitle(rs.getString("title"));
				qna.setCreatedAt(rs.getString("timeAt"));
				list.add(qna);
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
		return list;
	}
	
	public int getTotalCount() {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select count(*) as cnt " + "from qna " + "where q_no = q_ref";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getInt("cnt");
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

		return result;
	}
	
	public List<QnaDto> findAllByPage(int page) {
		
		int[] strPage = calculatePage(page);
		
		List<QnaDto> qnaList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = ds.getConnection();
	         String sql = "select q_no, mem_id, q_ref, q_title, q_content, TO_CHAR(q_created_at, 'yy-MM-DD HH24:MI') as timeAt "
	         		+     "from qna A join("
	         		+ "                      select key "
	         		+ "                      from ("
	         		+ "                        select ROWNUM as NUM, q_no as key "
	         		+ "                        from qna "
	         		+ "                        where q_no = q_ref "
	         		+ "                        order by q_no desc "
	         		+ "                      )"
	         		+ "                      where NUM BETWEEN ? AND ?"
	         		+ "                   ) B "
	         		+     "ON A.q_ref = B.key "
	         		+     "order by q_ref desc, q_no asc";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, strPage[0]);
			pstmt.setInt(2, strPage[1]);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnaDto qna = new QnaDto();
				qna.setQnaNo(rs.getInt("q_no"));
				qna.setMemberId(rs.getString("mem_id"));
				qna.setQnaRef(rs.getInt("q_ref"));
				qna.setTitle(rs.getString("q_title"));
				qna.setContent(rs.getString("q_content"));
				qna.setCreatedAt(rs.getString("timeAt"));
				qnaList.add(qna);
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
		return qnaList;
	}
	
	private int[] calculatePage(int page) {
		int[] arr = { 0, 0 };
		arr[0] = 10 * page - 9;
		arr[1] = arr[0] + 10 - 1;
		return arr;
	}
}
