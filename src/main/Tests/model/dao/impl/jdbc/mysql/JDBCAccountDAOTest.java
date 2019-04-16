package model.dao.impl.jdbc.mysql;

import model.dao.DAOFactory;
import model.dao.interfaces.AccountDAO;
import model.entity.Account;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class JDBCAccountDAOTest {

    private AccountDAO dao = DAOFactory.getInstance().createAccountDAO();
    private static Account testAccount = new Account();


    @BeforeClass
    public static void init() {
        testAccount.setMoney(13);
        testAccount.setClosed(false);

    }

    @Test
    public void createAndReadById() {
        dao.create(testAccount);
        Account readAcc = dao.readById(testAccount.getId());
        dao.addAccountToUser(testAccount.getId(),1);
        dao.delete(testAccount);
        System.out.println( dao.readById(2));
        assertEquals(testAccount.getId(), readAcc.getId());
        assertEquals(testAccount.getMoney(), readAcc.getMoney());
        assertEquals(testAccount.isClosed(), readAcc.isClosed());
    }

    @Test
    public void readAll() {
        dao.create(testAccount);
        ArrayList<Account> accounts = (ArrayList<Account>) dao.readAll();
        dao.delete(testAccount);
        for (Account account : accounts) {
            System.out.println(account);
        }

    }

    @Test
    public void delete() {
        dao.create(testAccount);
        dao.delete(testAccount);
        Account account = dao.readById(testAccount.getId());
        assertNull(account);
    }

    @Test
    public void update() {
        dao.create(testAccount);
        Account readAcc = dao.readById(testAccount.getId());
        readAcc.setMoney(1234);
        dao.update(readAcc);
        assertEquals(1234,dao.readById(testAccount.getId()).getMoney());
    }

    @Test
    public void transactionTest() {
        dao.startTransaction();
        dao.create(testAccount);
    }
}