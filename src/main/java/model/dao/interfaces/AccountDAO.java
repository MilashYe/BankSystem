package model.dao.interfaces;

import model.dao.GenericDAO;
import model.entity.Account;

public interface AccountDAO extends GenericDAO<Account> {
    void addAccountToUser(int accountId, int userId);

    void addTime(int accountId, String message);
}
