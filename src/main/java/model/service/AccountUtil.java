package model.service;

import model.dao.DAOFactory;
import model.dao.interfaces.AccountDAO;
import model.entity.Account;
import model.entity.Credit;
import model.entity.Deposit;
import model.exception.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AccountUtil {

    private static final Logger log = Logger.getLogger(AccountUtil.class);

    public ArrayList<Account> readAccounts() {
        try (AccountDAO dao = DAOFactory.getInstance().createAccountDAO()) {
            return (ArrayList<Account>) dao.readAll();
        }
    }

    public Account readById(int id) {
        try (AccountDAO dao = DAOFactory.getInstance().createAccountDAO()) {
            Account account = dao.readById(id);
            account = showForUser(account);
            return account;
        }
    }

    public Account showForUser(Account account) {
        account.setCredits(
                account.getCredits().
                        stream().
                        filter(Credit::isApproved).
                        filter(o1->!o1.isRejected()).
                        collect(Collectors.toList()));
        account.setDeposits(
                account.getDeposits().
                        stream().
                        filter(o1 -> o1.getIdDep()!=0).
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

    public Account createAccount(int userId) {
        try (AccountDAO dao = DAOFactory.getInstance().createAccountDAO()) {
            Account account = new Account();
            account.setMoney(0);
            account.setClosed(false);
            try {
                dao.startTransaction();
                dao.create(account);
                dao.addAccountToUser(account.getId(), userId);
                account = dao.readById(account.getId());
                account = showForUser(account);
                dao.endTransaction();
            } catch (AccountNotCreateException e) {
                log.info(e.getMessage());
                dao.rollbackTransactio();
            }

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
            Account account2;
            if (id1 == id2) {
                throw new WrongDestinationAccountException("Change destination account");
            } else {
                account2 = dao.readById(id2);
            }
            if (account1.getMoney() < new MoneyUtil().convertDown(money)) {
                throw new NotEnoughtMoneyException("Sorry you have not enought money");
            } else {
                try {
                    account1.setMoney(account1.getMoney() - new MoneyUtil().convertDown(money));
                    account2.setMoney(account2.getMoney() + new MoneyUtil().convertDown(money));
                    dao.startTransaction();
                    dao.addTime(id1, "Money("+money+"₴) were sent to " + account2.getId() + " account");
                    dao.addTime(id2, "Money("+money+"₴) were get from " + account1.getId() + " account");
                    dao.update(account1);
                    dao.update(account2);
                    dao.endTransaction();
                } catch (AccountNotUpdateException e) {
                    log.info("transaction in transfer was rolled back" + e.getMessage());
                    dao.rollbackTransactio();
                }
            }

        }
    }

    public void payBillByNumber(int id, String billNumber, int money) {
        try (AccountDAO dao = DAOFactory.getInstance().createAccountDAO()) {
            Account account1 = dao.readById(id);
            if (account1.getMoney() < new MoneyUtil().convertDown(money)) {
                throw new NotEnoughtMoneyException("Sorry you have not enought money");
            } else {
                account1.setMoney(account1.getMoney() - new MoneyUtil().convertDown(money));
                try {
                    dao.startTransaction();
                    dao.addTime(id, "Money("+money+"₴) were sent to " + billNumber + " bill");
                    dao.update(account1);
                    dao.endTransaction();
                } catch (AccountNotUpdateException e) {
                    log.info("transaction in transfer was rolled back" + e.getMessage());
                    dao.rollbackTransactio();
                }
            }

        }
    }

    public ArrayList<Account> getNotClosed(ArrayList<Account> accounts) {
        return (ArrayList<Account>) accounts.stream().
                filter(o1 -> !o1.isClosed()).
                collect(Collectors.toList());
    }

    public void addUserToAccount(int userId, int accountId) {
        try (AccountDAO dao = DAOFactory.getInstance().createAccountDAO()) {
            dao.startTransaction();
            dao.addAccountToUser(accountId, userId);
            dao.endTransaction();
        } catch (UserToAccountException e) {
            log.info("User already added");
            throw new UserToAccountException("User already added");
        }
    }
}
