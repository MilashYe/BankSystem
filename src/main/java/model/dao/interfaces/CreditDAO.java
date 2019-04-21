package model.dao.interfaces;

import model.dao.GenericDAO;
import model.entity.Credit;

public interface CreditDAO extends GenericDAO<Credit> {
    void createTime(int accId, String mess);

    void startTransaction();

    void endTransaction();

    void rollbackTransaction();
}
