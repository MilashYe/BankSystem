package controller.command.impl.user;

import controller.command.Command;
import model.entity.User;
import model.service.AccountUtil;
import model.service.UserUtil;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class OpenAccountCommand implements Command {
    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public String execute(HttpServletRequest request) {
        process(request);
        return "redirect:/bank/user/userInfo";
    }

    private void process(HttpServletRequest request) {
        log.info("Account create command ");
        int userId = ((User) request.getSession().getAttribute("user")).getId();
        request.setAttribute("account", new AccountUtil().createAccount(userId));

        User user = new UserUtil().updateUser((User)request.getSession().getAttribute("user"));
        request.getSession().setAttribute("user",user);
    }
}
