package model.service;

import model.dao.DAOFactory;
import model.dao.interfaces.CreditDAO;
import model.entity.Credit;
import model.entity.enums.Credits;
import org.apache.log4j.Logger;

public class CreditUtil {
    private Logger log = Logger.getLogger(this.getClass());

    public void setDisapprovedCreditById(int id) {
        try(CreditDAO dao = DAOFactory.getInstance().createCreditDAO()){
            Credit credit = dao.readById(id);
            credit.setApproved(false);
            dao.update(credit);
            log.info("credit was disapproved " + dao.readById(id));
        }


    }

    public Credit readById(int creditId) {
        try (CreditDAO dao = DAOFactory.getInstance().createCreditDAO()) {
            return dao.readById(creditId);
        }

    }

    public void createCredit(int accountId, long money, Credits loanType, int hypothecTerm, int countOfPayments) {
        int term;
        if (loanType.equals(Credits.CREDIT_CARD)) {
            term = 12;
        } else if (loanType.equals(Credits.HYPOTHEC)) {
            term = hypothecTerm;
        } else {
            term = countOfPayments;
        }

        Credit credit = new Credit();
        credit.setAccount(accountId);
        credit.setMoney(money * 100);
        credit.setPercent(loanType.getPercent());
        credit.setType(loanType);
        credit.setTermToClose(term);
        credit.setApproved(false);
        credit.setRejected(false);
        try (CreditDAO dao = DAOFactory.getInstance().createCreditDAO()) {
            dao.create(credit);
        }
    }
}
