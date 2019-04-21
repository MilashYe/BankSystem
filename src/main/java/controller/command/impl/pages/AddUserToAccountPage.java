package controller.command.impl.pages;

import controller.command.Command;
import model.entity.Account;
import model.entity.User;
import model.service.AccountUtil;
import model.service.UserUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class AddUserToAccountPage implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        ArrayList<User> users = new UserUtil().readOnlyUsers();
        ArrayList<Account> accounts = new AccountUtil().readAccounts();
        accounts = new AccountUtil().getNotClosed(accounts);
        request.setAttribute("users", users);
        request.setAttribute("accounts", accounts);
        request.setAttribute("alert",request.getSession().getAttribute("alertAddUser"));
        request.setAttribute("success",request.getSession().getAttribute("successAddUser"));
        request.getSession().removeAttribute("alertAddUser");
        request.getSession().removeAttribute("successAddUser");
        return "/WEB-INF/view/admin/addUserToAccount.jsp";
    }
}
