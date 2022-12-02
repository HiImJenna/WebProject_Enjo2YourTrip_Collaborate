package kr.co.enjo2.dao.flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.enjo2.dto.flight.FlightReserveDto;
import kr.co.enjo2.dto.flight.FlightReserveInfoDto;
import kr.co.enjo2.dto.flight.FlightTotalDto;

public class FlightDao {

	DataSource ds = null;

	public FlightDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}


	public int saveFlightReservation(FlightReserveDto reserveDto, FlightReserveInfoDto[] reserveInfo) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		int result = 0;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);

			////// 승객 정보 (예약 정보) 저장 하기 (insert)
			pstmt1 = conn.prepareStatement("insert into "
					+ "reserve(rsv_no, mem_id, rsv_created_at, rsv_last_nm, rsv_first_nm, rsv_birth, rsv_nation, rsv_gender, rsv_status) "
					+ "values(reserve_seq.nextval, ?, sysdate, ?, ?, ?, ?, ?, ?)");

			// 멤버 아이디
			pstmt1.setString(1, reserveDto.getMemberId());
			// 성
			pstmt1.setString(2, reserveDto.getMemberLastName());
			// 이름
			pstmt1.setString(3, reserveDto.getMemberFirstName());
			// 생년월일
			pstmt1.setString(4, reserveDto.getMemberBirth());
			// 국가
			pstmt1.setString(5, reserveDto.getMemberNation());
			// 성별
			pstmt1.setString(6, reserveDto.getMemberGender());

			pstmt1.setString(7, "RESERVED");

			result = pstmt1.executeUpdate();

			if (result == 0) {
				throw new SQLException();
			}

			////// 예약 정보 key 갖고 오기 ( select 1. rownum을 사용하여 최신 정보의 키값을 조회한다. 2. 시퀀스를 조회한다 )
			// 시퀀스를 조회한다.... 쉬우니까...ㅠㅠ
			pstmt2 = conn.prepareStatement("select reserve_seq.currval as pk from dual");

			rs = pstmt2.executeQuery();
			int reservationNo = 0;
			while (rs.next()) {
				reservationNo = rs.getInt("pk");
			}

			if (reservationNo == 0) {
				throw new SQLException();
			}

			////// 가는 편, 오는 편 정보 저장하기 (insert)
			for (int i = 0; i < 2; ++i) {
				String sql = "insert into "
						+ "rsv_info(info_no, rsv_no, INFO_BOARDING_DATE, INFO_AIR_NM, INFO_DEPART_TIME, INFO_ARRIVE_TIME, INFO_PRICE, INFO_DIRECTION) "
						+ "values(rsv_info_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
				pstmt3 = conn.prepareStatement(sql);
				// 승객 정보 primaryKey
				pstmt3.setInt(1, reservationNo);
				// 예약 일자
				pstmt3.setString(2, reserveInfo[i].getBoardingDate());
				// 항공편
				pstmt3.setString(3, reserveInfo[i].getAirlineNm());
				// 출발 시간
				pstmt3.setString(4, reserveInfo[i].getDepartTime());
				// 도착 시간
				pstmt3.setString(5, reserveInfo[i].getArriveTime());
				// 가격
				pstmt3.setString(6, reserveInfo[i].getPrice());
				// 가는 편 정보
				pstmt3.setString(7, reserveInfo[i].getDirection());

				result = pstmt3.executeUpdate();
				if (result == 0) {
					throw new SQLException();
				}
			}

			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt1 != null) {
					pstmt1.close();
				}
				if (pstmt2 != null) {
					pstmt1.close();
				}
				if (pstmt3 != null) {
					pstmt1.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getStackTrace());
			}
		}
		return result;
	}


	// ********* ReserveInfo ********
	public int saveRsvInfo(FlightReserveInfoDto ticket) {

		System.out.println("FlightDao / saveRsvInfo");

		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;

		try {
			conn = ds.getConnection();
			String sql = "insert into rsv_info(info_air_nm, info_depart_time, info_arrive_time, info_price, info_direction) "
					+ "values(rsv_info_seq.NEXTVAL, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ticket.getAirlineNm());
			pstmt.setString(2, ticket.getDepartTime());
			pstmt.setString(3, ticket.getArriveTime());
			pstmt.setString(4, ticket.getPrice());
			pstmt.setString(5, ticket.getDirection());

			row = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
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

	// ********* Reserve ********
	public int saveRsv(FlightReserveDto reserve) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;

		try {
			conn = ds.getConnection();
			String sql = "insert into reserve(rsv_no, mem_id, rsv_created_at, rsv_last_name, rsv_first_name, rsv_birth, rsv_nation, rsv_gender) "
					+ "values(reserve_seq.NEXTVAL, ?, sysdate, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "hi");
			pstmt.setString(2, reserve.getMemberLastName());
			pstmt.setString(3, reserve.getMemberFirstName());
			pstmt.setString(4, reserve.getMemberBirth());
			pstmt.setString(5, reserve.getMemberNation());
			pstmt.setString(6, reserve.getMemberGender());
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
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

	// 가장 최신 예약 조회하기
	public int findReserveLastOne(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int value = 0;
		try {
			conn = ds.getConnection();
			String sql = "select rsv_no " + "from (" + "        select ROWNUM as NUM, rsv_no " + "        from reserve "
					+ "        where mem_id = ? " + "        order by rsv_created_at desc" + "     ) "
					+ "where NUM = 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				value = rs.getInt("rsv_no");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		return value;
	}

	// 유저별 항공 예약 조회
	public List<FlightTotalDto> findUserRsvInfo(String userId, int page) {

		int[] strPage = calculatePage(page);

		FlightTotalDto flight = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FlightTotalDto> flightList = new ArrayList<>();
		try {
			conn = ds.getConnection();
			String sql = "select no, userid, rdate, bdate, dplace, dtime, aplace, atime, lname, fname, birth, price " + "from"
					+ "          (select ROWNUM as NUM, r.rsv_no as no, r.mem_id as userid, TO_CHAR(r.rsv_created_at, 'YYYY-MM-DD HH24:MI') as rdate, r.rsv_last_nm as lname, r.rsv_first_nm as fname, r.rsv_birth as birth, "
					+ "           r.rsv_nation as nation, r.rsv_gender as gender, r.rsv_status as status, ri.info_no as info_no, ri.info_boarding_date as bdate, ri.info_air_nm as aname, ri.info_depart_time as dtime,"
					+ "           ri.info_arrive_time as atime, ri.info_depart_place as dplace, ri.info_arrive_place as aplace, ri.info_price as price, ri.info_direction as dir\r\n"
					+ "           from reserve r join rsv_info ri on r.rsv_no = ri.rsv_no where r.mem_id = ? order by r.rsv_no desc) "
					+ "where NUM between ? and ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userId); // 물음표
			pstmt.setInt(2, strPage[0]);
			pstmt.setInt(3, strPage[1]);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				flight = new FlightTotalDto();
				flight.setReservationNo(rs.getInt("no"));
				flight.setBoardingDate(rs.getString("bdate"));
				flight.setMemberId(rs.getString("userid"));
				flight.setRsvDate(rs.getString("rdate"));
				flight.setDepartPlace(rs.getString("dplace"));
				flight.setDepartTime(rs.getString("dtime"));
				flight.setArrivePlace(rs.getString("aplace"));
				flight.setArriveTime(rs.getString("atime"));
				flight.setMemberLastName(rs.getString("lname"));
				flight.setMemberFirstName(rs.getString("fname"));
				flight.setMemberBirth(rs.getString("birth"));
				flight.setPrice(rs.getString("price"));
				flightList.add(flight);
			}
		} catch (Exception e) {
			e.printStackTrace();

	/////////////////// !!!!!!!!!!!!!!!!합치기전에 뺄것
	/////////////////// !!!!!!!!!!!!!!!!!!//////////////////////
	// 항공 예매 전체 리스트 출력
	public int getTotalCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			String sql = "select count(*) as cnt from reserve";
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
		return flightList;
	}

	private int[] calculatePage(int page) {
		int[] arr = { 0, 0 };
		arr[0] = 10 * page - 9;
		arr[1] = arr[0] + 10 - 1;
		return arr;
	}

	public int getTotalCount(String userId) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			String sql = "select count(*) as cnt from reserve where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("cnt");
			}
		}
		return count;
	}

	public List<FlightTotalDto> findAllByPage(int page) {
		int[] strPage = calculatePage(page);
		List<FlightTotalDto> flightList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();

			String sql = "select no, id, cdate, lname, fname, birth, bdate, dplace, dtime, aplace, atime, price "
					+ "   from("
					+ "        SELECT ROWNUM as NUM, r.rsv_no as no, mem_id as id, TO_CHAR(r.rsv_created_at, 'YYYY-MM-DD HH24:MI') as cdate, r.rsv_last_nm as lname, "
					+ "        r.rsv_first_nm as fname, r.rsv_birth as birth, ri.info_boarding_date as bdate, ri.INFO_DEPART_PLACE as dplace, "
					+ "        ri.info_depart_time as dtime, ri.INFO_ARRIVE_PLACE as aplace, ri.info_arrive_time as atime, ri.info_price as price "
					+ "		   from reserve r join rsv_info ri on r.rsv_no = ri.rsv_no order by r.rsv_no desc"
					+ "    ) "
					+ "   where NUM BETWEEN ? AND ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, strPage[0]);
			pstmt.setInt(2, strPage[1]);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FlightTotalDto flight = new FlightTotalDto();
				flight.setReservationNo(rs.getInt("no"));
				flight.setMemberId(rs.getString("id"));
				flight.setRsvCreatedDate(rs.getString("cdate"));
				flight.setMemberLastName(rs.getString("lname"));
				flight.setMemberFirstName(rs.getString("fname"));
				flight.setMemberBirth(rs.getString("birth"));
				flight.setBoardingDate(rs.getString("bdate"));
				flight.setDepartPlace(rs.getString("dplace"));
				flight.setDepartTime(rs.getString("dtime"));
				flight.setArrivePlace(rs.getString("aplace"));
				flight.setArriveTime(rs.getString("atime"));
				flight.setPrice(rs.getString("price"));
				flightList.add(flight);
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
		return flightList;
	}
}
