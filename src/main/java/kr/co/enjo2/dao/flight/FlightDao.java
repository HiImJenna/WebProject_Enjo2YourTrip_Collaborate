package kr.co.enjo2.dao.flight;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
	항공 DB 데이터 로직 작성
*/
public class FlightDao {
	DataSource ds = null;

	public FlightDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}
}
