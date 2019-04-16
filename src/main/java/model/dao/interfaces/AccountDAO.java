package model.dao.interfaces;

import model.dao.GenericDAO;
import model.entity.Account;

import java.sql.SQLException;

public interface AccountDAO extends GenericDAO<Account> {
    void addAccountToUser(int accountId, int userId);

    void addTime(int accountId, String message) throws SQLException;

    void startTransaction();

    void endTransaction();

    void rollbackTransactio();
}
