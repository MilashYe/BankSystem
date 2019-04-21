package controller.command.impl.user;

import controller.command.Command;
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
        request.setAttribute("account", new AccountUtil().readById(accountId));

    }
}
