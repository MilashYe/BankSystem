package controller.command.impl.pages;

import controller.command.Command;
import model.entity.User;
import model.service.UserUtil;

import javax.servlet.http.HttpServletRequest;

public class TransferPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        User user = ((User) request.getSession().getAttribute("user"));
        request.getSession().setAttribute("user",new UserUtil().readUserById(user.getId()));
        request.setAttribute("info",request.getSession().getAttribute("exception"));
        request.getSession().removeAttribute("exception");
        return "/WEB-INF/view/user/bankTransfer.jsp";
    }
}
