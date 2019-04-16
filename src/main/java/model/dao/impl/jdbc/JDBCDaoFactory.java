package model.dao.impl.jdbc;

import model.dao.ConnectionPool;
import model.dao.DAOFactory;
import model.dao.impl.jdbc.mysql.JDBCAccountDAO;
import model.dao.impl.jdbc.mysql.JDBCCreditDAO;
import model.dao.impl.jdbc.mysql.JDBCDepositDAO;
import model.dao.impl.jdbc.mysql.JDBCUserDAO;
import model.dao.interfaces.AccountDAO;
import model.dao.interfaces.CreditDAO;
import model.dao.interfaces.DepositDAO;
import model.dao.interfaces.UserDAO;

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
