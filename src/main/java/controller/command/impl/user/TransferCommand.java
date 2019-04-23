package controller.command.impl.user;

import controller.command.Command;
import model.entity.User;
import model.exception.NotEnoughtMoneyException;
import model.exception.WrongDestinationAccountException;
import model.service.AccountUtil;
import model.service.UserUtil;

import javax.servlet.http.HttpServletRequest;

public class TransferCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        return proccess(request);
    }

    private String proccess(HttpServletRequest request) {
        try {
            new AccountUtil().transferBetweenAccounts(
                    Integer.parseInt(request.getParameter("account1")),
                    Integer.parseInt(request.getParameter("account2")),
                    (int) Long.parseLong(request.getParameter("money")));
        } catch (NotEnoughtMoneyException ex) {
            request.getSession().setAttribute("exception", "Not enought money");
            return "redirect:/bank/user/transferPage";
        } catch (WrongDestinationAccountException ex) {
            request.getSession().setAttribute("exception", ex.getMessage());
            return "redirect:/bank/user/transferPage";
        }
        User user = (User) request.getSession().getAttribute("user") ;
        user = new UserUtil().updateUser(user);
        request.setAttribute("success","Successfully");
        request.getSession().setAttribute("user",user);
        return "redirect:/bank/user/userMain";
    }
}
