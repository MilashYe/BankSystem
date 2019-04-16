package controller.command.impl.user;

import controller.command.Command;
import model.entity.Account;
import model.service.AccountUtil;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class AccountInfoCommand implements Command {
    private Logger log = Logger.getLogger(this.getClass());
    @Override
    public String execute(HttpServletRequest request) {
        process(request);
        return "/WEB-INF/view/user/account.jsp";
    }

    private void process(HttpServletRequest request) {
        log.info("Acount info command acId="+request.getParameter("acId"));
        int accountId = Integer.parseInt(request.getParameter("acId"));
        Account readAccount = new AccountUtil().readById(accountId);
       /* readAccount = new AccountUtil().getApprovedCredit(readAccount);
        readAccount = new AccountUtil().getNotEmptyDeposits(readAccount);
        */request.setAttribute("account", new AccountUtil().sortDate(readAccount));

    }
}
