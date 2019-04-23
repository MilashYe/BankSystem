package controller.command.impl.pages;

import controller.command.Command;
import model.entity.User;
import model.service.UserUtil;

import javax.servlet.http.HttpServletRequest;

public class UserMainPage implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        user = new UserUtil().updateUser(user);
        request.getSession().setAttribute("user", user);
        return "/WEB-INF/view/user/mainUsr.jsp";
    }
}
