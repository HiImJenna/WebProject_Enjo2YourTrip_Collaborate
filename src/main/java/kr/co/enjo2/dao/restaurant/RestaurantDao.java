package kr.co.enjo2.dao.restaurant;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
	맛집 DB 데이터 로직 작성
*/
public class RestaurantDao {
	
	DataSource ds = null;

	public RestaurantDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}
}
