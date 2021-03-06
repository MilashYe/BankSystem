package controller.command.impl.pages;

import controller.command.Command;
import model.entity.User;
import model.service.UserUtil;

import javax.servlet.http.HttpServletRequest;

public class PayBillsPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        User user =
                new UserUtil().
                        readUserById(
                                ((User) request.getSession().getAttribute("user")).
                                        getId());
        request.getSession().setAttribute("user",new UserUtil().readUserById(user.getId()));

        return "/WEB-INF/view/user/payBill.jsp";
    }

}
