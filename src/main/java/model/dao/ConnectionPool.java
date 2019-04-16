package model.dao;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class ConnectionPool {
	private static volatile DataSource dataSource;

	public static DataSource getDataSource() {
		if ( dataSource == null ) {
			synchronized (DataSource.class) {
				if ( dataSource == null ) {
					BasicDataSource bs = new BasicDataSource();
					bs.setUrl("jdbc:mysql://localhost:3306/bankdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
					bs.setDriverClassName("com.mysql.cj.jdbc.Driver");
					bs.setUsername("root");
					bs.setPassword("root");
					bs.setMinIdle(5);
					bs.setMaxIdle(10);
					bs.setMaxOpenPreparedStatements(100);
					dataSource = bs;
				}
			}
		}
		return dataSource;
	}


}
