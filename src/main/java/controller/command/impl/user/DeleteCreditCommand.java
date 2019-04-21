package controller.command.impl.user;

import controller.command.Command;
import model.entity.Credit;
import model.entity.User;
import model.service.AccountUtil;
import model.service.CreditUtil;
import model.service.UserUtil;

import javax.servlet.http.HttpServletRequest;

public class DeleteCreditCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        proccess(request);
        return "/WEB-INF/view/user/account.jsp";
    }

    private void proccess(HttpServletRequest request) {
        int creditId = Integer.parseInt(request.getParameter("credId"));
        Credit credit = new CreditUtil().readById(creditId);
        new CreditUtil().setDisapprovedCreditById(creditId);

        request.setAttribute("account",new AccountUtil().readById(credit.getAccount()));

        User user = new UserUtil().updateUser((User)request.getSession().getAttribute("user"));
        request.getSession().setAttribute("user",user);
    }
}
