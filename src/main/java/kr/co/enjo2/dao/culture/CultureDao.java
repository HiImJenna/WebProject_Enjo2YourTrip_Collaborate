package kr.co.enjo2.dao.culture;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
	문화 DB 데이터 로직 작성
*/
public class CultureDao {
	
	DataSource ds = null;

	public CultureDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}
}
