package controller.command.impl.user;

import controller.command.Command;
import model.entity.User;
import model.service.AccountUtil;
import model.service.UserUtil;

import javax.servlet.http.HttpServletRequest;

public class TransferCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        proccess(request);
        return "redirect:/bank/user/userMain";
    }

    private void proccess(HttpServletRequest request) {
        new AccountUtil().transferBetweenAccounts(
                Integer.parseInt(request.getParameter("account1")),
                Integer.parseInt(request.getParameter("account2")),
                Integer.parseInt(request.getParameter("money")));
        User user = (User) request.getSession().getAttribute("user");
        request.getSession().setAttribute("user", new UserUtil().readUserById(user.getId()));

    }
}
