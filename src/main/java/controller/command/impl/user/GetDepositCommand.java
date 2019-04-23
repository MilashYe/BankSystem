package controller.command.impl.user;

import controller.command.Command;
import model.entity.User;
import model.entity.enums.Deposits;
import model.service.DepositUtil;
import model.service.UserUtil;

import javax.servlet.http.HttpServletRequest;

public class GetDepositCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        proccess(request);
        return "redirect:/bank/user/accountInfo";
    }

    private void proccess(HttpServletRequest request) {

        int accountId = Integer.parseInt(request.getParameter("accountNumber"));
        Deposits depositType = Deposits.valueOf(request.getParameter("depositType").toUpperCase());
        long money = Long.parseLong(request.getParameter("inputMoney"));
        int standartTerm = Integer.parseInt(request.getParameter("standartTerm"));

        new DepositUtil().createDeposit(accountId, depositType, money, standartTerm);

        User user = new UserUtil().updateUser((User)request.getSession().getAttribute("user"));
        request.getSession().setAttribute("user",user);
        request.getSession().setAttribute("acId",""+accountId);
    }
}
