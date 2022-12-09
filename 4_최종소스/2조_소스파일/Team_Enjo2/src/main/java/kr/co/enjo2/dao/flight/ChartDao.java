package kr.co.enjo2.dao.flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import kr.co.enjo2.dto.flight.ChartDto;

public class ChartDao {
	DataSource ds = null;

	public ChartDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}
	
	// 사용자 종합 수 조회
	public List<ChartDto> totalUserCount(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ChartDto> rsvlist = new ArrayList<ChartDto>();
		
		try {
			conn = ds.getConnection();
			String sql = "select substr(INFO_BOARDING_DATE, 6,2) as month, "
							+ "count(INFO_BOARDING_DATE ) as date_count from reserve r join rsv_info ri on r.rsv_no = ri.rsv_no "
							+ "group by substr(INFO_BOARDING_DATE, 6,2) "
							+ "order by month asc ";
			
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	ChartDto chartdto = new ChartDto();
            	chartdto.setInfoBoaringDate(rs.getString("month"));
            	chartdto.setCount(rs.getInt("date_count"));
            	rsvlist.add(chartdto);
			}
			
		} catch (Exception e) {
			System.out.println("message1111 : " + e.getMessage());
		
		} finally {
			try {
				pstmt.close();
	            rs.close();
	            conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return rsvlist;
	}

	// 성별 수 조회
	public List<ChartDto> genderCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ChartDto> rsvlist = new ArrayList<ChartDto>();
		
		try {
			conn = ds.getConnection();
			String sql = "select rsv_gender as gender, count (rsv_gender) as gender_count "
					+ "from reserve r join rsv_info ri on r.rsv_no = ri.rsv_no  "
					+ "group by rsv_gender order by gender ";
			
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	ChartDto chartdto = new ChartDto();
            	chartdto.setRsvGender(rs.getString("gender"));
            	chartdto.setCount(rs.getInt("gender_count"));
            	rsvlist.add(chartdto);
			}

		} catch (Exception e) {
			System.out.println("message222 : " +e.getMessage());
		} finally {
			 try {
		            pstmt.close();
		            rs.close();
		            conn.close();
		         } catch (Exception e2) {
		            System.out.println(e2.getMessage());
		         }
		}
		return rsvlist;
	}

	// 항공사 수 조회
	public List<ChartDto> airCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ChartDto> rsvlist = new ArrayList<ChartDto>();
		
		try {
			conn = ds.getConnection();
			String sql = "select info_air_nm as airline, count (info_air_nm) as air_count "
						+ "from reserve r join rsv_info ri on r.rsv_no = ri.rsv_no  "
						+ "group by info_air_nm order by airline";
			
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	ChartDto chartdto = new ChartDto();
            	chartdto.setCount(rs.getInt("air_count"));
            	chartdto.setInfoAirNm(rs.getString("airline"));
            	rsvlist.add(chartdto);
			}
		} catch (Exception e) {
			System.out.println("message333 : " +e.getMessage());
			
		} finally {
			 try {
		            pstmt.close();
		            rs.close();
		            conn.close();
		         } catch (Exception e2) {
		            System.out.println(e2.getMessage());
		         }
		}
		return rsvlist;
	}
}
