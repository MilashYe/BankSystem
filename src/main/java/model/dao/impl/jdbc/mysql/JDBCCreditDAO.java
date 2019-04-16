package model.dao.impl.jdbc.mysql;

import model.dao.impl.jdbc.mapper.CreditMapper;
import model.dao.interfaces.CreditDAO;
import model.entity.Credit;
import org.apache.log4j.Logger;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCCreditDAO implements CreditDAO {

	private Logger log = Logger.getLogger(this.getClass());

	private Connection connection;

	public JDBCCreditDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Credit entity) {
		try(PreparedStatement statement = connection.prepareStatement(SQLQueries.CREATE_CREDIT, Statement.RETURN_GENERATED_KEYS)) {
			statement.setLong(1,entity.getMoney());
			statement.setInt(2, entity.getPercent());
			statement.setString(3, entity.getType().getType());
			statement.setInt(4, entity.getTermToClose());
			statement.setBoolean(5, false);
			statement.setBoolean(6, false);
			statement.setInt(7,entity.getAccount());

			statement.executeUpdate();
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					entity.setIdCred(generatedKeys.getInt(1));
				} else throw new SQLException("Something wrong with user id");
			}
			createTime(entity.getAccount(),"Credit "+entity.getIdCred()+" was created");
			log.info("Credit was created ");
		} catch (SQLException e) {
			log.info("SQLException in create credit");
			e.printStackTrace();
		}

	}

	@Override
	public Credit readById(int id) {

		try (PreparedStatement statement = connection.prepareStatement(SQLQueries.READ_CREDIT_BY_ID)) {
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			Map<Integer, Credit> creditMap = new HashMap<>();
			Credit credit = null;
			while (set.next()) {
				credit = new CreditMapper().extractFromResultSet(set);
				credit = new CreditMapper().makeUnique(creditMap, credit);
			}
			return credit;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Credit> readAll() {
		return null;
	}

	@Override
	public void update(Credit entity) {
		try (PreparedStatement statement = connection.prepareStatement(SQLQueries.UPDATE_CREDIT)) {
			connection.setAutoCommit(false);
			statement.setLong(1, entity.getMoney());
			statement.setInt(2, entity.getTermToClose());
			statement.setBoolean(3, entity.isApproved());
			statement.setBoolean(4, entity.isRejected());
			statement.setInt(5, entity.getIdCred());
			/*createTime(entity.getAccount(),"Credit "+entity.getIdCred()+" was updated");*/
			statement.executeUpdate();
			connection.commit();
			log.info("Credit succesfully updated");

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			log.info("Error in update credit : " + e.getMessage());
		}
	}

	@Override
	public void delete(Credit entity) {
		try (PreparedStatement statement = connection.prepareStatement(SQLQueries.DELETE_CREDIT)) {
			statement.setInt(1, entity.getIdCred());
			statement.executeUpdate();
			createTime(entity.getAccount(), "Credit "+entity.getIdCred()+" was closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void createTime(int accId, String mess) {
		try (PreparedStatement st1 = connection.prepareStatement(SQLQueries.CREATE_TIME)) {
			st1.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			st1.setInt(2,accId);
			st1.setString(3, mess);
			st1.executeUpdate();
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
