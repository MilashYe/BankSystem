package model.dao.impl.jdbc.mysql;

import model.dao.impl.jdbc.mapper.DepositMapper;
import model.dao.interfaces.DepositDAO;
import model.entity.Deposit;
import org.apache.log4j.Logger;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCDepositDAO implements DepositDAO {
	private Connection connection;
	private Logger log = Logger.getLogger(this.getClass());
	public JDBCDepositDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Deposit entity) {

		try(PreparedStatement statement =
					connection.prepareStatement(SQLQueries.CREATE_DEPOSIT, Statement.RETURN_GENERATED_KEYS)) {
			statement.setInt(1,entity.getIdAcc());
			statement.setLong(2, entity.getMoney());
			statement.setInt(3, entity.getPercent());
			statement.setString(4, entity.getType().getType());
			statement.setLong(5, 0);
			statement.setString(6,
					new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(entity.getStartDate()));

			statement.setInt(7,entity.getEndTime());
			statement.executeUpdate();
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					entity.setIdDep(generatedKeys.getInt(1));
				} else throw new SQLException("Something wrong with user id");
			}
			createTime(entity.getIdAcc(), "Deposit "+ entity.getIdDep()+" was created");
			log.info("Deposit was created ");
		} catch (SQLException e) {
			log.info("SQLException in create deposit");
			e.printStackTrace();
		}
	}

	@Override
	public Deposit readById(int id) {
		try (PreparedStatement statement = connection.prepareStatement(SQLQueries.READ_DEPOSIT_BY_ID)) {
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			Map<Integer, Deposit> depositMap = new HashMap<>();
			Deposit deposit = null;
			while (set.next()) {
				deposit = new DepositMapper().extractFromResultSet(set);
				deposit = new DepositMapper().makeUnique(depositMap, deposit);
			}
			return deposit;
		} catch (SQLException e) {
			log.info("SQL error in read deposit by id " + e.getMessage());
		}

		return null;
	}

	@Override
	public List<Deposit> readAll() {
		return null;
	}

	@Override
	public void update(Deposit entity) {
		try (PreparedStatement statement = connection.prepareStatement(SQLQueries.UPDATE_DEPOSIT)) {
			statement.setLong(1, entity.getMoney());
			statement.setLong(2, entity.getReceivedMoney());
			statement.setInt(3, entity.getIdDep());

			statement.executeUpdate();
			log.info("Deposit succesfully updated");

		} catch (SQLException e) {
			log.info("Error in update deposit : " + e.getMessage());
		}
	}

	@Override
	public void delete(Deposit entity) {
		try(PreparedStatement statement = connection.prepareStatement(SQLQueries.DELETE_DEPOSIT)) {
			statement.setInt(1, entity.getIdDep());
			statement.executeUpdate();
			createTime(entity.getIdAcc(),"Deposit "+entity.getIdDep()+" was deleted");
			log.info("deposit was deleted");

		} catch (SQLException e) {
			log.info("Error in delete deposit" + e.getMessage());
		}
	}

	private void createTime(int id, String mess) {
		try(PreparedStatement st1 = connection.prepareStatement(SQLQueries.CREATE_TIME)){


			st1.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			st1.setInt(2,id);
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
