package controller.command.impl.admin;

import controller.command.Command;
import model.exception.UserToAccountException;
import model.service.AccountUtil;

import javax.servlet.http.HttpServletRequest;

public class AddUserToAccountCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("selectUser"));
        int accountId = Integer.parseInt(request.getParameter("selectAccount"));
        try{
            new AccountUtil().addUserToAccount(userId, accountId);
            request.getSession().setAttribute("successAddUser","Success added");

        } catch (UserToAccountException e) {
            request.getSession().setAttribute("alertAddUser",e.getMessage());
        }
        return "redirect:/bank/admin/addUsers";
    }
}
