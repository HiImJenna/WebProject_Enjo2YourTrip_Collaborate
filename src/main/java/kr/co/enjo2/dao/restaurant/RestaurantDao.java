package kr.co.enjo2.dao.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.enjo2.dto.restaurant.JjimDto;

/*
	맛집 DB 데이터 로직 작성
*/
public class RestaurantDao {
	
	DataSource ds = null;

	public RestaurantDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}
	public List<JjimDto> findAllInfo( String userId) {
	      List<JjimDto> result = new ArrayList<>();
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      try {
		         conn = ds.getConnection();
		         pstmt = conn.prepareStatement(
		        		 "select j_store_nm as name, j_addr as addr  from jjim where mem_id=?"
		        );
		         pstmt.setString(1, userId);
		         rs = pstmt.executeQuery();
		         while (rs.next()) {
		        	 JjimDto jjim = new JjimDto();
		        	 jjim.setJ_store_nm(rs.getString("name"));
		        	 jjim.setJ_addr(rs.getString("addr"));
		        	 result.add(jjim);
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
	public int findJjimInfo(String name, String userId) {
	      int result = 0;
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      try {
	         conn = ds.getConnection();
	         pstmt = conn.prepareStatement(
	               "select count(*) as cnt " +
	               "from jjim " +
	               "where j_store_nm = ? and mem_id = ?"
	         );
	         pstmt.setString(1, name);
	         pstmt.setString(2, userId);
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
	public int addJjimInfo(String name, String userId, String addr) {
		int result=0;
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
		
	      try {
		         conn = ds.getConnection();
		         pstmt = conn.prepareStatement(
		        		"insert into jjim "
		        		+ "(j_no, mem_id, j_store_nm, j_addr) "
		        		+ "values(jjim_seq.nextval, ?, ?, ?)"
		         );
		         pstmt.setString(1, userId);
		         pstmt.setString(2, name);
		         pstmt.setString(3, addr);
		         result = pstmt.executeUpdate();
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
		return result;
	}
	public int deleteJjimInfo(String name, String userId) {
		int result=0;
	      Connection conn = null;
	      PreparedStatement pstmt = null;
		
	      try {
		         conn = ds.getConnection();
		         pstmt = conn.prepareStatement(
		               "delete from jjim " +
		               "where mem_id=? and " +
		               " j_store_nm = ?"
		         );
		         pstmt.setString(1, userId);
		         pstmt.setString(2, name);
		         result = pstmt.executeUpdate();
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
	      
		return result;
	}
}
