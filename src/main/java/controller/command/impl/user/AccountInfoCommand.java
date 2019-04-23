package controller.command.impl.user;

import controller.command.Command;
import model.service.AccountUtil;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class AccountInfoCommand implements Command {
    private Logger log = Logger.getLogger(this.getClass());
    @Override
    public String execute(HttpServletRequest request) {
        process(request);
        return "/WEB-INF/view/user/account.jsp";
    }

    private void process(HttpServletRequest request) {
        log.info("Acount info command acId="+request.getSession().getAttribute("acId"));
        Optional<String> optionalAcc =
                Optional.ofNullable(request.getParameter("acId"));
        int accountId = Integer.parseInt(optionalAcc.orElse((String) request.getSession().getAttribute("acId")));
        request.setAttribute("account", new AccountUtil().readById(accountId));


    }
}
