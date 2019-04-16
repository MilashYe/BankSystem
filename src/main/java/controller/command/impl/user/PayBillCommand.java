package controller.command.impl.user;

import controller.command.Command;
import model.entity.User;
import model.exception.NotEnoughtMoneyException;
import model.service.AccountUtil;
import model.service.UserUtil;

import javax.servlet.http.HttpServletRequest;

public class PayBillCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return proccess(request);

    }

    private String proccess(HttpServletRequest request) {
        try {
            new AccountUtil().payBillByNumber(
                    Integer.parseInt(request.getParameter("account1")),
                    Integer.parseInt(request.getParameter("account2")),
                    Integer.parseInt(request.getParameter("money"))
            );
        }catch (NotEnoughtMoneyException ex) {
            request.setAttribute("info","Not enought money");
            return "/WEB-INF/view/user/payBill.jsp";
        }

        User user = new UserUtil().updateUser((User)request.getSession().getAttribute("user"));
        request.getSession().setAttribute("user",user);
        return "redirect:/bank/user/userMain";
    }
}
