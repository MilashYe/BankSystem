package controller.command.impl.user;

import controller.command.Command;
import model.entity.User;
import model.service.AccountUtil;
import model.service.UserUtil;

import javax.servlet.http.HttpServletRequest;

public class AccountDeleteCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        proccess(request);
        return "/WEB-INF/view/user/userInfo.jsp";
    }

    private void proccess(HttpServletRequest request) {
        int accId = Integer.parseInt(request.getParameter("acId"));
        new AccountUtil().deleteAccountById(accId);
        User user = (User) request.getSession().getAttribute("user");
        request.getSession().setAttribute("user", new UserUtil().readUserById(user.getId()));

    }
}
