package controller.command.impl.user;

import controller.command.Command;
import model.entity.User;
import model.entity.enums.Credits;
import model.service.CreditUtil;
import model.service.UserUtil;

import javax.servlet.http.HttpServletRequest;

public class GetLoanCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        process(request);
        return "/WEB-INF/view/user/success.jsp";
    }

    private void process(HttpServletRequest request) {
        System.out.println(request.getParameter("accountNumber"));
        int accountId = Integer.parseInt(request.getParameter("accountNumber"));
        Credits loanType = Credits.valueOf(request.getParameter("creditType").toUpperCase());
        long money = Long.parseLong(request.getParameter("inputMoney"));
        int hypothecTerm = Integer.parseInt(request.getParameter("hypothec_term_close"));
        int installmentCount = Integer.parseInt(request.getParameter("count_of_payment"));

        new CreditUtil().createCredit(accountId, money, loanType, hypothecTerm, installmentCount);

        User oldUser = (User) request.getSession().getAttribute("user");
        request.getSession().
                setAttribute("user", new UserUtil().readUserById(oldUser.getId()));


    }
}
