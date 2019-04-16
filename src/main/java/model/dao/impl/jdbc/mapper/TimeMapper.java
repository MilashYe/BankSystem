package model.dao.impl.jdbc.mapper;

import model.dao.impl.jdbc.util.ParseDate;
import model.entity.ChangeTime;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class TimeMapper implements ObjectMapper<ChangeTime> {
    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public ChangeTime extractFromResultSet(ResultSet rs) throws SQLException {
        ChangeTime time = new ChangeTime();
        time.setIdTime(rs.getInt("id_time"));
        time.setAcId(rs.getInt("account_id_ac"));
        time.setMessage(rs.getString("mess"));
        time.setChangeTime(new ParseDate().parseDate(rs.getString("date")));

        return time;
    }

    @Override
    public ChangeTime makeUnique(Map<Integer, ChangeTime> cache, ChangeTime entity) {
        cache.putIfAbsent(entity.getIdTime(), entity);
        return cache.get(entity.getIdTime());
    }



}
