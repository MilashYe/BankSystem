package model.dao.impl.jdbc.mysql;

import model.dao.impl.jdbc.mapper.TimeMapper;
import model.dao.interfaces.TimeDao;
import model.entity.ChangeTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTimeDao implements TimeDao {

    private final Connection connection;

    public JDBCTimeDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(ChangeTime entity) {

    }

    @Override
    public ChangeTime readById(int id) {
        return null;
    }

    @Override
    public List<ChangeTime> readAll() {
        Map<Integer, ChangeTime> timeMap = new HashMap<>();
        try(PreparedStatement statement = connection.prepareStatement(SQLQueries.READ_TIME_ALL)) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                ChangeTime time = new TimeMapper().extractFromResultSet(set);
                new TimeMapper().makeUnique(timeMap, time);
            }
            return new ArrayList<>(timeMap.values());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(ChangeTime entity) {

    }

    @Override
    public void delete(ChangeTime entity) {

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
    public int getPageCount(int timePerPage) {
        try (PreparedStatement statement = connection.prepareStatement(SQLQueries.GET_TIME_COUNT)) {
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                return set.getInt(1) / timePerPage+1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<ChangeTime> getPage(int offset, int length) {
        List<ChangeTime> time = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(SQLQueries.GET_TIME_IN_RANGE)) {
            statement.setInt(1, offset);
            statement.setInt(2, length);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                time.add(new TimeMapper().extractFromResultSet(set));
            }
            return time;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
