package model.dao.impl.jdbc;

import model.dao.ConnectionPool;
import model.dao.DAOFactory;
import model.dao.impl.jdbc.mysql.*;
import model.dao.interfaces.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DAOFactory {

	private DataSource dataSource = ConnectionPool.getDataSource();

	@Override
	public UserDAO createUserDAO() {
		return new JDBCUserDAO(connection()) ;
	}

	@Override
	public AccountDAO createAccountDAO() {
		return new JDBCAccountDAO(connection());
	}

	@Override
	public CreditDAO createCreditDAO() {
		return new JDBCCreditDAO(connection());
	}

	@Override
	public DepositDAO createDepositDAO() {
		return new JDBCDepositDAO(connection());
	}

	@Override
	public TimeDao createTimeDAO() {
		return new JDBCTimeDao(connection());
	}

	private Connection connection() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return connection;
	}


}
