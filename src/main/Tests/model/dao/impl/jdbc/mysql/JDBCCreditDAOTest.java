package model.dao.impl.jdbc.mysql;

import model.dao.DAOFactory;
import model.dao.interfaces.CreditDAO;
import model.entity.Credit;
import model.entity.enums.Credits;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class JDBCCreditDAOTest {

    private static CreditDAO dao = DAOFactory.getInstance().createCreditDAO();
    private static Credit testCredit = new Credit();

    @BeforeClass
    public static void init() {
        testCredit.setMoney(12345);
        testCredit.setPercent(35);
        testCredit.setType(Credits.INSTALLMENT_PLAN);
        testCredit.setTermToClose(8);
        testCredit.setAccount(72);

    }

    @Test
    public void createAndReadById() {
        dao.create(testCredit);
        Credit credit = dao.readById(testCredit.getIdCred());
        //dao.delete(testCredit);
        assertEquals(testCredit,credit);
    }

    @Test
    public void readAll() {
    }

    @Test
    public void delete() {
        dao.create(testCredit);
        dao.delete(testCredit);
        assertNull(dao.readById(testCredit.getIdCred()));
    }
}