package controller.command.impl.user;

import controller.command.Command;
import model.service.AccountUtil;

import javax.servlet.http.HttpServletRequest;

public class AccountDeleteCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        proccess(request);
        return "redirect:/bank/user/userInfo";
    }

    private void proccess(HttpServletRequest request) {
        int accId = Integer.parseInt(request.getParameter("acId"));
        new AccountUtil().setClosedAccountById(accId);
    }
}
