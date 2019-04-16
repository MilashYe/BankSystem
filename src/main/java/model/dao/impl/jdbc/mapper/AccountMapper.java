package model.dao.impl.jdbc.mapper;

import model.entity.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class AccountMapper implements ObjectMapper<Account> {

    @Override
    public Account extractFromResultSet(ResultSet rs) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id_ac"));
        account.setMoney(rs.getLong("ac_money"));
        account.setClosed(rs.getBoolean("closed"));
        return account;
    }

    @Override
    public Account makeUnique(Map<Integer, Account> cache, Account account) {
        cache.putIfAbsent(account.getId(), account);
        return cache.get(account.getId());
    }
}
