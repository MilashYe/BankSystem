package model.service;

import model.dao.DAOFactory;
import model.dao.interfaces.AccountDAO;
import model.entity.Account;
import model.entity.ChangeTime;
import model.entity.Credit;
import model.entity.Deposit;

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
        account.getChangeTime().stream().
                sorted(Comparator.comparing(ChangeTime::getChangeTime)).
                collect(Collectors.toList());
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
            return account;
        }
    }

    public void deleteAccountById(int accId) {
        try (AccountDAO dao = DAOFactory.getInstance().createAccountDAO()) {
            Account account = dao.readById(accId);
            dao.delete(account);
        }
    }
}
