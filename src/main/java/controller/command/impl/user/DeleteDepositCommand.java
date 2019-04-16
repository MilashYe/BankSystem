package controller.command.impl.user;

import controller.command.Command;
import model.entity.Account;
import model.entity.Deposit;
import model.entity.User;
import model.service.AccountUtil;
import model.service.DepositUtil;
import model.service.UserUtil;

import javax.servlet.http.HttpServletRequest;

public class DeleteDepositCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        proccess(request);
        return "/WEB-INF/view/user/account.jsp";
    }

    private void proccess(HttpServletRequest request) {
        int depositId = Integer.parseInt(request.getParameter("depId"));
        Deposit deposit = new DepositUtil().readById(depositId);
        new DepositUtil().deleteDepositById(depositId);
        Account account = new AccountUtil().readById(deposit.getIdAcc());
       /* account = new AccountUtil().getApprovedCredit(account);
        account = new AccountUtil().getNotEmptyDeposits(account);
*/
        User oldUser = (User) request.getSession().getAttribute("user");
        request.setAttribute("account", new AccountUtil().sortDate(account));
        request.getSession().
                setAttribute("user", new UserUtil().readUserById(oldUser.getId()));
        request.setAttribute("acId", account.getId());


    }
}
