package model.dao.impl.jdbc.mapper;

import model.dao.impl.jdbc.util.ParseDate;
import model.entity.Deposit;
import model.entity.enums.Deposits;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class DepositMapper implements ObjectMapper<Deposit> {

    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public Deposit extractFromResultSet(ResultSet rs) throws SQLException {
        Deposit deposit = new Deposit();
        deposit.setIdDep(rs.getInt("id_dep"));
        deposit.setIdAcc(rs.getInt("id_ac"));
        deposit.setMoney(rs.getLong("dep_money"));
        deposit.setPercent(rs.getInt("dep_percent"));
        String stringType = rs.getString("dep_type");
        deposit.setType((stringType == null || stringType.equals("")) ? null : Deposits.valueOf(stringType.toUpperCase()));
        deposit.setReceivedMoney(rs.getLong("received_money"));
        deposit.setStartDate(new ParseDate().parseDate(rs.getString("start_date")));

        return deposit;
    }

    @Override
    public Deposit makeUnique(Map<Integer, Deposit> cache, Deposit entity) {
        cache.putIfAbsent(entity.getIdDep(), entity);
        return cache.get(entity.getIdDep());
    }


}
