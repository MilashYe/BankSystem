package model.service;

import model.dao.DAOFactory;
import model.dao.interfaces.AccountDAO;
import model.entity.Account;
import model.entity.ChangeTime;
import model.entity.Credit;
import model.entity.Deposit;
import model.exception.NotEnoughtMoneyException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class AccountUtil {

    public ArrayList<Account> readAccounts() {
        try (AccountDAO dao = DAOFactory.getInstance().createAccountDAO()) {

            return (ArrayList<Account>) dao.readAll();
        }
    }

    public Account readById(int id) {

        try (AccountDAO dao = DAOFactory.getInstance().createAccountDAO()) {
            Account account = dao.readById(id);
            account = getApprovedCredit(account);
            account = getNotEmptyDeposits(account);
            account = sortDate(account);
            return account;
        }


    }

    public Account getApprovedCredit(Account account) {
        account.setCredits(
                account.getCredits().
                        stream().
                        filter(Credit::isApproved).
                        collect(Collectors.toList()));
        System.out.println(account);

        return account;

    }

    public Account getNotEmptyDeposits(Account account) {
        account.setDeposits(
                account.getDeposits().
                        stream().filter(deposit -> deposit.getMoney() != 0).
                        collect(Collectors.toList()));
        return account;
    }

    public void transferMoneyFromDeposit(Deposit deposit) {
        try (AccountDAO accDao = DAOFactory.getInstance().createAccountDAO()) {
            Account account = accDao.readById(deposit.getIdAcc());
            account.setMoney(account.getMoney()+deposit.getMoney()+deposit.getReceivedMoney());
            accDao.update(account);
        }
    }

    public Account sortDate(Account account) {
        account.setChangeTime(
                account.getChangeTime().stream().
                        sorted(Comparator.comparing(ChangeTime::getChangeTime)).
                        collect(Collectors.toList()));

        return account;
    }

    public Account createAccount(int userId) {
        try (AccountDAO dao = DAOFactory.getInstance().createAccountDAO()) {
            Account account = new Account();
            account.setMoney(0);
            account.setClosed(false);
            dao.create(account);
            dao.addAccountToUser(account.getId(),userId);
            account = dao.readById(account.getId());
            account = getNotEmptyDeposits(account);
            account = getApprovedCredit(account);
            account = sortDate(account);
            return account;
        }
    }

    public void setClosedAccountById(int accId) {
        try (AccountDAO dao = DAOFactory.getInstance().createAccountDAO()) {
            Account account = dao.readById(accId);
            account.setClosed(true);
            dao.update(account);
        }
    }

    public void transferBetweenAccounts(int id1, int id2, int money) throws NotEnoughtMoneyException {
        try (AccountDAO dao = DAOFactory.getInstance().createAccountDAO()) {
            Account account1 = dao.readById(id1);
            Account account2 = dao.readById(id2);
            if (account1.getMoney() < money * 100) {
                throw new NotEnoughtMoneyException("Sorry you have not enought money");
            } else {
                account1.setMoney(account1.getMoney() - new MoneyUtil().convertDown(money));
                account2.setMoney(account2.getMoney() + new MoneyUtil().convertDown(money));
                dao.addTime(id1, "Money were sent to " + account2.getId() + " account");
                dao.addTime(id2, "Money were get from " + account1.getId() + " account");
                dao.update(account1);
                dao.update(account2);

            }

        }
    }
}
