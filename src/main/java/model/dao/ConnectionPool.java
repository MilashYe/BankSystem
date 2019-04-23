package model.dao;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.util.ResourceBundle;

public class ConnectionPool {
	private static volatile DataSource dataSource;

	public static DataSource getDataSource() {
		if ( dataSource == null ) {
			synchronized (DataSource.class) {
				if ( dataSource == null ) {
					BasicDataSource bs = new BasicDataSource();
					bs.setUrl(ResourceBundle.getBundle("dbconnection").getString("url"));
					bs.setDriverClassName(ResourceBundle.getBundle("dbconnection").getString("driver"));
					bs.setUsername(ResourceBundle.getBundle("dbconnection").getString("login"));
					bs.setPassword(ResourceBundle.getBundle("dbconnection").getString("pass"));
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
