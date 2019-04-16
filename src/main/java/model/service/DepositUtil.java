package model.service;

import model.dao.DAOFactory;
import model.dao.interfaces.DepositDAO;
import model.entity.Deposit;
import model.entity.enums.Deposits;
import org.apache.log4j.Logger;

import java.util.Date;
public class DepositUtil {

    private Logger log = Logger.getLogger(this.getClass());


    public void deleteDepositById(int id) {

        try (DepositDAO dao = DAOFactory.getInstance().createDepositDAO()) {
            Deposit deposit = dao.readById(id);
            log.info("deposit which willb be delete "+deposit);
            new AccountUtil().transferMoneyFromDeposit(deposit);
            dao.delete(deposit);
            log.info("Deposit was deleted, must be 'null' " + dao.readById(id));

        }
    }

    public Deposit readById(int depositId) {
        try (DepositDAO dao = DAOFactory.getInstance().createDepositDAO()) {
            return dao.readById(depositId);
        }

    }

    public void createDeposit(int accountId, Deposits depositType, long money, int standartTerm) {

        int term;
        if (depositType.equals(Deposits.STANDART)) {
            term = standartTerm;
        } else {
            term = 12;
        }
        Deposit deposit = new Deposit();
        deposit.setIdAcc(accountId);
        deposit.setType(depositType);
        deposit.setPercent(depositType.getPercent());
        deposit.setMoney(money*100);
        deposit.setEndTime(term);
        deposit.setStartDate(new Date());

        try (DepositDAO dao = DAOFactory.getInstance().createDepositDAO()) {
            dao.create(deposit);
        }
    }
}
