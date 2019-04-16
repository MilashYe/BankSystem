package model.dao.impl.jdbc.mysql;

import model.dao.impl.jdbc.mapper.AccountMapper;
import model.dao.impl.jdbc.mapper.UserMapper;
import model.dao.interfaces.UserDAO;
import model.entity.Account;
import model.entity.User;
import model.exception.UserExistException;
import model.exception.UserNoExistException;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUserDAO implements UserDAO {

	private Connection connection ;
	private Logger log = Logger.getLogger(this.getClass());
	private UserMapper userMapper = new UserMapper();
	private AccountMapper accountMapper = new AccountMapper();

	public JDBCUserDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(User entity) {
		try( PreparedStatement statement = connection.prepareStatement(SQLQueries.CREATE_USER, Statement.RETURN_GENERATED_KEYS) ){
			connection.setAutoCommit(false);

			statement.setString(1, entity.getLogin());
			statement.setString(2,entity.getRole());
			statement.setString(3, entity.getPwdHash());
			statement.setString(4, entity.getName());
			statement.setString(5, entity.getSurname());
			statement.setString(6, entity.getPhone());

			statement.executeUpdate();
			connection.commit();
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					entity.setId(generatedKeys.getInt(1));
				} else throw new SQLException("Something wrong with user id");
			}
			log.info("Method create, UserDAO:");

		} catch ( SQLException e ) {
			try{
				connection.rollback();
			} catch (SQLException ex) {
				throw new RuntimeException();
			}
			log.info("Throw UserExistException");
			throw new UserExistException("user already exist");
		}

	}

	@Override
	public User readById(int id) {
		try( PreparedStatement statement = connection.prepareStatement(SQLQueries.READ_USER_BY_ID) ){
			statement.setInt(1, id);

			return createUser(statement);


		} catch ( SQLException e ) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public User readByLogin(String login) {
		try( PreparedStatement statement = connection.prepareStatement(SQLQueries.READ_USER_BY_LOGIN) ){
			statement.setString(1, login);

			return createUser(statement);

		} catch ( SQLException e ) {
			e.printStackTrace();
			throw new UserNoExistException("sorry, user can`t be find");
		}

	}

	private User createUser(PreparedStatement st) throws SQLException {
		User findingUser = null;
		ResultSet set = st.executeQuery();

		Map<Integer, User> userMap = new HashMap<>();
		Map<Integer, Account> accountMap = new HashMap<>();
		while (set.next()) {
			findingUser = userMapper.extractFromResultSet(set);
			findingUser = userMapper.makeUnique(userMap, findingUser);
			Account account = accountMapper.extractFromResultSet(set);
			account = accountMapper.makeUnique(accountMap, account);

			findingUser.getAccounts().add(account);
		}
		log.info("User was created "+findingUser);
		if (findingUser == null) {
			throw new SQLException("Something wrong in UserDao");
		} else {
			return findingUser;
		}

	}

	@Override
	public List<User> readAll() {
		Map<Integer, User> users = new HashMap<>();
		Map<Integer, Account> accounts = new HashMap<>();

		ResultSet rs;
		try (Statement st = connection.createStatement()) {
			rs = st.executeQuery(SQLQueries.READ_ALL_USER);


			while (rs.next()) {
				User user = userMapper.extractFromResultSet(rs);
				Account account = accountMapper.extractFromResultSet(rs);

				user = userMapper.makeUnique(users, user);
				account = accountMapper.makeUnique(accounts, account);
				user.getAccounts().add(account);

			}

			log.info("Users were read");
			return new ArrayList<>(users.values());
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void update(User entity) {

	}

	@Override
	public void delete(User entity) {
		try (PreparedStatement statement = connection.prepareStatement(SQLQueries.DELETE_USER)) {
			statement.setString(1,entity.getLogin());
			statement.executeUpdate();
			log.info("User was deleted from db.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
