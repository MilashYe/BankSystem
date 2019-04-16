package model.dao.impl.jdbc.mapper;

import model.entity.Credit;
import model.entity.enums.Credits;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CreditMapper implements ObjectMapper<Credit> {

    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public Credit extractFromResultSet(ResultSet rs) throws SQLException {
        Credit credit = new Credit();
        credit.setIdCred(rs.getInt("id_cr"));
        credit.setAccount(rs.getInt("id_ac"));
        credit.setMoney(rs.getLong("cred_money"));
        credit.setPercent(rs.getInt("cred_percent"));
        String stringType = rs.getString("cred_type");
        credit.setType(stringType == null  || stringType.equals("") ? null : Credits.valueOf(stringType.toUpperCase()));
        credit.setTermToClose(rs.getInt("term_close"));
        credit.setApproved(rs.getBoolean("approved"));
        credit.setRejected(rs.getBoolean("rejected"));

        return credit;
    }

    @Override
    public Credit makeUnique(Map<Integer, Credit> cache, Credit entity) {
        cache.putIfAbsent(entity.getIdCred(), entity);
        return cache.get(entity.getIdCred());
    }
}
