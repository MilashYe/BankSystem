package model.dao.impl.jdbc.mysql;

import model.dao.impl.jdbc.mapper.*;
import model.dao.interfaces.AccountDAO;
import model.entity.*;
import org.apache.log4j.Logger;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class JDBCAccountDAO implements AccountDAO {

	private final Connection connection;

	private AccountMapper accountMapper = new AccountMapper();
	private Logger log = Logger.getLogger(this.getClass());

	public JDBCAccountDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Account entity) {
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueries.CREATE_ACCOUNT,Statement.RETURN_GENERATED_KEYS);
			connection.setAutoCommit(false);
			statement.setLong(1, entity.getMoney());
			statement.setBoolean(2, entity.isClosed());
			statement.executeUpdate();
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					entity.setId(generatedKeys.getInt(1));
				} else throw new SQLException("Something wrong with account id");
			}
			statement = connection.prepareStatement(SQLQueries.CREATE_TIME);

			statement.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			statement.setInt(2,entity.getId());
			statement.setString(3,"Account "+entity.getId()+" was created");
			statement.executeUpdate();
			statement.close();
			connection.commit();
		} catch (SQLException e) {
			log.info("SQLException when create account");
			try {
				connection.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Account readById(int id) {

		try (PreparedStatement statement = connection.prepareStatement(SQLQueries.READ_ACCOUNT_BY_ID)) {
			statement.setInt(1, id);
			Account account = createAccount(statement);
			log.info("account read in account dao "+account);
			return account;
		} catch (SQLException e) {
			log.info("SQLException when read account by id " + e.getMessage());
			return null;
		}
	}

	private Account createAccount(PreparedStatement statement) throws SQLException {
		ResultSet set = statement.executeQuery();

		Account account = null;

		Map<Integer, Account> accountMap = new HashMap<>();
		Map<Integer, User> userMap = new HashMap<>();
		Map<Integer, Deposit> depositMap = new HashMap<>();
		Map<Integer, Credit> creditMap = new HashMap<>();
		Map<Integer, ChangeTime> timeMap = new HashMap<>();

		UserMapper userMapper = new UserMapper();
		DepositMapper depositMapper = new DepositMapper();
		CreditMapper creditMapper = new CreditMapper();
		TimeMapper timeMapper = new TimeMapper();


		while (set.next()) {
			account = accountMapper.extractFromResultSet(set);
			account = accountMapper.makeUnique(accountMap, account);

			userMapper.makeUnique(userMap, userMapper.extractFromResultSet(set));

			depositMapper.makeUnique(depositMap, depositMapper.extractFromResultSet(set));

			creditMapper.makeUnique(creditMap, creditMapper.extractFromResultSet(set));

			timeMapper.makeUnique(timeMap, timeMapper.extractFromResultSet(set));


		}
		if (account == null) {
			log.info("account == null");
			throw new SQLException("Something wrong in JDBCAccount dao createAccount");

		} else {
			account.getUsers().addAll(userMap.values());
			account.getDeposits().addAll(depositMap.values());
			account.getCredits().addAll(creditMap.values());
			account.getChangeTime().addAll(timeMap.values());

			log.info("account is " + account);

			return account;
		}
	}
	@Override
	public List<Account> readAll() {
		Map<Integer, Account> accountMap = new HashMap<>();
		Map<Integer, User> userMap = new HashMap<>();
		Map<Integer, Credit> creditMap = new HashMap<>();
		Map<Integer, Deposit> depositMap = new HashMap<>();
		Map<Integer, ChangeTime> timeMap = new HashMap<>();
		UserMapper userMapper = new UserMapper();

		AccountMapper accountMapper = new AccountMapper();
		ResultSet set;
		try (Statement statement = connection.createStatement()) {
			set = statement.executeQuery(SQLQueries.READ_ALL_ACCOUNT);
			while (set.next()) {

				User user = userMapper.extractFromResultSet(set);
				Account account = accountMapper.extractFromResultSet(set);

				account = accountMapper.makeUnique(accountMap, account);
				user = userMapper.makeUnique(userMap, user);

				account.getUsers().add(user);
				account.getDeposits()
						.add(new DepositMapper().
								makeUnique(depositMap, new DepositMapper().extractFromResultSet(set)));
				account.getCredits().
						add(new CreditMapper().
								makeUnique(creditMap, new CreditMapper().extractFromResultSet(set)));
				account.getChangeTime().
						add(new TimeMapper().
								makeUnique(timeMap, new TimeMapper().extractFromResultSet(set)));

			}
			System.out.println(userMap.values());
			return new ArrayList<>(accountMap.values());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Account entity) {
		try  {
			PreparedStatement statement = connection.prepareStatement(SQLQueries.UPDATE_ACOUNT_MONEY);
			statement.setLong(1, entity.getMoney());
			statement.setBoolean(2,entity.isClosed());
			statement.setInt(3, entity.getId());


			statement.executeUpdate();
			addTime(entity.getId(),"Account money were updated, balance is "+entity.getMoney()/100);
			statement.close();
		} catch (SQLException e) {
			try {
				connection.rollback();
				log.info("Error in account update");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void addTime(int accountId, String message) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(SQLQueries.CREATE_TIME)) {
			statement.setInt(2, accountId);
			statement.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			statement.setString(3, message);

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Account entity) {
		try (PreparedStatement statement = connection.prepareStatement(SQLQueries.DELETE_ACCOUNT)) {
			statement.setInt(1,entity.getId());
			statement.executeUpdate();
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

	@Override
	public void addAccountToUser(int accountId, int userId) {
		try (PreparedStatement statement = connection.prepareStatement(SQLQueries.ADD_USER_AND_ACCOUNT)) {
			statement.setInt(1, accountId);
			statement.setInt(2, userId);
			statement.executeUpdate();
			connection.commit();
			log.info("Account added into stuff table acc:"+accountId+" user:"+userId);
		} catch (SQLException e) {
			log.info("error in addAccount" + e);
		}
	}

	@Override
	public void startTransaction() {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void endTransaction() {
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rollbackTransactio() {
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
